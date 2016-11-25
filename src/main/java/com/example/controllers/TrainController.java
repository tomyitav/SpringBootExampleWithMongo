package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.beans.Train;
import com.example.service.TrainService;

@Controller
@RequestMapping("/trains")
public class TrainController {

    @Autowired
    private TrainService service;

    @RequestMapping("trainslist.json")
    public @ResponseBody List<Train> getTrainList() {
    	return service.getAllTrains();
    }

    @RequestMapping(value = "/addTrain", method = RequestMethod.POST)
    public @ResponseBody void addTrain(@RequestBody Train train) {
        service.addTrain(train);
    }

    @RequestMapping(value = "/updateTrain", method = RequestMethod.PUT)
    public @ResponseBody void updateTrain(@RequestBody Train train) {
        service.updateTrain(train);
    }

    @RequestMapping(value = "/removeTrain/{id}", method = RequestMethod.DELETE)
    public @ResponseBody void removeTrain(@PathVariable("id") String id) {
        service.deleteTrainById(id);
    }

    @RequestMapping(value = "/removeAllTrains", method = RequestMethod.DELETE)
    public @ResponseBody void removeAllTrains() {
        service.deleteAll();
    }

    @RequestMapping("/layout")
    public String getTrainPartialPage(ModelMap modelMap) {
        return "trains/layout";
    }
}