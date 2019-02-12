package com.krs.uitls.test;

import mode.sigleton.SingletonInner;

/**
 * @author krs
 * @time 2018年12月12日 上午9:47:08
 * @describe
 */

public class Test {
	public static void main(String[] args) {
	
		SingletonInner instance = SingletonInner.getInstance();
		SingletonInner instance2 = SingletonInner.getInstance();
		System.out.println(instance2.toString());
		System.out.println(instance.equals(instance2));
		SingletonInner.getInstance().method();
		
	}

}
