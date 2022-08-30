package com.sjoedwards.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sjoedwards.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	// add a new method called findAccounts
	
	public List<Account> findAccounts(boolean tripWire) {
		if (tripWire) {
			throw new RuntimeException("Test");
		}
		
		List<Account> myAccounts = new ArrayList<>();
		// create sample accounts
		Account temp1 = new Account("temp1", "Bronze");
		Account temp2 = new Account("temp2", "Silver");
		Account temp3 = new Account("temp3", "Gold");

		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);

		
		// add them to our list
		return myAccounts;
	}
	
	
	public String getName() {
		System.out.println(getClass() + ": getting a name");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": setting a name");
		this.name = name;
	}


	public String getServiceCode() {
		System.out.println(getClass() + ": getting a password");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": setting a service code");
		this.serviceCode = serviceCode;
	}

	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
	}
	
	public boolean doWork() {
		System.out.println(getClass() + ": do work");
		return true;
	}
}
