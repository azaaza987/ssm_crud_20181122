package com.atguigu.crud.test.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogBean {
	
	// 针对Target对象执行的方法，其增强的执行先后顺序是： 
//			@Around before 
//			@Before
//			Target.... 
//			@Around after 
//			@After
//			@AfterReturning
		
	
	@Pointcut("execution(* com.atguigu.crud.test.aop.UserBean.saveUser(..))")  
	public void pointCutMethod() {
	}
	
	@Before("pointCutMethod()")
	public void writeConsoleLog1() {
		System.out.println("LogBean......writeConsoleLog__2....");
	}
	
	@Before("pointCutMethod()")
	public void writeConsoleLog2() {
		System.out.println("LogBean......writeConsoleLog__1....");
	}
	

	@After("pointCutMethod()")
	public void writeDataBaseLog() {
		System.out.println("LogBean......writeDataBaseLog....");
	}
	
	@AfterReturning("pointCutMethod()")
	public void writeLogAfterRunning() {
		System.out.println("LogBean......writeLogAfterRunning....");
	}
	

    @Around("pointCutMethod()")
    public void  watchPerformance(ProceedingJoinPoint point){
        try {
            System.out.println("====print here before SaveUser");
            point.proceed();
            System.out.println("====print here After SaveUser");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
