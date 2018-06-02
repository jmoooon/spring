package org.comstudy21.myapp.speaker;

public class AppleSpeaker implements Speaker {

	private String maker = "애플스피커";
	
	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		System.out.println(maker + " 볼륨을 높임");
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		System.out.println(maker + " 볼륨을 낮춤");
	}

	public AppleSpeaker() {
		System.out.println("애플스피커 생성자");
	}

}
