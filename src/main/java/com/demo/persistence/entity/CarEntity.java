package com.demo.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.demo.common.domain.CarTO;
import com.demo.common.enums.CarType;

@NamedQueries({
	@NamedQuery(name="cars.findCarByTypeAndModel", 
		query="SELECT c FROM CarEntity c WHERE c.carType = :carType AND c.brand = :carBrand"),
		@NamedQuery(name="cars.findByHandler",
		query="SELECT ec FROM EmployeeEntity e "
				+ "JOIN  e.cars ec "
				+ "WHERE e.id = :employeeId")
})
@Entity
@Table(name = "CAR")
public class CarEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, length = 50)
	private String brand;
	
	@Column(nullable = false, length = 50)
	private String model;
	
	@Column(nullable = false, length = 20)
	private String color;
	
	private CarType carType;
	
	@Column(nullable = false)
	private Integer engineCapacity;
	
	@Column(nullable = false)
	private Integer power;
	
	@Column(nullable = false)
	private Integer productionYear;
	
	@Column(nullable = false)
	private Integer mileAge;
	
	public CarEntity (CarTO carTO) {
		brand = carTO.getBrand();
		model = carTO.getModel();
		color = carTO.getColor();
		carType = carTO.getCarType();
		engineCapacity = carTO.getEngineCapacity();
		power = carTO.getPower();
		productionYear = carTO.getProductionYear();
		mileAge = carTO.getMileAge();
	}
	


	public CarEntity(String brand, String model, String color, CarType carType, Integer engineCapacity,
			Integer power, Integer productionYear, Integer mileAge) {
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.carType = carType;
		this.engineCapacity = engineCapacity;
		this.power = power;
		this.productionYear = productionYear;
		this.mileAge = mileAge;
	}



	public CarEntity() {
	}

	public Long getId() {
		return id;
	}
	
	public CarType getCarType() {
		return carType;
	}

	public void setCarType(CarType carType) {
		this.carType = carType;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getEngineCapacity() {
		return engineCapacity;
	}

	public void setEngineCapacity(Integer engineCapacity) {
		this.engineCapacity = engineCapacity;
	}

	public Integer getPower() {
		return power;
	}

	public void setPower(Integer power) {
		this.power = power;
	}

	public Integer getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(Integer productionYear) {
		this.productionYear = productionYear;
	}

	public Integer getMileAge() {
		return mileAge;
	}

	public void setMileAge(Integer mileAge) {
		this.mileAge = mileAge;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((carType == null) ? 0 : carType.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((engineCapacity == null) ? 0 : engineCapacity.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mileAge == null) ? 0 : mileAge.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((power == null) ? 0 : power.hashCode());
		result = prime * result + ((productionYear == null) ? 0 : productionYear.hashCode());
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
		CarEntity other = (CarEntity) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (carType != other.carType)
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (engineCapacity == null) {
			if (other.engineCapacity != null)
				return false;
		} else if (!engineCapacity.equals(other.engineCapacity))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mileAge == null) {
			if (other.mileAge != null)
				return false;
		} else if (!mileAge.equals(other.mileAge))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (power == null) {
			if (other.power != null)
				return false;
		} else if (!power.equals(other.power))
			return false;
		if (productionYear == null) {
			if (other.productionYear != null)
				return false;
		} else if (!productionYear.equals(other.productionYear))
			return false;
		return true;
	}
}
