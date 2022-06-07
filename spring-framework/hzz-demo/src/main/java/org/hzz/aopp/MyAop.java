package org.hzz.aopp;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAop implements Ordered {

//	@Before("execution(public void org.hzz.aop.UserService.test())")
	@Before("execution(public void org.hzz.aopp.TestUserSrv.test())")
	public void before(JoinPoint joinPoint){
		System.out.println("----------------before---------------------------");
	}

	@Pointcut("execution(public void org.hzz.aopp.TestUserSrv.test())")
	public void a(){}

	@After("a()")
	public void after(JoinPoint joinPoint){
		System.out.println("----------------after---------------------------");
	}

	@Override
	public int getOrder() {
		return 0;
	}
}
