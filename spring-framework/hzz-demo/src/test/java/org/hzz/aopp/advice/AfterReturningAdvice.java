package org.hzz.aopp.advice;

import java.lang.reflect.Method;

public class AfterReturningAdvice implements org.springframework.aop.AfterReturningAdvice {
	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("after");
	}
}
