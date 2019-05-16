package com.demo.persistence.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.demo.persistence.entity.CarEntity;
import com.demo.persistence.entity.RentalEntity;

public interface RentalDao extends Dao<RentalEntity, Long>{

	Set<CarEntity> findCarsRentedByTheNumberOfCustomers(Long noOfCustomers);

	Integer findCarsRentedBetweenDates(LocalDate startDate, LocalDate endDate);

	List<RentalEntity> findRentsByCar(Long CarId);

}
