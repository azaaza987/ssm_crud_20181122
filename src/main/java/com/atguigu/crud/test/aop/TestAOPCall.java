package com.atguigu.crud.test.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestAOPCall {
	
	@Test
	public void testAop() {
		
		// 通过Annotation 配置方式获取Bean
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AOPConfig.class);
		UserBean bean = (UserBean)context.getBean("userBean");
		bean.saveUser();
		
		System.out.println("******************************************");
		
		// 通过配置方式获取Bean
//		ApplicationContext tx = new ClassPathXmlApplicationContext("IOC.xml");  
//		UserBean user = (UserBean) tx.getBean("userBean");
//		System.out.println(user);
//		user.saveUser();
		
		
	}

}
