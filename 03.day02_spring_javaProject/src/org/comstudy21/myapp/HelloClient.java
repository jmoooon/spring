package org.comstudy21.myapp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloClient {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//HelloWorld hello = new HelloWorld();
		//hello.sayHello("홍길동");
		
		//교재 p.52 참조
		String resources = "applicationContext.xml";
		AbstractApplicationContext factory = new GenericXmlApplicationContext(resources);
		
		HelloWorld helloWorld = (HelloWorld) factory.getBean("helloWorld");
		helloWorld.sayHello("김길동");
	}
}
