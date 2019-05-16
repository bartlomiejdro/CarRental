package com.demo.common.domain;

import com.demo.persistence.entity.AdressEntity;
import com.demo.persistence.entity.DepartamentEntity;

public class DepartamentTO {
	
	private Long id;
	
	private AdressEntity adress;
	
	private String phoneNumber;
	
	private String email;
	
	public DepartamentTO(DepartamentEntity departament) {
		id = departament.getId();
		adress = departament.getAdress();
		phoneNumber = departament.getPhoneNumber();
		email = departament.getEmail();
	}

	

	public DepartamentTO(AdressEntity adress, String phoneNumber, String email) {
		this.adress = adress;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AdressEntity getAdress() {
		return adress;
	}

	public void setAdress(AdressEntity adress) {
		this.adress = adress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
