package org.comstudy21.saram.client;

import java.util.List;
import java.util.ArrayList;

import org.comstudy21.saram.di.CollectionBean;
import org.comstudy21.saram.model.Saram;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SaramManager2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		CollectionBean bean = (CollectionBean) factory.getBean("collectionBean");
		List<Saram> aa = bean.getSaramList();
		System.out.println(aa.toString());

		for(Saram ee : aa){
			System.out.println(ee.toString());
		}
	}

}
