package org.comstudy21.di.saram;

import javax.annotation.Resource;

import org.comstudy21.di.saram.weapon.Weapon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/*
 * @Component를 설정해 줌으로써 Rambo이라는 id로 빈이 생성된 것이다.
 */

@Component
public class Rambo implements Saram {
	/*
	 * @Autowired는 자동으로 setWeapon처럼 연결해 줌
	 * @Qualifier(value=)로 어떤 값을 넣을지 지정해 주는 것이다.
	 * @Resource(name=)은 @Autowired와 @Qualifier를 합친 것으로 java에서 제공하는 lib이다.
	 */
	
	@Autowired
	@Qualifier(value="gun2")
	/*
	@Resource(name="gun")
	*/
	private Weapon weapon = null;
	
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
