package org.hzz.cglib;


import org.hzz.cglib.org.hzz.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userService = context.getBean("userService", UserService.class);
		userService.test();
	}
}
