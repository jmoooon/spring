package org.comstudy21.di.saram;

import org.comstudy21.di.saram.weapon.Weapon;

public class Rambo implements Saram {
	private Weapon weapon = null;
	
	@Override
	public void setWeapon(Weapon weapon){
		this.weapon = weapon;
	}
	
	@Override
	public void say() {
		// TODO Auto-generated method stub
		System.out.println("람보가 말한다. 손들어! 움직이지마.");
	}

	@Override
	public void work() {
		// TODO Auto-generated method stub
		System.out.println("람보가 총을 쏜다.");
		weapon.play();
	}

}
