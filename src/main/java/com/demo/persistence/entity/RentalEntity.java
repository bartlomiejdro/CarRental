package com.demo.persistence.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.demo.common.domain.RentalTO;

@NamedQueries({
	@NamedQuery(name = "RentalEntity.findRentsByCar", query = "SELECT r FROM RentalEntity r WHERE r.cars.id = :id")
}) 

@Entity
@Table(name = "RENTAL")
public class RentalEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private LocalDate rentDate;
	
	@OneToOne
	private DepartamentEntity departamentFrom;
	
	@Column(nullable = true)
	private LocalDate returnDate;
	
	@OneToOne
	private DepartamentEntity departamentTo;
	
	@ManyToOne
	@OnDelete(action=OnDeleteAction.CASCADE)
	@JoinColumn(name = "CAR_ID")
	private CarEntity cars;
	
	@ManyToOne
	@OnDelete(action=OnDeleteAction.CASCADE)
	@JoinColumn(name = "CUSTOMER_ID")
	private CustomerEntity customer;
	
	@Column(nullable = false)
	private Double price;
	
	public RentalEntity(RentalTO rentalTO) {
		rentDate = rentalTO.getRentDate();
		departamentFrom = rentalTO.getDepartamentFrom();
		returnDate = rentalTO.getReturnDate();
		departamentTo = rentalTO.getDepartamentTo();
		cars = rentalTO.getCarId();
		customer = rentalTO.getCustomerId();
		price = rentalTO.getPrice();
	}
	
	public RentalEntity() {
	}

	public RentalEntity(Long id, LocalDate rentDate, DepartamentEntity departamentFrom, LocalDate returnDate,
			DepartamentEntity departamentTo, CarEntity carId, CustomerEntity customerId, Double price) {
		this.id = id;
		this.rentDate = rentDate;
		this.departamentFrom = departamentFrom;
		this.returnDate = returnDate;
		this.departamentTo = departamentTo;
		this.cars = carId;
		this.customer = customerId;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return cars;
	}

	public void setCarId(CarEntity cars) {
		this.cars = cars;
	}

	public CustomerEntity getCustomerId() {
		return customer;
	}

	public void setCustomerId(CustomerEntity customer) {
		this.customer = customer;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cars == null) ? 0 : cars.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((departamentFrom == null) ? 0 : departamentFrom.hashCode());
		result = prime * result + ((departamentTo == null) ? 0 : departamentTo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((rentDate == null) ? 0 : rentDate.hashCode());
		result = prime * result + ((returnDate == null) ? 0 : returnDate.hashCode());
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
		RentalEntity other = (RentalEntity) obj;
		if (cars == null) {
			if (other.cars != null)
				return false;
		} else if (!cars.equals(other.cars))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (departamentFrom == null) {
			if (other.departamentFrom != null)
				return false;
		} else if (!departamentFrom.equals(other.departamentFrom))
			return false;
		if (departamentTo == null) {
			if (other.departamentTo != null)
				return false;
		} else if (!departamentTo.equals(other.departamentTo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (rentDate == null) {
			if (other.rentDate != null)
				return false;
		} else if (!rentDate.equals(other.rentDate))
			return false;
		if (returnDate == null) {
			if (other.returnDate != null)
				return false;
		} else if (!returnDate.equals(other.returnDate))
			return false;
		return true;
	}
}
