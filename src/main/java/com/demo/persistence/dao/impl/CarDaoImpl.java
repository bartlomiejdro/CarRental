package com.demo.persistence.dao.impl;

import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.demo.common.enums.CarType;
import com.demo.persistence.dao.CarDao;
import com.demo.persistence.entity.CarEntity;

@Repository
public class CarDaoImpl extends AbstractDao<CarEntity, Long> implements CarDao {

	@Override
	public Set<CarEntity> findCarByTypeAndModel(CarType carType, String brand) {
		TypedQuery<CarEntity> query = entityManager.createNamedQuery("cars.findCarByTypeAndModel", CarEntity.class);
		query.setParameter("carType", carType);
		query.setParameter("carBrand", brand);

		return query.getResultList().stream().collect(Collectors.toSet());
	}

	@Override
	public Set<CarEntity> findCarByHandler(Long employeeId) {
		TypedQuery <CarEntity> query = entityManager.createNamedQuery("cars.findByHandler", CarEntity.class)
				.setParameter("employeeId", employeeId);

		return  query.getResultList().stream().collect(Collectors.toSet());
	}
}
