package com.krs.uitls.easypoi;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author krs
 * @time 2018年12月1日 下午4:58:43
 * @describe 通过字段注解处理数据
 */

public class ExcelDealTools {

	Class<?> pojoClass;

	// 用来存储查询的数据
	private Map<String, Map<String, String>> baseData = new HashMap<>(); // code 对应的数据

//	private Map<String,String> fieldName = new HashMap<String,String>();//字段对应的code

	private ExcelDealTools(Class<?> pojoClass) {
		super();
		this.pojoClass = pojoClass;
	}

	public static ExcelDealTools init(Class<?> pojoClass) {
		ExcelDealTools et = new ExcelDealTools(pojoClass);
		et.queryCode();
		return et;
	}

	private void queryCode() {
		Field[] fs = this.pojoClass.getDeclaredFields();
		for (Field f : fs) {
			// 获取字段上加的@Excel注解
			ExcelCode annotation = f.getAnnotation(ExcelCode.class);
			if (annotation != null) {
				String code = annotation.code();// 做条件查询
				this.baseData.put(f.getName(), queryByCode(code));
			}
		}
	}

	private Map<String, String> queryByCode(String code) {
		return new HashMap<String, String>();
	}

	/**
	 * 
	 * @param fileName 字段名称
	 * @param data 所有的数据
	 * @return
	 */
	public Map<String, String> setFileData(String fileName, Map<String, String> data) {
		return this.baseData.put(fileName, data);
	}

	/*
	 * 转换数据
	 */
	public <T> List<T> conversionData(List<T> list) {	
		// 查询数据
		try {
			for (T t : list) {
				for (String fileName : baseData.keySet()) {
					Field f = t.getClass().getDeclaredField(fileName);
					f.setAccessible(true);
					System.out.println("value:" + f.get(t));	
					Object key = f.get(t);
					Map<String,String> maps = baseData.get(fileName);//获取maps
					f.set(t, maps.get(key));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
