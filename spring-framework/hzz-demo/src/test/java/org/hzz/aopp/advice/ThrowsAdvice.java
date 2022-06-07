package org.hzz.aopp.advice;

import java.lang.reflect.Method;

public class ThrowsAdvice implements org.springframework.aop.ThrowsAdvice {
	public void afterThrowing(Method method,Object[] args,Object target,NullPointerException ex){
		System.out.println("方法抛出异常后执行");
	}
}
