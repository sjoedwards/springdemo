package com.sjoedwards.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

// Order can be used to tell when to run the Aspect in a chain - lower number higher priority
@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {
	@Before("com.sjoedwards.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void logToCloudAsync() {
		System.out.println("\n =====>> Performing Log to Cloud async");
	}
}
