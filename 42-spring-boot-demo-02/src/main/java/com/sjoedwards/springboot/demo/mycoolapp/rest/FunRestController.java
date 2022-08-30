package com.sjoedwards.springboot.demo.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	// Expose a basic endpoint to return hello world
	@GetMapping("/")
	public String sayHello() {
		return "Hello World! Time on the server is" + LocalDateTime.now();
	}
	
	// Expose a basic endpoint to return hello world
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}
	
	// expose a new endpoint for fortune
	// Expose a basic endpoint to return hello world
	@GetMapping("/fortune")
	public String getDailyFortune() {
		return "Your lucky day";
	}
}
