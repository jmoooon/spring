package org.comstudy21.myapp.tv;

import org.comstudy21.myapp.speaker.Speaker;

public class LgTv implements TV {

	private String name = "엘지티비";
	private Speaker speaker = null;
	
	public LgTv(){
		System.out.println("엘지티비 생성자");
	}
	
	public LgTv(Speaker speaker){
		this.speaker = speaker;
	}
	
	public void setSpeaker(Speaker speaker){
		this.speaker = speaker;
	}
	
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
	
	public void initMethod(){
		System.out.println("LG TV 초기화 메소드");
	}
	
	public void close(){
		System.out.println("LG TV 종료 메소드");
	}

}
