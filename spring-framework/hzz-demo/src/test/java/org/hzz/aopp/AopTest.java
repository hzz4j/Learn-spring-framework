package org.hzz.aopp;

import org.aopalliance.aop.Advice;
import org.hzz.aopp.advice.BeforeAdvice;
import org.hzz.aopp.service.UserService;
import org.hzz.aopp.service.impl.UserServiceImpl;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;
import java.util.Arrays;

public class AopTest {
	public static void main(String[] args) {
		UserService target = new UserServiceImpl();
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(target);
//		proxyFactory.addAdvice(new BeforeAdvice());
//		proxyFactory.addAdvice(new AfterReturningAdvice());
//		proxyFactory.addAdvice(new ThrowsAdvice());
//		proxyFactory.addAdvice(new AroundAdvice());
		proxyFactory.setProxyTargetClass(true);

		proxyFactory.addAdvisor(new PointcutAdvisor() {
			@Override
			public Pointcut getPointcut() {
				return new Pointcut() {
					@Override
					public ClassFilter getClassFilter() {
						return new ClassFilter() {
							@Override
							public boolean matches(Class<?> clazz) {
								return clazz == UserServiceImpl.class;
							}
						};
					}

					@Override
					public MethodMatcher getMethodMatcher() {
						return new MethodMatcher() {
							@Override
							public boolean matches(Method method, Class<?> targetClass) {
								return method.getName().equals("testABC");
							}

							@Override
							public boolean isRuntime() {
								return true;
							}

							@Override
							public boolean matches(Method method, Class<?> targetClass, Object... args) {
								System.out.println("-------------run time agrs-------------------");
								System.out.println(Arrays.toString(args));
								System.out.println("-----------------------------------------");
								return true;
							}
						};
					}
				};
			}

			@Override
			public Advice getAdvice() {
				return new BeforeAdvice();
			}

			@Override
			public boolean isPerInstance() {
				return false;
			}
		});

		UserService proxy = (UserService)proxyFactory.getProxy();
		proxy.test();
		proxy.testABC("hzz",100);

	}
}
