package com.sjoedwards.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sjoedwards.aopdemo.dao.AccountDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// call method to find the accounts
		List<Account> theAccounts = null;
				
		try {
			// add a boolean flag to simulate exception
			boolean tripWire = true;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		} catch(Exception exc) {
			System.out.println("Exception when trying to find accounts: " + exc);
		}
		
		// display the accounts
		System.out.println("\n\nMain program: AfterThrowingDemoApp");
		System.out.println("-----");
		System.out.println(theAccounts);

		// close the context
		context.close();
	}

}
