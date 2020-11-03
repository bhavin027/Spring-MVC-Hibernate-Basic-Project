package org.bhavin.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	// setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	//setup pointcut declarations
	@Pointcut("execution(* org.bhavin.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* org.bhavin.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* org.bhavin.springdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	// add @Before Advice
	@Before("forAppFlow()")
	private void before(JoinPoint theJoinPoint) {
		//display method we are calling
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("===>>> @Before calling method: "+method);
		
		//display arguments for the method
		
		// get arguments
		Object[] args = theJoinPoint.getArgs();
		
		// loop throu to display args
		for(Object tempArgs : args) {
			myLogger.info("===>>> Args: "+tempArgs);
		}
		
	}
	
	// add @AfterReturning Advice
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="theResult"
			)
	private void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		//display method we are returning
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("===>>> @AfterReturning from method: "+method);
		
		//display the data returned
		myLogger.info("===>>> Result: "+ theResult);
		
	}
}
