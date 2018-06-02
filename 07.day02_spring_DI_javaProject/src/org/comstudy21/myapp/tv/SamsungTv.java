package org.comstudy21.myapp.tv;


import org.comstudy21.myapp.speaker.Speaker;

public class SamsungTv implements TV {

	private String name = "삼성티비";
	private Speaker speaker = null;
	
	public SamsungTv(){
		System.out.println("삼성티비 생성자");
	}
	
	public SamsungTv(Speaker speaker){
		this.speaker = speaker;
	}
	
	/*
	public void setSpeaker(Speaker speaker){
		this.speaker = speaker;
	}
	*/
	
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
		//System.out.println(name + " 볼륨을 높인다.");
		speaker.volumeUp();
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		//System.out.println(name + " 볼륨을 낮춘다.");
		speaker.volumeDown();
	}
	
	

}
