package com.demo.persistence.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.demo.common.domain.EmployeeTO;
import com.demo.common.enums.Position;

@NamedQueries({
	@NamedQuery(name="departament.findEmployees", 
			query="SELECT e FROM EmployeeEntity e "
					+ "WHERE e.departament.id = :departamentId"),
		@NamedQuery(name="departament.findEmplCarHandler", 
				query="SELECT e FROM EmployeeEntity e "
						+ "JOIN  e.cars ec "
						+ "WHERE e.departament.id = :departamentId AND ec= :carEntity ")
})

@Entity
@Table(name = "EMPLOYEE")
public class EmployeeEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, length = 50)
	private String firstName;
	
	@Column(nullable = false, length = 50)
	private String surName;
	
	@Column(nullable = false)
	private Position position;
	
	@ManyToOne
	private DepartamentEntity departament;

	@ManyToMany
	@JoinTable(name = "KEEPER", joinColumns = {
			@JoinColumn(name = "EMPLOYEE_ID", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "CAR_ID", nullable = false, updatable = false) })
	private Set <CarEntity> cars = new HashSet<>();
	
	@Column(nullable = false)
	private LocalDate dateOfBirth;
	
	public EmployeeEntity(EmployeeTO employeeTO) {
		firstName = employeeTO.getFirstName();
		surName = employeeTO.getSurName();
		position = employeeTO.getPosition();
		departament = employeeTO.getDepartament();
		employeeTO.getCars().forEach(c -> cars.add(new CarEntity(c)));
		dateOfBirth = employeeTO.getDateOfBirth();	
	}
	
	public EmployeeEntity() {
	}
	
	public EmployeeEntity(String firstName, String surName, Position postion, DepartamentEntity departament,
			Set<CarEntity> cars, LocalDate dateOfBirth) {
		this.firstName = firstName;
		this.surName = surName;
		this.position = postion;
		this.cars = cars;
		this.dateOfBirth = dateOfBirth;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Set<CarEntity> getCars() {
		return cars;
	}

	public void setCars(Set<CarEntity> cars) {
		this.cars = cars;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cars == null) ? 0 : cars.hashCode());
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((departament == null) ? 0 : departament.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		result = prime * result + ((surName == null) ? 0 : surName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeEntity other = (EmployeeEntity) obj;
		if (cars == null) {
			if (other.cars != null)
				return false;
		} else if (!cars.equals(other.cars))
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (departament == null) {
			if (other.departament != null)
				return false;
		} else if (!departament.equals(other.departament))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (position != other.position)
			return false;
		if (surName == null) {
			if (other.surName != null)
				return false;
		} else if (!surName.equals(other.surName))
			return false;
		return true;
	}
}
