package com.example.service;

import java.util.List;

import com.example.beans.Car;

public interface CarService {
    public List<Car> getAllCars();

    public void addCar(Car car);

    public void deleteCar(String name);

    public void deleteAll();
    
    public void updateCar(Car car);
}