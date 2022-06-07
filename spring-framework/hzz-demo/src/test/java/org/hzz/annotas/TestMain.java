package org.hzz.annotas;

import org.aspectj.lang.annotation.Pointcut;
import org.junit.jupiter.api.Test;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestMain {

	public static void main(String[] args) {
//		List<Method> methods = new ArrayList<>();
//		ReflectionUtils.MethodFilter adviceMethodFilter = method ->
//				AnnotationUtils.getAnnotation(method, MyBefore.class) != null;
//		// 获取到所有类中除了标注@PointCut的所有方法
//		ReflectionUtils.doWithMethods(TestAspect.class, methods::add, adviceMethodFilter);
//		System.out.println(methods);
		Method declaredMethod = TestAspect.class.getDeclaredMethods()[0];
//		MyParent annotation = AnnotationUtils.getAnnotation(declaredMethod, MyParent.class);
//		System.out.println(declaredMethod);
//		System.out.println(annotation);

		Annotation[] declaredAnnotations = declaredMethod.getDeclaredAnnotations();
		System.out.println(Arrays.toString(declaredAnnotations));
		MyParent annotation1 = declaredMethod.getAnnotation(MyParent.class);
		System.out.println(annotation1);
	}
}
