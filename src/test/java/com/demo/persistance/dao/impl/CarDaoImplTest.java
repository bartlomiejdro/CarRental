package com.demo.persistance.dao.impl;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.demo.common.enums.CarType;
import com.demo.common.enums.Position;
import com.demo.persistence.dao.AdressDao;
import com.demo.persistence.dao.CarDao;
import com.demo.persistence.dao.CustomerDao;
import com.demo.persistence.dao.DepartamentDao;
import com.demo.persistence.dao.EmployeeDao;
import com.demo.persistence.entity.AdressEntity;
import com.demo.persistence.entity.CarEntity;
import com.demo.persistence.entity.DepartamentEntity;
import com.demo.persistence.entity.EmployeeEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class CarDaoImplTest {

	@PersistenceContext
	private EntityManager manager;

	@Autowired
	CarDao carRepository;
	@Autowired
	DepartamentDao departamentRepository;
	@Autowired
	EmployeeDao employeeRepository;
	@Autowired
	AdressDao adressRepository;
	@Autowired
	CustomerDao customerRepository;

	private EmployeeEntity employee1;
	private EmployeeEntity employee2;
	private AdressEntity adress1;
	private DepartamentEntity dep1;
	private DepartamentEntity dep2;
	private CarEntity car1;
	private CarEntity car2;
	private CarEntity car3;
	private CarEntity car4;
	private CarEntity car5;
	private CarEntity car6;
	private CarEntity car7;
	private CarEntity car8;
	private CarEntity car9;
	private CarEntity car10;
	private Set<CarEntity> cars1 = new HashSet();
	private Set<CarEntity> cars2 = new HashSet();

	
	@Before
	public void loadData() {

		adress1 = new AdressEntity("Strzegomska", "55-601", "Wroclaw", "Polska");
		adressRepository.save(adress1);
		dep1 = new DepartamentEntity(adress1, "1234", "dep1@wp.pl");
		dep2 = new DepartamentEntity(adress1, "12345", "dep2@wp.pl");
		departamentRepository.save(dep1);
		departamentRepository.save(dep2);

		car1 = new CarEntity("Skoda", "Oktavia", "red", CarType.HATCHBACK, 1600, 100, 2012, 90000);
		car2 = new CarEntity("Skoda", "Fabia", "black", CarType.HATCHBACK, 1400, 90, 2014, 60000);
		car3 = new CarEntity("Mazda", "6", "blue", CarType.SEDAN, 1998, 140, 2016, 40000);
		car4 = new CarEntity("Ford", "Edge", "green", CarType.SUV, 2500, 160, 2018, 25000);
		car5 = new CarEntity("Peugot", "306", "black", CarType.HATCHBACK, 1400, 90, 2014, 60000);
		car6 = new CarEntity("Skoda", "Oktavia", "red", CarType.HATCHBACK, 1600, 100, 2012, 90000);
		car7 = new CarEntity("Skoda", "Fabia", "black", CarType.HATCHBACK, 1400, 90, 2014, 60000);
		car8 = new CarEntity("Mazda", "6", "blue", CarType.SEDAN, 1998, 140, 2016, 40000);
		car9 = new CarEntity("Ford", "Edge", "green", CarType.SUV, 2500, 160, 2018, 25000);
		car10 = new CarEntity("Peugot", "306", "black", CarType.HATCHBACK, 1400, 90, 2014, 60000);

		carRepository.save(car1);
		carRepository.save(car2);
		carRepository.save(car3);
		carRepository.save(car4);
		carRepository.save(car5);
		carRepository.save(car6);
		carRepository.save(car7);
		carRepository.save(car8);
		carRepository.save(car9);
		carRepository.save(car10);

		cars1.add(car1);
		cars1.add(car2);
		cars1.add(car5);

		employee1 = new EmployeeEntity("firstName1", "surName1", Position.ACCOUNTANT, dep1, cars1,
				LocalDate.of(1989, 11, 24));
		employee2 = new EmployeeEntity("firstName2", "surName2", Position.MENAGER, dep1, cars2,
				LocalDate.of(1989, 11, 24));
		employeeRepository.save(employee1);
		employeeRepository.save(employee2);
	}

	@Test
	public void shouldFindSetOfCarsByTypeAndModel() {
		// when
		Set<CarEntity> result = carRepository.findCarByTypeAndModel(CarType.HATCHBACK, "Skoda");

		// then
		assertEquals(4, result.size());
	}

	@Test
	public void shouldReturnTrueIfObjectIsInTheSetWhileSerachingByTypeAndModel() {
		// when
		Set<CarEntity> result = carRepository.findCarByTypeAndModel(CarType.HATCHBACK, "Skoda");

		// then
		assertEquals(true, result.contains(car1));
	}

	@Test
	public void shouldFindEmptySetWhySearchingByTypeAndModel() {
		// when
		Set<CarEntity> result = carRepository.findCarByTypeAndModel(CarType.HATCHBACK, "Ford");

		// then
		assertEquals(0, result.size());
	}

	@Test
	public void shouldFindSetOfCarsByHandler() {
		// when
		Set<CarEntity> result = carRepository.findCarByHandler(1L);

		// then
		assertEquals(3, result.size());
	}

	@Test
	public void shouldReturnTrueIfObjectIsInTheSetWhileSerachingByHandler() {
		// when
		Set<CarEntity> result = carRepository.findCarByHandler(1L);

		// then
		assertEquals(true, result.contains(car1));
	}

	@Test
	public void shouldFindEmptySetIfHandlerHasNoCars() {
		// when
		Set<CarEntity> result = carRepository.findCarByHandler(2L);

		// then
		assertEquals(0, result.size());
	}

}
