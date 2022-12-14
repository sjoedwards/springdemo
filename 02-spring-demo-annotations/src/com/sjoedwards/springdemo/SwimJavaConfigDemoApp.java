package com.sjoedwards.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		// read spring configuration CLASS - no xml!
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get the bean from the spring container
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
		
		// call the method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// call method to get daily fortune
		
		System.out.println(theCoach.getDailyFortune());
		
		// Call our new lines 
		System.out.println("email: " + theCoach.getEmail());
		System.out.println("email: " + theCoach.getTeam());
		
		// close the context
		context.close();

	}

}
