package org.hzz.aopp.config;

import org.aopalliance.aop.Advice;
import org.hzz.aopp.advice.BeforeAdvice;

import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.*;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;

@Configuration(proxyBeanMethods = true)
@ComponentScan("org.hzz.aopp")
@Import(DefaultAdvisorAutoProxyCreator.class) // 简化bean的导入
public class AppConfig {

	@Bean("beforeAdvice")
	public Advice beforeAdvice(){
		BeforeAdvice beforeAdvice = new BeforeAdvice();
		return beforeAdvice;
	}

	@Bean
	@DependsOn("beforeAdvice")
	public DefaultPointcutAdvisor defaultPointcutAdvisor(BeforeAdvice beforeAdvice){
		NameMatchMethodPointcut nameMatchMethodPointcut = new NameMatchMethodPointcut();
		nameMatchMethodPointcut.addMethodName("test");
		DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
//		advisor.setAdvice(new BeforeAdvice());
		advisor.setAdvice(beforeAdvice);
		advisor.setPointcut(nameMatchMethodPointcut);
		return advisor;
	}

//	@Bean
//	public ProxyFactoryBean userService(){
//		ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
//		proxyFactoryBean.setTarget(new UserServiceImpl());
//		proxyFactoryBean.setInterceptorNames("beforeAdvice");
//		return proxyFactoryBean;
//	}

	@Bean
	public BeanNameAutoProxyCreator beanNameAutoProxyCreator(){
		BeanNameAutoProxyCreator beanNameAutoProxyCreator = new BeanNameAutoProxyCreator();
		beanNameAutoProxyCreator.setBeanNames("userSe*");
		beanNameAutoProxyCreator.setInterceptorNames("beforeAdvice");
		beanNameAutoProxyCreator.setProxyTargetClass(true);
		return beanNameAutoProxyCreator;
	}
}
