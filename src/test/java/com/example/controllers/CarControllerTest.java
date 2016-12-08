package com.example.controllers;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.beans.Car;
import com.example.service.CarService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class CarControllerTest {

	private MockMvc mockMvc;
	
	@Autowired
	private CarController carController;
	
	@Autowired 
	private CarService carServiceMock;
	
	@Before
	public void setUp() throws Exception {
		Car car1 = new Car("111", "FirstCar");
		Car car2 = new Car("222", "SecondCar");
		Mockito.when(carServiceMock.getAllCars()).thenReturn(Arrays.asList(car1, car2));
		Mockito.doAnswer(new Answer<Void>() {

			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				return null;
			}
		}).when(carServiceMock).deleteCar(Mockito.anyString());
		mockMvc = MockMvcBuilders.standaloneSetup(this.carController).build();
	}

	@Test
	public void testGetTrainList() throws Exception {
		mockMvc.perform(get("/cars/carlist.json")).andExpect(status().isOk())
		.andExpect(jsonPath("$", hasSize(2)))
		.andExpect(jsonPath("$[0].id", is("111")))
		.andExpect(jsonPath("$[0].name", is("FirstCar")));
		
		Mockito.verify(carServiceMock, Mockito.times(1)).getAllCars();
		Mockito.verifyNoMoreInteractions(carServiceMock);
	}
	
	@Test
	public void testRemoveCar() throws Exception {
		mockMvc.perform(delete("/cars/removeCar/FirstCar")).andExpect(status().isOk());
		Mockito.verify(carServiceMock, Mockito.times(1)).deleteCar("FirstCar");
		Mockito.verifyNoMoreInteractions(carServiceMock);
	}
	
	@Configuration
	static class CarControllerTestContextConfiguration {
		@Bean
		public CarService carService() {
			return Mockito.mock(CarService.class);
		}
		
		@Bean
		public CarController carController() {
			return new CarController();
		}
	}
}