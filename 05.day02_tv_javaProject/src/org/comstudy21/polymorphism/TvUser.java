package org.comstudy21.polymorphism;

public class TvUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//BeanFactory factory = new BeanFactory();
		BeanFactory factory = BeanFactory.getInstance();
		
		TV tv = (TV) factory.getBean(args[0]);
		//TV tv = new SamsungTv();
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
	}
}
