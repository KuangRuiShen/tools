package com.krs.uitls.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author krs
 * @time 2019年5月23日 上午10:31:29
 * @describe
 */

public class IntText {
	public static void main(String[] args) {
//		int [] x = new  int [25];
//		System.out.println(x[24]);
		
		List<String> list = new ArrayList<>();
		 list.add("aaa");
		 list.add("2");
		 list.add("3");
		 list.remove("2");
		System.out.println(list.toString());
//		Iterator<String> id = list.iterator();
//		while(id.hasNext()) {
//			String obj = id.next();
//			if("2".equals(obj)) {
//			   id.remove();
//			}
//		}
		System.out.println(list.toString());
			
		
	}
}
