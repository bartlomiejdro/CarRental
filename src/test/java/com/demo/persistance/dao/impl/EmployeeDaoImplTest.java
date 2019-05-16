package com.demo.persistance.dao.impl;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.demo.common.domain.CarTO;
import com.demo.common.domain.EmployeeSearchCriteria;
import com.demo.common.enums.CarType;
import com.demo.common.enums.Position;
import com.demo.persistence.dao.AdressDao;
import com.demo.persistence.dao.CarDao;
import com.demo.persistence.dao.DepartamentDao;
import com.demo.persistence.dao.EmployeeDao;
import com.demo.persistence.entity.AdressEntity;
import com.demo.persistence.entity.CarEntity;
import com.demo.persistence.entity.DepartamentEntity;
import com.demo.persistence.entity.EmployeeEntity;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD) 
public class EmployeeDaoImplTest {

	
	@PersistenceContext
	private EntityManager manager;

	@Autowired
	CarDao carRepository;
	@Autowired
	DepartamentDao departamentRepository;
	@Autowired
	EmployeeDao employeeRepository;
	@Autowired
	AdressDao adressRepository;

	private EmployeeEntity employee1;
	private EmployeeEntity employee2;
	private EmployeeEntity employee3;
	private EmployeeEntity employee4;
	private AdressEntity adress1;
	private DepartamentEntity dep1;
	private DepartamentEntity dep2;
	private DepartamentEntity dep3;
	private CarTO car1T;
	private CarTO car2T;
	private CarTO car3T;
	private CarTO car4T;
	private CarTO car5T;
	private CarEntity car1;
	private CarEntity car2;
	private CarEntity car3;
	private CarEntity car4;
	private CarEntity car5;
	private Set<CarEntity> cars1 = new HashSet();
	private Set<CarEntity> cars2 = new HashSet();
	private EmployeeSearchCriteria searchCriter1;
	private EmployeeSearchCriteria searchCriter2;
	private EmployeeSearchCriteria searchCriter3;
	private EmployeeSearchCriteria searchCriter4;
	private EmployeeSearchCriteria searchCriter5;

	
	@Before
	public void loadData() {
		adress1 = new AdressEntity("Strzegomska", "55-601", "Wroclaw", "Polska");
		adressRepository.save(adress1);
		dep1 = new DepartamentEntity(adress1, "1234", "dep1@wp.pl");
		dep2 = new DepartamentEntity(adress1, "12345", "dep2@wp.pl");
		dep3 = new DepartamentEntity(adress1, "12345", "dep3@wp.pl");
		departamentRepository.save(dep1);
		departamentRepository.save(dep2);
		departamentRepository.save(dep3);

		car1T = new CarTO("Skoda", "Oktavia", "red", CarType.HATCHBACK, 1600, 100, 2012, 90000);
		car2T = new CarTO("Skoda", "Fabia", "black", CarType.HATCHBACK, 1400, 90, 2014, 60000);
		car3T = new CarTO("Mazda", "6", "blue", CarType.SEDAN, 1998, 140, 2016, 40000);
		car4T = new CarTO("Ford", "Edge", "green", CarType.SUV, 2500, 160, 2018, 25000);
		car5T = new CarTO("Peugot", "306", "black", CarType.HATCHBACK, 1400, 90, 2014, 60000);
		car1 = new CarEntity(car1T);
		car2 = new CarEntity(car2T);
		car3 = new CarEntity(car3T);
		car4 = new CarEntity(car4T);
		car5 = new CarEntity(car5T);
		carRepository.save(car1);
		carRepository.save(car2);
		carRepository.save(car3);
		carRepository.save(car4);
		carRepository.save(car5);
		car1 = carRepository.getOne(1L);
		car2 = carRepository.getOne(2L);
		car3 = carRepository.getOne(3L);
		car4 = carRepository.getOne(4L);
		car5 = carRepository.getOne(5L);

		cars1.add(car1);
		cars1.add(car2);
		cars1.add(car5);
		cars2.add(car1);

		employee1 = new EmployeeEntity("firstName1", "surName1", Position.ACCOUNTANT, dep1, cars1,
				LocalDate.of(1989, 11, 24));
		employee2 = new EmployeeEntity("firstName2", "surName2", Position.MENAGER, dep1, cars2,
				LocalDate.of(1989, 11, 24));
		employee3 = new EmployeeEntity("firstName2", "surName2", Position.MENAGER, dep2, cars2,
				LocalDate.of(1989, 11, 24));
		employee4 = new EmployeeEntity("firstName2", "surName2", Position.MENAGER, dep2, cars1,
				LocalDate.of(1989, 11, 24));
		employee1.setDepartament(dep1);
		employee2.setDepartament(dep1);
		employee3.setDepartament(dep2);
		employee4.setDepartament(dep2);
		employeeRepository.save(employee1);
		employeeRepository.save(employee2);
		employeeRepository.save(employee3);
		employeeRepository.save(employee4);
		
		searchCriter1 = new EmployeeSearchCriteria(dep1, car1, Position.MENAGER);
		searchCriter1.setCar(car1);
		searchCriter1.setDepartament(dep1);
		searchCriter1.setPosition(Position.MENAGER);
		searchCriter2 = new EmployeeSearchCriteria(null, null, null);
		searchCriter3 = new EmployeeSearchCriteria(dep1, null, null);
		searchCriter3.setDepartament(dep1);
		searchCriter4 = new EmployeeSearchCriteria(dep1, null, null);
		searchCriter4.setCar(car1);
		searchCriter5 = new EmployeeSearchCriteria(dep1, null, null);
		searchCriter5.setPosition(Position.MENAGER);
	}

	
	@Test
	public void shouldFindSetOfEmployeesForSelectedDepartament() {
		// when
		Set<EmployeeEntity> result = employeeRepository.findEmployeesInDepartment(1L);

		// then
		assertEquals(2, result.size());
	}
	
	@Test
	public void shouldReturnTrueIfEmployeesIsInTheDepartment() {
		// when
		Set<EmployeeEntity> result = employeeRepository.findEmployeesInDepartment(1L);

		// then
		assertEquals(true, result.contains(employee1));
	}
	
	@Test
	public void shouldFindEmptySetIfDeparteamenthasNotHaveEmployees() {
		// when
		Set<EmployeeEntity> result = employeeRepository.findEmployeesInDepartment(3L);

		// then
		assertEquals(0, result.size());
	}
	
	
	@Test
	public void shouldFindSetOfEmployeesForSelectedDepartamentAndCara() {
		// when
		Set<EmployeeEntity> result = employeeRepository.findEmployeesCarHandlerInDerpart(1L, car1);

		// then
		assertEquals(2, result.size());
	}
	
	@Test
	public void shouldFindEmptySetWhenThereIsNoHandlersOfTheCarInTheDepartament() {
		// when
		Set<EmployeeEntity> result = employeeRepository.findEmployeesCarHandlerInDerpart(1L, car4);

		// then
		assertEquals(0, result.size());
	}
	
	@Test
	public void shouldFindListOnEmployooesWhenSearchingWIthAllCriteria() {
		//when
		List <EmployeeEntity> result = employeeRepository.searchByCriteria(searchCriter1);
		//then
		assertEquals(1, result.size());
	}
	
	@Test
	public void shouldFindListOnEmployooesWhenAllCriteriasAreNull() {
		List <EmployeeEntity> result = employeeRepository.searchByCriteria(searchCriter2);
		
		assertEquals(4, result.size());
	}
	
	@Test
	public void shouldFindListOnEmployooesWhenOnlyDepartamentCriteriaIsSeted() {
		List <EmployeeEntity> result = employeeRepository.searchByCriteria(searchCriter3);
		
		assertEquals(2, result.size());
	}
	
	@Test
	public void shouldFindListOnEmployooesWhenOnlyCarCriteriaIsSeted() {
		List <EmployeeEntity> result = employeeRepository.searchByCriteria(searchCriter4);
		
		assertEquals(2, result.size());
	}
	
	@Test
	public void shouldFindListOnEmployooesWhenOnlyPositionCriteriaIsSeted() {
		List <EmployeeEntity> result = employeeRepository.searchByCriteria(searchCriter5);
		
		assertEquals(1, result.size());
	}
}
