package com.toby.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAsepct {
	@Pointcut("execution(* com.toby.Controller.*.*(..))")
	private void logForController() {
	};

	@Pointcut("execution(* com.toby.Dao.*.*(..))")
	private void logForDao() {
	};

	@Pointcut("execution(* com.toby.Service.*.*(..))")
	private void logForService() {
	};
	
	@Before("logForController() || logForDao() || logForService()")
	private void LogBeore(JoinPoint joinpoint) {
		System.out.println("<================>");
		System.out.println("Before");
		MethodSignature methodSignature = (MethodSignature)joinpoint.getSignature();
		System.out.println(methodSignature);
		Object[] objects = joinpoint.getArgs();
		for(Object obj: objects) {
			System.out.println(obj);
		}
		System.out.println("<================>");
	}
	
	@AfterReturning(pointcut="logForController() || logForDao() || logForService()",returning="result")
	private void LogAfter(JoinPoint joinpoint,Object result) {
		System.out.println("<================>");
		System.out.println("After");
		MethodSignature methodSignature = (MethodSignature)joinpoint.getSignature();
		System.out.println(methodSignature);
		System.out.println("Result:" + result);
		System.out.println("<================>");
	}
}
