package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.beans.Car;
import com.example.repositories.CarRepository;

@Service
public class CarMongoService implements CarService{

	@Autowired
	private CarRepository repository;

	@Override
	public List<Car> getAllCars() {
		return repository.findAll();
	}

	@Override
	public void addCar(Car car) {
		repository.save(car);
	}

	@Override
	public void deleteCar(String name) {
		repository.deleteCarByName(name);
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
	}
	

}