package com.demo.persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.demo.common.domain.EmployeeSearchCriteria;
import com.demo.persistence.dao.EmployeeDao;
import com.demo.persistence.entity.CarEntity;
import com.demo.persistence.entity.EmployeeEntity;

@Repository
public class EmployeeDaoImpl extends AbstractDao<EmployeeEntity, Long> implements EmployeeDao {

	@Override
	public Set<EmployeeEntity> findEmployeesInDepartment(Long departamentId) {
		return entityManager.createNamedQuery("departament.findEmployees", EmployeeEntity.class)
				.setParameter("departamentId", departamentId).getResultList().stream().collect(Collectors.toSet());
	}


	@Override
	public Set<EmployeeEntity> findEmployeesCarHandlerInDerpart(Long departamentId, CarEntity car) {
		return entityManager.createNamedQuery("departament.findEmplCarHandler", EmployeeEntity.class)
				.setParameter("departamentId", departamentId).setParameter("carEntity", car).getResultList().stream()
				.collect(Collectors.toSet());
	}

	@Override
	public List<EmployeeEntity> searchByCriteria(EmployeeSearchCriteria criteria) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<EmployeeEntity> query = builder.createQuery(EmployeeEntity.class);
		Root <EmployeeEntity> employee = query.from(EmployeeEntity.class);

		List<Predicate> predicates = new ArrayList<>();

		if (criteria.getCar() != null) {
			predicates.add(builder.isMember(criteria.getCar(), employee.get("cars")));
		}
		if (criteria.getDepartament() != null) {
			predicates
					.add(builder.equal(employee.get("departament"), criteria.getDepartament()));
		}
		if (criteria.getPosition() != null) {
			predicates.add(builder.equal(employee.get("position"), criteria.getPosition()));
		}
		Predicate[] predicatesInArray = new Predicate[predicates.size()];
		predicates.toArray(predicatesInArray);
		
		query.select(employee).where(predicatesInArray);		
		return entityManager.createQuery(query).getResultList();
	}
}
