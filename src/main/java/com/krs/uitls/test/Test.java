package com.krs.uitls.test;

/**
 * @author krs
 * @time 2018年12月12日 上午9:47:08
 * @describe
 */

public class Test {
	public static void main(String[] args) {
		System.out.println(test("abc**gfe**xyz"));	
		test(1);
	}

	private static void test(Integer i) {
		try {
			if (i == 1) {
				throw new Exception();
			}
			System.out.println("try:" + i);
		} catch (Exception e) {
			test(i + 1);
		} finally {
			System.out.println("finally:" + i);
		}
	}

	private static String test(String name) {
		String newName = "";
		for(char n :name.toCharArray()) {
			newName = "*".equals(n+"") ? "*" + newName :newName + n;		
		}
		return newName;
	}

}
