package com.stackroute.activity.rest.aspect;


import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Aspect
public class LoginStatusHandler {

	/*@Before("execution(* com.stackroute.activity.rest.controller.CircleRestController.getAllCircles(..)) && args(HttpServletRequest)")
	public void logBefore(JoinPoint joinPoint,HttpServletRequest request) {

		System.out.println("logBefore() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("******");
	}*/

}
