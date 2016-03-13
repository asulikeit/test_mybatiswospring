package com.multicampus.biz.user;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.multicampus.biz.user.UserService;
import com.multicampus.biz.user.UserVO;

public class UserServiceClient {
	public static void main(String[] args) {
		// 1. Spring ̳
		ApplicationContext container = 
			new ClassPathXmlApplicationContext("applicationContext.xml");

		// 2. Spring ̳UserService Lookup.
		UserService userService = 
			(UserService) container.getBean("userService");
		
		// 3. userService
		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPassword("test");
		UserVO user = userService.getUser(vo);
		if(user != null) {
			System.out.println(user.getName() + " .");
		} else {
			System.out.println(" error ");
		}
	}
}




