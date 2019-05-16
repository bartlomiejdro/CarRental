package com.demo.common.domain;

import com.demo.common.enums.CarType;
import com.demo.persistence.entity.CarEntity;

public class CarTO {

	private Long id;
	private String brand;
	private String model;
	private String color;
	private CarType carType;
	private Integer engineCapacity;
	private Integer power;
	private Integer productionYear;
	private Integer mileAge;

	public CarTO(CarEntity car) {
		id = car.getId();
		brand = car.getBrand();
		model = car.getModel();
		color = car.getColor();
		carType = car.getCarType();
		engineCapacity = car.getEngineCapacity();
		power = car.getPower();
		productionYear = car.getProductionYear();
		mileAge = car.getMileAge();
	}

	public CarTO(Long id, String brand, String model, String color, CarType carType, Integer engineCapacity,
			Integer power, Integer productionYear, Integer mileAge) {
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.carType = carType;
		this.engineCapacity = engineCapacity;
		this.power = power;
		this.productionYear = productionYear;
		this.mileAge = mileAge;
	}
	
	public CarTO(String brand, String model, String color, CarType carType, Integer engineCapacity, Integer power,
			Integer productionYear, Integer mileAge) {
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.carType = carType;
		this.engineCapacity = engineCapacity;
		this.power = power;
		this.productionYear = productionYear;
		this.mileAge = mileAge;
	}

	public Long getId() {
		return id;
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
	

	public CarType getCarType() {
		return carType;
	}

	public void setCarType(CarType carType) {
		this.carType = carType;
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

}
