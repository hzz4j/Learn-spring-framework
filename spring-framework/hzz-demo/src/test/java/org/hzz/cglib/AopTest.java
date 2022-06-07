package org.hzz.cglib;

import org.springframework.cglib.proxy.*;

import java.lang.reflect.Method;

public class AopTest {
	public static void main(String[] args) {
		AopTest target = new AopTest();
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(AopTest.class);
		enhancer.setCallbacks(new Callback[]{
				new MethodInterceptor() {
					@Override
					public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
						System.out.println("before");
						method.invoke(target,objects);
						System.out.println("after");
						return null;
					}
				}
		,NoOp.INSTANCE});

		// 指定使用数组中的MethodInterceptor
		enhancer.setCallbackFilter(new CallbackFilter() {
			@Override
			public int accept(Method method) {
				String name = method.getName();
				if(name.equals("test")){
					return 0;
				}else{
					return 1;
				}
			}
		});


		AopTest o = (AopTest)enhancer.create();
		o.test();
		o.a();
	}

	public void test(){
		System.out.println("test");
	}
	public void a(){
		System.out.println("a");
	}
}
