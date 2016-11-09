package com.example.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.beans.Car;
import com.example.repositories.CarRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class CarMongoServiceTest {

	@Autowired
	private CarService service;
	@Autowired
	private CarRepository repository;
	
	@Before
	public void setUp() throws Exception {
		Car car = new Car("idForTest", "TestCarName");
		List<Car> asList = new ArrayList<Car>();
		asList.add(car);
		Mockito.when(repository.findAll()).thenReturn(asList);
	}

	@Test
	public void testGetAllCars() {
		List<Car> allCars = service.getAllCars();
		System.out.println(allCars);
		assertEquals(1, allCars.size());
	}

	
	@Configuration
	static class CarServiceTestContextConfiguration {
		@Bean
		public CarMongoService carService() {
			return new CarMongoService();
		}
		@Bean
		public CarRepository carRepository() {
			return Mockito.mock(CarRepository.class);
		}
	}

}