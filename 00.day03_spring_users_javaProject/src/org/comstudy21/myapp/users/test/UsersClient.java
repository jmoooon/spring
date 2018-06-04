package org.comstudy21.myapp.users.test;


import java.util.List;

import org.comstudy21.myapp.users.model.Users;
import org.comstudy21.myapp.users.service.UsersService;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UsersClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		Users ur = (Users) factory.getBean("users");
		ur.setId("1");
		ur.setPassword("1");
		ur.setName("정지미");
		ur.setRole("어드민");
		
		UsersService usersService = (UsersService) factory.getBean("usersService");
		
		usersService.insertUser(ur);
		
		List<Users> userList = usersService.selectAll();
		for(Users urItem : userList) {
			System.out.println(urItem.getId());
			System.out.println(urItem.getPassword());
			System.out.println(urItem.getName());
			System.out.println(urItem.getRole());
		}
	}

}
