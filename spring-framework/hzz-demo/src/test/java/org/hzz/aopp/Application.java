package org.hzz.aopp;

import org.hzz.aopp.config.AppConfig;
import org.hzz.aopp.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//		UserService userService = context.getBean("userService", UserService.class);
//		userService.test();
	}
}
