package com.demo.common.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.demo.common.enums.Position;
import com.demo.persistence.entity.DepartamentEntity;
import com.demo.persistence.entity.EmployeeEntity;

public class EmployeeTO {

	private Long id;
	
	private String firstName;
	
	private String surName;
	
	private Position position;
	
	private DepartamentEntity departament;

	private Set <CarTO> cars = new HashSet<>();
	
	private LocalDate dateOfBirth;

	
	public EmployeeTO(EmployeeEntity employee) {
		id = employee.getId();
		firstName = employee.getFirstName();
		surName = employee.getSurName();
		position = employee.getPosition();
		DepartamentEntity departamentEntity = new DepartamentEntity();
		departament = employee.getDepartament();
		employee.getCars().forEach(c -> cars.add(new CarTO(c)));
		dateOfBirth = employee.getDateOfBirth();
	}

	public EmployeeTO(DepartamentEntity departament) {
		this.departament = departament;
	}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public DepartamentEntity getDepartament() {
		return departament;
	}

	public void setDepartament(DepartamentEntity departament) {
		this.departament = departament;
	}

	public Set<CarTO> getCars() {
		return cars;
	}

	public void setCars(Set<CarTO> cars) {
		this.cars = cars;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
}
