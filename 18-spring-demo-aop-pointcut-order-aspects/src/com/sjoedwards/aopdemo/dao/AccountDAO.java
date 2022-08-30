package com.sjoedwards.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.sjoedwards.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	
	public String getName() {
		System.out.println(getClass() + ": getting a name");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": setting a name");
		this.name = name;
	}

	private String serviceCode;

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
