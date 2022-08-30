package com.sjoedwards.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sjoedwards.aopdemo.dao.AccountDAO;
import com.sjoedwards.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// get membership bean from spring container
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		Account theAccount = new Account();
		theAccount.setName("Test");
		theAccount.setLevel("Platinum");
		// call the business method
		theAccountDAO.addAccount(theAccount, true);	
		theAccountDAO.doWork();
		
		// call the accountdao getter/setter methods
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");

		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();
		
		// call the membership method
		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();
		
		// close the context
		context.close();
	}

}
