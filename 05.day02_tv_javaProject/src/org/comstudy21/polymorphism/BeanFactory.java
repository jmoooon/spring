package org.comstudy21.polymorphism;

import java.util.HashMap;
import java.util.Map;

public class BeanFactory {
	
	private static BeanFactory instance;
	
	Map<String, Object> mapping = new HashMap<String, Object>();
	
	//외부에서 생성 금지
	private BeanFactory(){
		//TVUser에서 사용할 TV 인스턴스 준비
		mapping.put("samsung", new SamsungTv());
		mapping.put("lg", new LgTv());
	}
	
	public static BeanFactory getInstance(){
		if(instance == null){
			instance = new BeanFactory();
		}
		
		return instance;
	}
	
	 
	
	public Object getBean(String key){
		return mapping.get(key);
	}
}
