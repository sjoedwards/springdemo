package com.sjoedwards.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {
	@Pointcut("execution(* com.sjoedwards.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	// create a point cut for getter methods
	@Pointcut("execution(* com.sjoedwards.aopdemo.dao.*.get*(..))")
	public void getter() {};
	
	// create a point cut for the setter methods
	@Pointcut("execution(* com.sjoedwards.aopdemo.dao.*.set*(..))")
	public void setter() {};
	
	
	// createpointcut: include the package but excute the getter and setters
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {}
}
