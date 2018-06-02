package org.comstudy21.myapp;

import org.comstudy21.myapp.tv.TV;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TvUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Lookup 방식
		String resources = "applicationContext.xml";
		AbstractApplicationContext factory = new GenericXmlApplicationContext(resources);
		
		TV tv = (TV) factory.getBean("samsung");
		//TV tv = new SamsungTv();
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
	}
}
