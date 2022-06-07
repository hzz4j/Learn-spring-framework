package org.hzz.aopp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan("org.hzz.aopp")
@EnableAspectJAutoProxy(proxyTargetClass = false)
public class Application {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
		IService userService = (IService)context.getBean("testUserSrv");
		userService.test();
		System.out.println(userService);
	}
}
