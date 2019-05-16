package com.demo.common.domain;

import java.time.LocalDate;

import com.demo.persistence.entity.CarEntity;
import com.demo.persistence.entity.CustomerEntity;
import com.demo.persistence.entity.DepartamentEntity;
import com.demo.persistence.entity.RentalEntity;

public class RentalTO {
	
	private Long id;
	
	private LocalDate rentDate;
	
	private DepartamentEntity departamentFrom;
	
	private LocalDate returnDate;
	
	private DepartamentEntity departamentTo;
	
	private CarEntity carId;
	
	private CustomerEntity customerId;
	
	private Double price;
	
	public RentalTO(RentalEntity rental) {
		id = rental.getId();
		rentDate = rental.getRentDate();
		departamentFrom = rental.getDepartamentFrom();
		returnDate = rental.getReturnDate();
		departamentTo = rental.getDepartamentTo();
		carId = rental.getCarId();
		customerId = rental.getCustomerId();
		price = rental.getPrice();
	}

	public RentalTO(LocalDate rentDate, DepartamentEntity departamentFrom, LocalDate returnDate,
			DepartamentEntity departamentTo, CarEntity carId, CustomerEntity customerId, Double price) {
		this.rentDate = rentDate;
		this.departamentFrom = departamentFrom;
		this.returnDate = returnDate;
		this.departamentTo = departamentTo;
		this.carId = carId;
		this.customerId = customerId;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public LocalDate getRentDate() {
		return rentDate;
	}

	public void setRentDate(LocalDate rentDate) {
		this.rentDate = rentDate;
	}

	public DepartamentEntity getDepartamentFrom() {
		return departamentFrom;
	}

	public void setDepartamentFrom(DepartamentEntity departamentFrom) {
		this.departamentFrom = departamentFrom;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public DepartamentEntity getDepartamentTo() {
		return departamentTo;
	}

	public void setDepartamentTo(DepartamentEntity departamentTo) {
		this.departamentTo = departamentTo;
	}

	public CarEntity getCarId() {
		return carId;
	}

	public void setCarId(CarEntity carId) {
		this.carId = carId;
	}

	public CustomerEntity getCustomerId() {
		return customerId;
	}

	public void setCustomerId(CustomerEntity customerId) {
		this.customerId = customerId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	

}
