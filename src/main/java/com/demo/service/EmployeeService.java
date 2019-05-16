package com.demo.service;

import com.demo.common.domain.DepartamentTO;

public interface EmployeeService {

	void deleteEmployeeFromDepartment(Long employeeId);

	void addEmployeeToDepartment(Long employeeId, DepartamentTO departamentTo);

}
