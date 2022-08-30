package com.sjoedwards.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sjoedwards.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get bean from spring container
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		System.out.println("\n Main program - aroundDemoApp");
		System.out.println("\n Calling getFortune");
		
		String data = theFortuneService.getFortune();
		
		System.out.println("\n My fortune is: " + data);
		
		// close the context
		context.close();
	}

}
