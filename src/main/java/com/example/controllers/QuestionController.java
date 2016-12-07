package com.example.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class QuestionController {

	@MessageMapping("/questions")
	public String processQuestion(String question){
		System.out.println("Begin transformation of " + question);
		return question;
	}
}
