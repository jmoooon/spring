package org.comstudy21.di.saram.weapon;
import org.springframework.stereotype.Component;

@Component
public class Sword implements Weapon {

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("칼을 휘두른다.");

	}

}
