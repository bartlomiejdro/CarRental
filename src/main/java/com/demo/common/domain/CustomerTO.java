package com.demo.common.domain;

import com.demo.persistence.entity.AdressEntity;
import com.demo.persistence.entity.CustomerEntity;

public class CustomerTO {
	
	private Long id;
	
	private String firstName;
	
	private String surName;
	
	private AdressEntity adress;
	
	private String email;
	
	private String mobileNumber;
	
	public CustomerTO (CustomerEntity customer) {
		id = customer.getId();
		firstName = customer.getFirstName();
		surName = customer.getSurName();
		adress = customer.getAdress();
		email = customer.getEmail();
		mobileNumber = customer.getMobileNumber();;
	}

	public CustomerTO(String firstName, String surName, AdressEntity adress, String email, String mobileNumber) {
		this.firstName = firstName;
		this.surName = surName;
		this.adress = adress;
		this.email = email;
		this.mobileNumber = mobileNumber;
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

	public AdressEntity getAdress() {
		return adress;
	}

	public void setAdress(AdressEntity adress) {
		this.adress = adress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Long getId() {
		return id;
	}
}
