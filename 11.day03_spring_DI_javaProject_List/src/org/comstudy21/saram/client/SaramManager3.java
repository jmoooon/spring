package org.comstudy21.saram.client;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.comstudy21.saram.di.CollectionBean;
import org.comstudy21.saram.model.Saram;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SaramManager3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext2.xml");
		CollectionBean bean = (CollectionBean) factory.getBean("collectionBean");
		Set<String> aa = bean.getSaramSet();
		System.out.println(aa);
		
		
		Map<String, String> map = bean.getSaramMap();
		System.out.println(map);
		
		Set<String> keySet = map.keySet();
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()){
			String key = it.next();
			System.out.println(key + " >> " + map.get(key));
		}
		
		Properties list = bean.getSaramProp();
		System.out.println(list);
		
	}

}
