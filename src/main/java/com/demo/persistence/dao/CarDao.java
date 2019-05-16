package com.demo.persistence.dao;

import java.util.Set;

import com.demo.common.enums.CarType;
import com.demo.persistence.entity.CarEntity;

public interface CarDao extends Dao<CarEntity, Long>{
	
	Set<CarEntity> findCarByTypeAndModel(CarType carType, String brand);

	Set<CarEntity> findCarByHandler(Long emplyeeId);

}
