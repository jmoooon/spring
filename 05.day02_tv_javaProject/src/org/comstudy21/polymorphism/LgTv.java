package org.comstudy21.polymorphism;

public class LgTv implements TV {

	private String name = "엘지티비";
	
	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println(name + " 전원을 켠다.");
	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println(name + " 전원을 끈다.");
	}

	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		System.out.println(name + " 볼륨을 높인다.");
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		System.out.println(name + " 볼륨을 낮춘다.");
	}

}
