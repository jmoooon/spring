package org.comstudy21.di.saram;

import javax.annotation.Resource;

import org.comstudy21.di.saram.weapon.Weapon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/*
 * @Component를 설정해 줌으로써 LeeSoryong이라는 id로 빈이 생성된 것이다.
 */
@Component
public class LeeSoryong implements Saram {
	/*
	@Autowired
	@Qualifier(value="sword")
	*/
	@Resource(name="sword")
	private Weapon weapon = null;
	
	
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
