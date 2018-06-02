package org.comstudy21.di.saram;

import org.comstudy21.di.saram.weapon.Weapon;

public class LeeSoryong implements Saram {
	private Weapon weapon = null;
	
	@Override
	public void setWeapon(Weapon weapon){
		this.weapon = weapon;
	}
	
	@Override
	public void say() {
		// TODO Auto-generated method stub
		System.out.println("이소령이 말한다.");
	}

	@Override
	public void work() {
		// TODO Auto-generated method stub
		System.out.println("이소령이 쌍절곤을 휘두른다.");
		weapon.play();
	}

}
