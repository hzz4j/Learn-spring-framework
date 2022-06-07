package org.hzz.aopp.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class AroundAdvice implements MethodInterceptor {
	@Nullable
	@Override
	public Object invoke(@Nonnull MethodInvocation invocation) throws Throwable {
		System.out.println("around before");
		Object proceed = invocation.proceed();
		System.out.println("around after");
		return proceed;
	}
}
