package com.sjoedwards.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// Spring uses this when it scans our classes - automatically uses the beanID of thatSillyCoach
//@Component("thatSillyCoach")

// Its default bean id is now tennisCoach - Spring just lowercases the classname. Still need to include the annotation
@Component

// prototype - Create a new object every time you instantiate the class
//@Scope("prototype")
public class TennisCoach implements Coach {
	
	// 3. Even though this is private Spring will still be able to resolve this value using reflection! 
	
	@Autowired
	// Use Qualifier when you have multiple implementations of an interface and you want to tell spring which to use	
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
		
	// define a default constructor - just for a diagnostic method
	public TennisCoach() {
		System.out.println(">> TennisCoach: inside default constructor");
	}
	
	// define my init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println(">> TennisCoach: inside of doMyStartupStuff()");
	}
	
	// define my destroy method
	@PreDestroy 
	public void doMyCleanupStuff() {
		System.out.println(">> TennisCoach: inside of doMyCleanupStuff()");
	}
	
	// 2. setter methods - Define a setter methods - autowiring! Can call it anything you want will still do it 
//	@Autowired
//	public void doSomeCrazyStuff(FortuneService theFortuneService) {
//		System.out.println(">> TennisCoach: inside doSomeCrazyStuff");
//		fortuneService = theFortuneService;
//	}
//	
	// 1. Constructor - Autowired means that it will inject the service in if it can find a dependency that matches the interface 	
	//	@Autowired
//	public TennisCoach(FortuneService theFortuneService) {
//		fortuneService = theFortuneService;
//	}

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
