package com.sjoedwards.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanscope-applicationContext.xml");
		// retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
			
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		// check if these are the same beans
		
		boolean result = (theCoach == alphaCoach);
		
		// print
		System.out.println("\nPointing to the same object " + result);
		
		// The default will print out the internal memory address		
		System.out.println("\nmemory location for theCoach " + theCoach);
		
		System.out.println("\nmemory location for theCoach " + alphaCoach + "\n");
		
		context.close();


	}

}
