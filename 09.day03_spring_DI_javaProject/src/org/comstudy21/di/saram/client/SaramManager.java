package org.comstudy21.di.saram.client;

import org.comstudy21.di.saram.Saram;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SaramManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Lookup 방식
		String resource ="applicationContext.xml";
		@SuppressWarnings("resource")
		AbstractApplicationContext factory = new GenericXmlApplicationContext(resource);
		
		Saram rambo = (Saram) factory.getBean("rambo");
		rambo.say();
		rambo.work();
		
		Saram leesoryong = (Saram) factory.getBean("leesoryong");
		leesoryong.say();
		leesoryong.work();
	}

}
