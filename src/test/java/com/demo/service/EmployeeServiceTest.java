package com.demo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.common.domain.DepartamentTO;
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
public class EmployeeServiceTest {
	
	@Autowired
	CarDao carRepository;
	@Autowired
	EmployeeDao employeeRepository;
	@Autowired
	AdressDao adressRepository;
	@Autowired
	EmployeeService employeeService;
	@Autowired
	EmployeeDao employeRepository;
	@Autowired
	DepartamentDao departamentRepository;
	@Autowired
	CarService carService;
	
	private EmployeeEntity employee1;
	private AdressEntity adress1;
	private DepartamentEntity dep1;
	private DepartamentTO dep2T;
	private Set<CarEntity> cars1 = new HashSet();


	@Test
	public void ShouldSetNullInEmployeeOnDepartament () {
		//given
		adress1 = new AdressEntity("Strzegomska", "55-601", "Wroclaw", "Polska");
		employee1 = new EmployeeEntity("firstName1", "surName1", Position.ACCOUNTANT, dep1, cars1,
				LocalDate.of(1989, 11, 24));
		dep1 = new DepartamentEntity(adress1, "1234", "dep1@wp.pl");
		employee1.setDepartament(dep1);
		departamentRepository.save(dep1);
		adressRepository.save(adress1);
		employeeRepository.save(employee1);
		//when
		employeeService.deleteEmployeeFromDepartment(employee1.getId());
		//then
		assertNull(employee1.getDepartament());
	}
	
	@Test
	public void shouldSetDepartament() {
		//given
		adress1 = new AdressEntity("Strzegomska", "55-601", "Wroclaw", "Polska");
		employee1 = new EmployeeEntity("firstName1", "surName1", Position.ACCOUNTANT, dep1, cars1,
				LocalDate.of(1989, 11, 24));
		dep1 = new DepartamentEntity(adress1, "1234", "dep1@wp.pl");
		dep2T = new DepartamentTO(adress1, "1234", "dep2@wp.pl");
		
		employee1.setDepartament(dep1);
		departamentRepository.save(dep1);
		adressRepository.save(adress1);
		employeeRepository.save(employee1);
		//when
		employeeService.addEmployeeToDepartment(employee1.getId(), dep2T);
		//then
		assertEquals(dep2T.getId(), employee1.getDepartament().getId());
		
	}
}
