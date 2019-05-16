package com.demo.service;

import static org.junit.Assert.*;
//import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.common.domain.CarTO;
import com.demo.common.domain.CustomerTO;
import com.demo.common.domain.RentalTO;
import com.demo.common.enums.CarType;
import com.demo.common.enums.Position;
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
import com.demo.persistence.entity.EmployeeEntity;
import com.demo.persistence.entity.RentalEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class CarServiceImplTest {
	
	@Autowired
	CarDao carRepository;
	@Autowired
	EmployeeDao employeeRepository;
	@Autowired
	AdressDao adressRepository;
	@Autowired
	CarService carService;
	@Autowired
	EmployeeService employeeService;
	@Autowired
	EmployeeDao employeRepository;
	@Autowired
	DepartamentDao departamentRepository;
	@Autowired
	RentalDao rentalRepository;
	@Autowired
	CustomerDao customerRepository;
	
	
	private EmployeeEntity employee1;
	private AdressEntity adress1;
	private DepartamentEntity dep1;
	private CarTO car1T;
	private CarTO car2T;
	private CarEntity car1;
	private CarEntity car2;
	private CarEntity car3;
	private CarEntity car4;
	private CarEntity car5;
	private CustomerEntity customer1;
	private CustomerTO customer1T;
	private RentalTO rent1T;
	private RentalTO rent2T;
	private RentalTO rent3T;
	private RentalTO rent4T;
	private RentalTO rent5T;
	private RentalEntity rent1;
	private RentalEntity rent2;
	private RentalEntity rent3;
	private RentalEntity rent4;
	private RentalEntity rent5;
	private Set<CarEntity> cars1 = new HashSet();
	
	
	@Before
	public void loadData() {
		
		adress1 = new AdressEntity("Strzegomska", "55-601", "Wroclaw", "Polska");
		adressRepository.save(adress1);
		dep1 = new DepartamentEntity(adress1, "1234", "dep1@wp.pl");
		departamentRepository.save(dep1);

		car1 = new CarEntity("Skoda", "Oktavia", "red", CarType.HATCHBACK, 1600, 100, 2012, 90000);
		car2 = new CarEntity("Skoda", "Fabia", "black", CarType.HATCHBACK, 1400, 90, 2014, 60000);
		car3 = new CarEntity("Mazda", "6", "blue", CarType.SEDAN, 1998, 140, 2016, 40000);
		car4 = new CarEntity("Ford", "Edge", "green", CarType.SUV, 2500, 160, 2018, 25000);
		car5 = new CarEntity("Peugot", "306", "black", CarType.HATCHBACK, 1400, 90, 2014, 60000);

		carRepository.save(car1);
		carRepository.save(car2);
		carRepository.save(car3);
		carRepository.save(car4);
		carRepository.save(car5);

		cars1.add(car1);
		cars1.add(car2);
		cars1.add(car3);
		cars1.add(car4);
		cars1.add(car5);
		
		employee1 = new EmployeeEntity("firstName1", "surName1", Position.ACCOUNTANT, dep1, cars1,
				LocalDate.of(1989, 11, 24));
		employee1.setDepartament(dep1);
		employeeRepository.save(employee1);
		
		customer1T = new CustomerTO("firstName1", "lastName1", adress1, "customer1@wp.pl", "111-222-333");
		customer1 = new CustomerEntity(customer1T);
		customerRepository.save(customer1);
		customer1 = customerRepository.getOne(1L);
		
		rent1T = new RentalTO (LocalDate.of(2018, 12, 20), dep1, LocalDate.of(2019, 01, 05), dep1, car1, customer1, 300.0);
		rent2T = new RentalTO (LocalDate.of(2018, 10, 24), dep1, LocalDate.of(2018, 11, 28), dep1, car1, customer1, 300.0);
		rent3T = new RentalTO (LocalDate.of(2018, 11, 24), dep1, LocalDate.of(2018, 12, 23), dep1, car3, customer1, 300.0);
		rent4T = new RentalTO (LocalDate.of(2019, 01, 24), dep1, LocalDate.of(2019, 02, 27), dep1, car4, customer1, 300.0);
		rent5T = new RentalTO (LocalDate.of(2019, 01, 10), dep1, LocalDate.of(2019, 03, 02), dep1, car1, customer1, 300.0);
		rent1 = new RentalEntity(rent1T);
		rent2 = new RentalEntity(rent2T);
		rent3 = new RentalEntity(rent3T);
		rent4 = new RentalEntity(rent4T);
		rent5 = new RentalEntity(rent5T);
		rentalRepository.save(rent1);
		rentalRepository.save(rent2);
		rentalRepository.save(rent3);
		rentalRepository.save(rent4);
		rentalRepository.save(rent5);
		rent1 = rentalRepository.getOne(1L);
		rent2 = rentalRepository.getOne(2L);
		rent3 = rentalRepository.getOne(3L);
		rent4 = rentalRepository.getOne(4L);
		rent5 = rentalRepository.getOne(5L);
	}


	@Test
	public void ShouldFind1CarsInListOfEmployeeCars() {
		//given
		CarTO car1T = new CarTO(car1);
		//when
		carService.setCarToHandler(employee1.getId(), car1T);
		//then
		EmployeeEntity empl = employeeRepository.findOne(employee1.getId());
		List<Long> cars = empl.getCars().stream().map(car->car.getId()).collect(Collectors.toList());
		
		assertEquals(6, cars1.size());	
		assertTrue(cars.contains(car1T.getId()));
	}
	
	@Test
	public void ShouldFind2CarsInListOfEmployeeCar() {
		//given
		CarTO car1T = new CarTO(car1);
		CarTO car2T= new CarTO(car2);
		//when
		carService.setCarToHandler(employee1.getId(), car1T);
		carService.setCarToHandler(employee1.getId(), car2T);
		//then
		EmployeeEntity empl = employeeRepository.findOne(employee1.getId());
		List<Long> cars = empl.getCars().stream().map(car->car.getId()).collect(Collectors.toList());
		
		assertEquals(7, cars1.size());
		assertTrue(cars.contains(car1T.getId()));
		assertTrue(cars.contains(car2T.getId()));
	}
	
	@Test
	public void ShouldCreateCarAndSetId() {
		//given
		car1T = new CarTO("Skoda", "Oktavia", "red", CarType.HATCHBACK, 1600, 100, 2012, 90000);
		//when
		CarTO result =carService.save(car1T);
		//then
		assertNotNull(result.getId());
	}
	
	@Test
	public void ShouldReturnListOfEmployeeCarsLessByOneAndListOfRentalsLessByTree() {	
		//when
		carService.delete(car1);
		List<RentalEntity> rentList = rentalRepository.findAll();
		//then
		assertEquals(4, cars1.size());
		assertEquals(2, rentList.size());
	}
	
	
	@Test
	public void shouldUpdateAlldetailAboutCar () {
		//given
		car1T = new CarTO("VolksWagen", "Passat", "green", CarType.SEDAN, 2000, 140, 2014, 50000);
		//when
		CarTO result = carService.update(car1T);
		//then
		assertEquals("VolksWagen", result.getBrand());
		assertEquals("Passat", result.getModel());
		assertEquals("green", result.getColor());
		assertEquals(CarType.SEDAN, result.getCarType());
		assertEquals((Integer)2000, result.getEngineCapacity());
		assertEquals((Integer)140, result.getPower());
		assertEquals((Integer)2014, result.getProductionYear());
		assertEquals((Integer)50000, result.getMileAge());
	}
}
