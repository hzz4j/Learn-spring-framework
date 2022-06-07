package org.tx;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.tx.config.AppConfig;
import org.tx.service.UserService;


public class Application {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userService = context.getBean("userService", UserService.class);
		userService.test();
	}
}
