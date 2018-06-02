package org.comstudy21.saram.client;

import java.util.ArrayList;
import java.util.Collections;

import org.comstudy21.saram.model.Saram;

public class SaramManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Saram saram = new Saram("hong", "gildong", 32);
		System.out.println(saram.toString());
		System.out.println(saram.getId());
		System.out.println(saram.getAge());
		System.out.println(saram.getName());
		
		Saram[] saramArr = {
				new Saram("kim","sin", 2),
				new Saram("jo","min", 3),
				new Saram("Nam","sang", 4),
				new Saram("EE","oul", 5),
				new Saram("qqq","aere", 6)
		};
		
		ArrayList<Saram> list = new ArrayList<>();
		
		Collections.addAll(list, saramArr);
		//list.toString();
		
		for(Saram saramLT: list){
			System.out.println(saramLT.toString());
		}
		
		Saram [] arr2 = new Saram[list.size()];
		list.toArray(arr2);
		for(Saram saram3 : arr2){
			System.out.println(saram3.toString());
		}
		
	}

}
