package com.example.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.TextMessage;

@Controller
public class QuestionController {

	@MessageMapping("/hello")
	@SendTo("/topic/questions")
	public TextMessage processQuestion(TextMessage question){
		System.out.println("Begin transformation of " + question);
		return question;
	}
}
