package com.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.common.domain.DepartamentTO;
import com.demo.persistence.dao.EmployeeDao;
import com.demo.persistence.entity.DepartamentEntity;
import com.demo.persistence.entity.EmployeeEntity;
import com.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeDao employeeRepository;
	
	@Override
	public void deleteEmployeeFromDepartment(Long employeeId) {
		EmployeeEntity employee = employeeRepository.findOne(employeeId);
		employee.setDepartament(null);
	}
	
	@Override
	public void addEmployeeToDepartment(Long employeeId, DepartamentTO departamentTo) {
		EmployeeEntity employee = employeeRepository.findOne(employeeId);
		DepartamentEntity departament = new DepartamentEntity(departamentTo);
		employee.setDepartament(departament);
	}

}
