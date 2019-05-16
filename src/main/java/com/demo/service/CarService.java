package com.demo.service;

import java.util.Set;

import com.demo.common.domain.CarTO;
import com.demo.common.enums.CarType;
import com.demo.persistence.entity.CarEntity;

public interface CarService {

	CarTO save(CarTO carTo);

	Set<CarTO> findCarByTypeAndModel(CarType carType, String mark);

	CarTO findCarById(Long carId);

	void delete(CarEntity carEntity);

	void setCarToHandler(Long employeeId, CarTO carTo);

	CarTO update(CarTO carTo);

}
