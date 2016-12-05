package com.example.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@RequestMapping("/stub")
public class StubController {
	
//	private List<SseEmitter> emmiters = new CopyOnWriteArrayList<>();
//	
//	@RequestMapping("/questions")
//	public SseEmitter questions(){
//		SseEmitter sseEmitter = new SseEmitter();
//		emmiters.add(sseEmitter);
//		sseEmitter.onCompletion(() -> emmiters.remove(sseEmitter));
//		return sseEmitter;
//	}
//	
//	@RequestMapping(value = "/new-question", method = RequestMethod.POST)
//	public void postQuestion(String question) {
//		for(SseEmitter e : emmiters) {
//			try {
//				e.send(SseEmitter.event().name("spring").data(question));
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		}
//	}
	
	@RequestMapping(value = "/stublist.json", method = RequestMethod.GET)
    public List<String> getCarList() {
		List<String> l = Arrays.asList("Hi", "Stub", "Controller");
        return l;
    }
}
