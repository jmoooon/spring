package org.comstudy21.myapp.users.client;

import java.util.List;

import org.comstudy21.myapp.users.service.UserService;
import org.comstudy21.myapp.users.vo.UserVo;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		UserService userService = (UserService) factory.getBean("userService");
		
		/*
		List<UserVo> listVo = userService.getUserList();
		
		for(UserVo vo : listVo){
			System.out.println(vo.getId());
			System.out.println(vo.getPassword());
			System.out.println(vo.getName());
			System.out.println(vo.getRole());
		}
		*/
		
		UserVo userVo = new UserVo();
		userVo.setId("KIM");
		userVo.setPassword("1234");
		UserVo getUser = userService.getUser(userVo);
		System.out.println(getUser);
		
		if(getUser != null){
			System.out.println(getUser.getName() + "님 안녕하세요!");
		}
		else{
			System.out.println("로그인 실패!");
		}
		
		factory.close();
	}

}
