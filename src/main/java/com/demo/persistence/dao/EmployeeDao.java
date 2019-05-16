package com.demo.persistence.dao;

import java.util.List;
import java.util.Set;

import com.demo.common.domain.EmployeeSearchCriteria;
import com.demo.persistence.entity.CarEntity;
import com.demo.persistence.entity.EmployeeEntity;

public interface EmployeeDao extends Dao<EmployeeEntity, Long>{

	Set<EmployeeEntity> findEmployeesInDepartment(Long departamentId);

	Set<EmployeeEntity> findEmployeesCarHandlerInDerpart(Long departamentId, CarEntity car);

	List<EmployeeEntity> searchByCriteria(EmployeeSearchCriteria criteria);

}
