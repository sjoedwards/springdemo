package com.sjoedwards.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.sjoedwards.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	// After is very much like finally in a try catch block
	@After("execution(* com.sjoedwards.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		// print out the method we're advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n Executing @After (finally) on method: " + method);
	}
	
	
	// add a new advice for @AfterReturning on the findAccounts method
	@AfterReturning(pointcut="execution(* com.sjoedwards.aopdemo.dao.AccountDAO.findAccounts(..))", returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		
		// print out the method we're advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n Executing @AfterReturning on method: " + method);
		
		// print out the results of the method call
		myLogger.info("\n Executing @AfterReturning, result is: " + result);
		
		// lets post-process the data... lets modify it
		
		// convert the account names to uppercase
		convertAccountNamesToUpperCase(result);
		myLogger.info("\n Executing @AfterReturning post-processing, result is: " + result);

	}
	
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		// loop through accounts
		
		for (Account tempAccount: result) {
			// get uppercase version of account name
			String theUpperName = tempAccount.getName().toUpperCase();
			// update the name
			tempAccount.setName(theUpperName);
		}
		
	}


	@Before("com.sjoedwards.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		myLogger.info("Execution of @Before advice on method");
		// display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		myLogger.info("Method: " + methodSig); 
		
		// display the method arguments
		
		// get args
		Object[] args = theJoinPoint.getArgs();
		
		// loop through the args 
		for (Object tempArg: args) { 
			myLogger.info(tempArg.toString());
			if (tempArg instanceof Account) {
				// downcast and print Account specific stuff
				Account theAccount = (Account) tempArg;
				myLogger.info("account name: " + theAccount.getName()); 
				myLogger.info("account level: " + theAccount.getLevel()); 

			}
		}
	}
	
	@AfterThrowing(pointcut="execution(* com.sjoedwards.aopdemo.dao.AccountDAO.findAccounts(..))", throwing="theExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		
		// print out method we're advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n After throwing " + method);

		// log the exception
		myLogger.info("\n The exception is: " + theExc);
	}
	
	@Around("execution(* com.sjoedwards.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		// print out method we're advising on
		// print out the method we're advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n Executing @AfterReturning on method: " + method);

		// get the beginning timestamp
		long begin = System.currentTimeMillis();
		
		// execute the method
		Object result = theProceedingJoinPoint.proceed();
		
		// end timestamp
		long end = System.currentTimeMillis();
		
		// compute duration
		long duration = end - begin;
		myLogger.info("\n Duration: " + duration / 1000.0 + " seconds");

		return result;
	}
}
