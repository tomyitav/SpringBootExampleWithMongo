package com.example.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stub")
public class StubController {
	
	@RequestMapping(value = "/stublist.json", method = RequestMethod.GET)
    public List<String> getCarList() {
		List<String> l = Arrays.asList("Hi", "Stub", "Controller");
        return l;
    }
}
