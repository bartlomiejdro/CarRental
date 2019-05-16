package com.demo.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.common.domain.CarTO;
import com.demo.common.enums.CarType;
import com.demo.persistence.dao.CarDao;
import com.demo.persistence.dao.EmployeeDao;
import com.demo.persistence.dao.RentalDao;
import com.demo.persistence.entity.CarEntity;
import com.demo.persistence.entity.EmployeeEntity;
import com.demo.persistence.entity.RentalEntity;
import com.demo.service.CarService;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	private CarDao carRepository;
	@Autowired
	private EmployeeDao employeeRepository;
	@Autowired
	private RentalDao rentalRepository;

	@Override
	public CarTO save(CarTO carTo) {
		CarEntity car = carRepository.save(new CarEntity(carTo));
		return new CarTO(car);
	}

	@Override
	public CarTO findCarById(Long carId) {
		CarEntity result = carRepository.findOne(carId);
		return result == null ? null : new CarTO(result);
	}
	
	@Override
	public void delete(CarEntity carEntity) {
		deleteReferencesFromEmployeeToCar(carEntity);
		removeRents(carEntity.getId());
		carRepository.delete(carEntity);
	}
	
	@Transactional
	private void deleteReferencesFromEmployeeToCar(CarEntity carEntity) {
		List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
		for (EmployeeEntity employeeEntity : employeeEntities) {
			employeeEntity.getCars().remove(carEntity);
			employeeRepository.getEM().merge(employeeEntity);
		}
	} 
	
	private void removeRents(Long carId) {
		List<RentalEntity> rentsToRemove = rentalRepository.findRentsByCar(carId);
		for (RentalEntity rent : rentsToRemove) {
			rentalRepository.delete(rent);
		} 
	}
	
	@Override
	public Set<CarTO> findCarByTypeAndModel(CarType carType, String mark) {
		Set<CarEntity> carsByTypeAndModel = carRepository.findCarByTypeAndModel(carType, mark);
		Set<CarTO> findCarByTypeAndModelTO = new HashSet();
		carsByTypeAndModel.stream().forEach(c -> findCarByTypeAndModelTO.add(new CarTO(c)));
		return findCarByTypeAndModelTO;
	}

	@Override
	public CarTO update(CarTO carTo) {
		CarEntity car = new CarEntity(carTo);
		carRepository.update(car);		
		CarTO carToResult = new CarTO(car);
		return carToResult;
	}
	
	@Override
	public void setCarToHandler(Long employeeId, CarTO carTo) {
		EmployeeEntity employee = employeeRepository.findOne(employeeId);
		CarEntity car = new CarEntity(carTo);
		employee.getCars().add(car);
		employeeRepository.save(employee);	
	}
}
