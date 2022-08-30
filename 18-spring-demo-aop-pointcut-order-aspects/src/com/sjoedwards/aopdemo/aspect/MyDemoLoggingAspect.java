package com.sjoedwards.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	// this is where we add all our related advices for logging
	
	// we'll start with an @Before advice
	
	
	//	@Before("execution(public void add*())")
	// So the one below, we're saying that ONLY if the PARAM is com.sjoedwards.aopdemo.dao.Account will the Aspect Spy fire
	//	@Before("execution(* add*(com.sjoedwards.aopdemo.dao.Account))")
	// The .. means that it will match any further parameters
	//	@Before("execution(* add*(com.sjoedwards.aopdemo.Account, ..))")
	// This will match any method..
	//	@Before("execution(* add*(..))"
	// This will match any method but only in this package (for any parameters)
//	@Before("execution(* com.sjoedwards.aopdemo.dao.*.*(..))")
	// This will match methods which return void but only in this package (for any parameters)
	//	@Before("execution(void com.sjoedwards.aopdemo.dao.*.*(..))")


	
	@Before("com.sjoedwards.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n====>>>>> Executing @Before advice on addAccount()");
	}
}
