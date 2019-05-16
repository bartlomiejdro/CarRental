package com.demo.persistance.dao.impl;


import static org.junit.Assert.*;

import java.time.LocalDate;
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

import com.demo.common.domain.AdressTO;
import com.demo.common.domain.CarTO;
import com.demo.common.domain.CustomerTO;
import com.demo.common.domain.DepartamentTO;
import com.demo.common.domain.RentalTO;
import com.demo.common.enums.CarType;
import com.demo.persistence.dao.AdressDao;
import com.demo.persistence.dao.CarDao;
import com.demo.persistence.dao.CustomerDao;
import com.demo.persistence.dao.DepartamentDao;
import com.demo.persistence.dao.EmployeeDao;
import com.demo.persistence.dao.RentalDao;
import com.demo.persistence.entity.AdressEntity;
import com.demo.persistence.entity.CarEntity;
import com.demo.persistence.entity.CustomerEntity;
import com.demo.persistence.entity.DepartamentEntity;
import com.demo.persistence.entity.RentalEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class RentalDaoImplTest {
	
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
	@Autowired
	CustomerDao customerRepository;
	@Autowired
	RentalDao rentalRepository;
	
	
	private CustomerEntity customer1;
	private CustomerEntity customer2;
	private CustomerEntity customer3;
	private CustomerEntity customer4;
	private CustomerTO customer1T;
	private CustomerTO customer2T;
	private CustomerTO customer3T;
	private CustomerTO customer4T;
	private AdressEntity adress1;
	private AdressTO adress1T;
	private DepartamentEntity dep1;
	private DepartamentEntity dep2;
	private DepartamentEntity dep3;
	private DepartamentTO dep1T;
	private DepartamentTO dep2T;
	private DepartamentTO dep3T;
	private CarEntity car1;
	private CarEntity car2;
	private CarEntity car3;
	private CarEntity car4;
	private CarEntity car5;
	private CarEntity car6;
	private CarEntity car7;
	private CarEntity car8;
	private CarEntity car9;
	private CarEntity car10;
	private CarTO car1T;
	private CarTO car2T;
	private CarTO car3T;
	private CarTO car4T;
	private CarTO car5T;
	private CarTO car6T;
	private CarTO car7T;
	private CarTO car8T;
	private CarTO car9T;
	private CarTO car10T;
	private RentalTO rent1T;
	private RentalTO rent2T;
	private RentalTO rent3T;
	private RentalTO rent4T;
	private RentalTO rent5T;
	private RentalTO rent6T;
	private RentalTO rent7T;
	private RentalTO rent8T;
	private RentalTO rent9T;
	private RentalEntity rent1;
	private RentalEntity rent2;
	private RentalEntity rent3;
	private RentalEntity rent4;
	private RentalEntity rent5;
	private RentalEntity rent6;
	private RentalEntity rent7;
	private RentalEntity rent8;
	private RentalEntity rent9;
	
	
	@Before
	public void loadData() {
		
		adress1T = new AdressTO("Strzegomska", "55-601", "Wroclaw", "Polska");
		adress1 = new AdressEntity(adress1T);
		adressRepository.save(adress1);
		adress1 = adressRepository.getOne(1L);
		
		car1T = new CarTO("Skoda", "Oktavia", "red", CarType.HATCHBACK, 1600, 100, 2012, 90000);
		car2T = new CarTO("Skoda", "Fabia", "black", CarType.HATCHBACK, 1400, 90, 2014, 60000);
		car3T = new CarTO("Mazda", "6", "blue", CarType.SEDAN, 1998, 140, 2016, 40000);
		car4T = new CarTO("Ford", "Edge", "green", CarType.SUV, 2500, 160, 2018, 25000);
		car5T = new CarTO("Peugot", "306", "black", CarType.HATCHBACK, 1400, 90, 2014, 60000);
		car6T = new CarTO("Skoda", "Oktavia", "red", CarType.HATCHBACK, 1600, 100, 2012, 90000);
		car7T = new CarTO("Skoda", "Fabia", "black", CarType.HATCHBACK, 1400, 90, 2014, 60000);
		car8T = new CarTO("Mazda", "6", "blue", CarType.SEDAN, 1998, 140, 2016, 40000);
		car9T = new CarTO("Ford", "Edge", "green", CarType.SUV, 2500, 160, 2018, 25000);
		car10T = new CarTO("Peugot", "306", "black", CarType.HATCHBACK, 1400, 90, 2014, 60000);
		car1 = new CarEntity(car1T);
		car2 = new CarEntity(car2T);
		car3 = new CarEntity(car3T);
		car4 = new CarEntity(car4T);
		car5 = new CarEntity(car5T);
		car6 = new CarEntity(car6T);
		car7 = new CarEntity(car7T);
		car8 = new CarEntity(car8T);
		car9 = new CarEntity(car9T);
		car10 = new CarEntity(car10T);
		carRepository.save(car1);
		carRepository.save(car2);
		carRepository.save(car3);
		carRepository.save(car4);
		carRepository.save(car5);
		carRepository.save(car6);
		carRepository.save(car7);
		carRepository.save(car8);
		carRepository.save(car9);
		carRepository.save(car10);
		car1 = carRepository.getOne(1L);
		car2 = carRepository.getOne(2L);
		car3 = carRepository.getOne(3L);
		car4 = carRepository.getOne(4L);
		car5 = carRepository.getOne(5L);
		car6 = carRepository.getOne(6L);
		car7 = carRepository.getOne(7L);
		car8 = carRepository.getOne(8L);
		car9 = carRepository.getOne(9L);
		car10 = carRepository.getOne(10L);
		
		dep1T = new DepartamentTO(adress1, "1234", "dep1@wp.pl");
		dep2T = new DepartamentTO(adress1, "12345", "dep2@wp.pl");
		dep3T = new DepartamentTO(adress1, "123456", "dep3@wp.pl");
		dep1 = new DepartamentEntity(dep1T);
		dep2 = new DepartamentEntity(dep2T);
		dep3 = new DepartamentEntity(dep3T);
		departamentRepository.save(dep1);
		departamentRepository.save(dep2);
		departamentRepository.save(dep3);
		dep1 = departamentRepository.getOne(1L);
		dep2 = departamentRepository.getOne(2L);
		dep3 = departamentRepository.getOne(3L);
		
		customer1T = new CustomerTO("firstName1", "lastName1", adress1, "customer1@wp.pl", "111-222-333");
		customer2T = new CustomerTO("firstName2", "lastName2", adress1, "customer2@wp.pl", "111-222-333");
		customer3T = new CustomerTO("firstName3", "lastName3", adress1, "customer3@wp.pl", "111-222-333");
		customer4T = new CustomerTO("firstName4", "lastName4", adress1, "customer3@wp.pl", "111-222-333");
		customer1 = new CustomerEntity(customer1T);
		customer2 = new CustomerEntity(customer2T);
		customer3 = new CustomerEntity(customer3T);
		customer4 = new CustomerEntity(customer4T);
		customerRepository.save(customer1);
		customerRepository.save(customer2);
		customerRepository.save(customer3);
		customerRepository.save(customer4);
		customer1 = customerRepository.getOne(1L);
		customer1 = customerRepository.getOne(2L);
		customer1 = customerRepository.getOne(3L);
		customer1 = customerRepository.getOne(4L);
		
		rent1T = new RentalTO (LocalDate.of(2018, 12, 20), dep1, LocalDate.of(2019, 01, 05), dep1, car1, customer1, 300.0);
		rent2T = new RentalTO (LocalDate.of(2018, 10, 24), dep1, LocalDate.of(2018, 11, 28), dep1, car2, customer2, 300.0);
		rent3T = new RentalTO (LocalDate.of(2018, 11, 24), dep1, LocalDate.of(2018, 12, 23), dep1, car3, customer1, 300.0);
		rent4T = new RentalTO (LocalDate.of(2019, 01, 24), dep1, LocalDate.of(2019, 02, 27), dep1, car4, customer3, 300.0);
		rent5T = new RentalTO (LocalDate.of(2019, 01, 10), dep1, LocalDate.of(2019, 03, 02), dep1, car1, customer2, 300.0);
		rent6T = new RentalTO (LocalDate.of(2019, 01, 24), dep1, LocalDate.of(2019, 02, 15), dep1, car1, customer3, 300.0);
		rent7T = new RentalTO (LocalDate.of(2019, 01, 02), dep1, LocalDate.of(2019, 03, 24), dep1, car2, customer4, 300.0);
		rent8T = new RentalTO (LocalDate.of(2017, 02, 02), dep1, LocalDate.of(2017, 02, 07), dep1, car2, customer3, 300.0);
		rent9T = new RentalTO (LocalDate.of(2017, 01, 02), dep1, LocalDate.of(2017, 02, 04), dep1, car4, customer2, 300.0);
		rent1 = new RentalEntity(rent1T);
		rent2 = new RentalEntity(rent2T);
		rent3 = new RentalEntity(rent3T);
		rent4 = new RentalEntity(rent4T);
		rent5 = new RentalEntity(rent5T);
		rent6 = new RentalEntity(rent6T);
		rent7 = new RentalEntity(rent7T);
		rent8 = new RentalEntity(rent8T);
		rent9 = new RentalEntity(rent9T);
		rentalRepository.save(rent1);
		rentalRepository.save(rent2);
		rentalRepository.save(rent3);
		rentalRepository.save(rent4);
		rentalRepository.save(rent5);
		rentalRepository.save(rent6);
		rentalRepository.save(rent7);
		rentalRepository.save(rent8);
		rentalRepository.save(rent9);
		rent1 = rentalRepository.getOne(1L);
		rent2 = rentalRepository.getOne(2L);
		rent3 = rentalRepository.getOne(3L);
		rent4 = rentalRepository.getOne(4L);
		rent5 = rentalRepository.getOne(5L);
		rent6 = rentalRepository.getOne(6L);
		rent7 = rentalRepository.getOne(7L);
		rent8 = rentalRepository.getOne(8L);
		rent9 = rentalRepository.getOne(9L);
		
	}

	 @Test
	    public void shouldReturnEmptyListsWhenSearchParameterIsNull(){
	        //given when
	        Set<CarEntity> carSet = rentalRepository.findCarsRentedByTheNumberOfCustomers(null);
	        
	        //then
	        assertEquals(0, carSet.size());
	    }
	    
	    @Test
	    public void shouldFindCarsRentedByMoreThanZeroDistinctNoOfCustomersAndContainCars(){
	        //given when
	        Set<CarEntity> carSet0 = rentalRepository.findCarsRentedByTheNumberOfCustomers(2L);
	        //then
	        assertEquals(2, carSet0.size());
	        assertTrue(carSet0.contains(car1));
	        assertTrue(carSet0.contains(car2));
	    }
	    
	    @Test
	    public void shouldReturnEmptyCarListsWhenNotRentedByMoreThanSpecifiedDistinctCustomer(){
	        //given when
	        Set<CarEntity> carSet1 = rentalRepository.findCarsRentedByTheNumberOfCustomers(1L);
	        Set<CarEntity> carSet2 = rentalRepository.findCarsRentedByTheNumberOfCustomers(2L);
	        Set<CarEntity> carSet3 = rentalRepository.findCarsRentedByTheNumberOfCustomers(3L);
	        Set<CarEntity> carSet4 = rentalRepository.findCarsRentedByTheNumberOfCustomers(4L);
	        
	        //then
	        assertEquals(3, carSet1.size());
	        assertEquals(2, carSet2.size());
	        assertEquals(0, carSet3.size());
	        assertEquals(0, carSet4.size());
	    }
	    
	    @Test
	    public void ShouldReturn3RentedCarsBetweanDates() {
	    	Integer result =  rentalRepository.findCarsRentedBetweenDates(LocalDate.of(2018, 11, 24), LocalDate.of(2018, 12, 24));
	    	
	    	assertEquals(Integer.valueOf(3), result);
	    }
	    
	    @Test 
	    public void ShouldReturn4RentedCarsBetweanDates() {
	    	Integer result =  rentalRepository.findCarsRentedBetweenDates(LocalDate.of(2019, 01, 20), LocalDate.of(2019, 02, 24));
	    	
	    	assertEquals(Integer.valueOf(4), result);
	    }
	    
	    @Test 
	    public void ShouldReturn2RentedCarsBetweanDates() {
	    	Integer result =  rentalRepository.findCarsRentedBetweenDates(LocalDate.of(2017, 02, 01), LocalDate.of(2017, 02, 03));
	    	
	    	assertEquals(Integer.valueOf(2), result);
	    }
	    
	    @Test 
	    public void shouldFind0CarsRentedBetwenDates() {
	    	Integer result =  rentalRepository.findCarsRentedBetweenDates(LocalDate.of(2016, 02, 01), LocalDate.of(2017, 01, 01));
	    	
	    	assertEquals(Integer.valueOf(0), result);
	    }

}
