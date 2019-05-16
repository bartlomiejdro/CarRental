package com.demo.persistence.dao.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.demo.persistence.dao.RentalDao;
import com.demo.persistence.entity.CarEntity;
import com.demo.persistence.entity.RentalEntity;

@Repository
public class RentalDaoImpl extends AbstractDao<RentalEntity, Long> implements  RentalDao{

	@Override
	public Set<CarEntity> findCarsRentedByTheNumberOfCustomers(Long noOfCustomers) {
		return entityManager.createQuery("SELECT re.cars FROM RentalEntity re "
				+ "GROUP BY re.cars "
				+ "HAVING COUNT(DISTINCT re.customer) > :noOfClients", CarEntity.class)
				.setParameter("noOfClients", noOfCustomers)
				.getResultList().stream().collect(Collectors.toSet());
	} 
	
	@Override
	public Integer findCarsRentedBetweenDates(LocalDate startDate, LocalDate endDate) {
		return entityManager.createQuery("SELECT re FROM RentalEntity re "
				+ "WHERE "
				+ "re.rentDate <= :endDate "
				+ "AND "
				+ "re.returnDate >= :startDate", RentalEntity.class)
				.setParameter("startDate", startDate)
				.setParameter("endDate", endDate).getResultList().size();
	}
	
	@Override
	public List <RentalEntity> findRentsByCar(Long CarId) {
		TypedQuery <RentalEntity> query = entityManager.createNamedQuery("RentalEntity.findRentsByCar", RentalEntity.class)
				.setParameter("id", CarId);
		
		return  query.getResultList();
	} 	
}
