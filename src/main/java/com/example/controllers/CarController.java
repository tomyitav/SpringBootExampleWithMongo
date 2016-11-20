package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.beans.Car;
import com.example.service.CarService;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired 
    private CarService service;

    @RequestMapping(value = "/carlist.json", method = RequestMethod.GET)
    public List<Car> getCarList() {
        return service.getAllCars();
    }

    @RequestMapping(value = "/addCar", method = RequestMethod.POST)
    public void addCar(@RequestBody Car car) {
        service.addCar(car);
    }

    @RequestMapping(value = "/removeCar/{car}", method = RequestMethod.DELETE)
    public void removeCar(@PathVariable("car") String car) {
        service.deleteCar(car);
    }

    @RequestMapping(value = "/removeAllCars", method = RequestMethod.DELETE)
    public void removeAllCars() {
        service.deleteAll();
    }

    @RequestMapping("/layout")
    public String getCarPartialPage() {
        return "cars/layout";
    }
}