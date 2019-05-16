package com.demo.common.domain;

import com.demo.common.enums.Position;
import com.demo.persistence.entity.CarEntity;
import com.demo.persistence.entity.DepartamentEntity;

public class EmployeeSearchCriteria {
	
	private DepartamentEntity departament;
	
	private CarEntity car;
	
	private Position position;
	
	public EmployeeSearchCriteria(DepartamentEntity departament, CarEntity car, Position position) {
		this.departament = departament;
		this.car = car;
		this.position = position;
	}

	public DepartamentEntity getDepartament() {
		return departament;
	}

	public void setDepartament(DepartamentEntity departament) {
		this.departament = departament;
	}

	public CarEntity getCar() {
		return car;
	}

	public void setCar(CarEntity car) {
		this.car = car;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((car == null) ? 0 : car.hashCode());
		result = prime * result + ((departament == null) ? 0 : departament.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
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
		EmployeeSearchCriteria other = (EmployeeSearchCriteria) obj;
		if (car == null) {
			if (other.car != null)
				return false;
		} else if (!car.equals(other.car))
			return false;
		if (departament == null) {
			if (other.departament != null)
				return false;
		} else if (!departament.equals(other.departament))
			return false;
		if (position != other.position)
			return false;
		return true;
	}
}
