package com.shang.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class AOPConfig {
	
	@Around("@within(org.springframework.stereotype.Controller)")
	public Object simpleAop(final ProceedingJoinPoint pjp) throws Throwable{
		long beginDt = System.currentTimeMillis();
		System.out.println("Begin DT"+beginDt);
		Object[] obj = pjp.getArgs();
		System.out.println("原方法参数="+Arrays.asList(obj));
		//调用原方法
		Object o = pjp.proceed();
		long endDt = System.currentTimeMillis();
		System.out.println("endDt DT"+endDt);
		long p = endDt-beginDt;
		System.out.println("p"+p);
		System.out.println("原方法结果"+o);
		return o;
	}
	
}
