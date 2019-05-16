package com.demo.service;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.common.domain.AdressTO;
import com.demo.common.domain.DepartamentTO;
import com.demo.persistence.dao.AdressDao;
import com.demo.persistence.dao.DepartamentDao;
import com.demo.persistence.dao.EmployeeDao;
import com.demo.persistence.entity.AdressEntity;
import com.demo.persistence.entity.DepartamentEntity;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class DepartamentServiceTest {
	
	@Autowired
	EmployeeDao employeeRepository;
	@Autowired
	AdressDao adressRepository;
	@Autowired
	DepartamentDao departamentRepository;
	@Autowired
	DepartamentService departamentService;
	
	
	private AdressEntity adress1;
	private AdressEntity adress2;
	private AdressTO adress1T;
	private DepartamentEntity dep1;
	private DepartamentTO dep1T;

	@Before
	public void loadData() {
		
		adress1 = new AdressEntity("Strzegomska", "55-601", "Wroclaw", "Polska");
		adress2 = new AdressEntity("Salesianergasse", "55-103", "Wieden", "Austria");
		adressRepository.save(adress1);
		dep1 = new DepartamentEntity(adress1, "1234", "dep1@wp.pl");
		departamentRepository.save(dep1);
	}
	
	@Test
	public void shouldCreateDepartamentAndSetItsId() {
		//given
		dep1T = new DepartamentTO(adress1, "1234", "dep1@wp.pl");
		//when
		DepartamentTO result = departamentService.save(dep1T);
		//then
		assertNotNull(result.getId());
	}
	
	@Test
	public void shouldUpdateAllDepartamentDetails() {
		//given
		dep1T = new DepartamentTO(adress2, "222-333-111", "dep2@wp.pl");
		//when
		DepartamentTO result = departamentService.update(dep1.getId(), dep1T);
		//then
		assertEquals(new AdressTO(adress2), result.getAdress());
		assertEquals(dep1T.getPhoneNumber(), result.getPhoneNumber());
		assertEquals(dep1T.getEmail(), result.getEmail());
	}
	
	@Test
	public void shouldDelteDepartament() {
		//
		Long id = dep1.getId();
		//when
		departamentService.delete(dep1);
		//then
		assertNull(departamentService.findDepartamentById(id));
	}

}
