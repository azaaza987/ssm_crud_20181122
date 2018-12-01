package com.atguigu.crud.test.aop;

import org.springframework.stereotype.Component;

@Component
public class UserBean {
	
	public void saveUser() {
		System.out.println("UserBean ..... saveUser().....");
	}

}
