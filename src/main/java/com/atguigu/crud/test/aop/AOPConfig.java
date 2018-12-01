package com.atguigu.crud.test.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
//@ComponentScan(value="com.atguigu.crud.test.aop")
//@ComponentScan(basePackages = { "com.atguigu.crud.test.aop"}) 
@EnableAspectJAutoProxy
public class AOPConfig {
	
	@Bean
	public UserBean userBean() {
		return new UserBean();
	}
	
	@Bean
	public LogBean logBean() {
		return new LogBean();
	}

}
