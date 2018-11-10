package com.krs.uitls.list;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * @author krs
 * @time 2018年11月2日 上午11:11:38
 * @describe 验证集合里面是否重复
 */

public class ValidateList<T> {

	private List<T> datas;

	private Class<T> clz;

	private ValidateList(List<T> datas, Class<T> clss) {
		super();
		this.datas = datas;
		this.clz = clss;
	}

	/**
	 * 获取结果
	 * 
	 * @param datas 数组
	 * @param clss  实体的class
	 * @return
	 */
	public static <T> Map<String, Boolean> getReslut(List<T> datas, Class<T> clss) {
		ValidateList<T> result = new ValidateList<T>(datas, clss);
		return result.validate();
	}

	private Map<String, Boolean> validate() {
		// 先获取该对象的所有属性
		Map<String, HashSet<Object>> map = new HashMap<>();
		Map<String, Boolean> result = new HashMap<>();
		Field[] fields = clz.getDeclaredFields();
		for (Field f : fields) {
			String name = f.getName();
			map.put(name, new HashSet<Object>());
			result.put(name, false);
		}

		try {
			// 添加每个数据
			if (datas != null && !datas.isEmpty()) {
				for (Object object : datas) {
					Class<? extends Object> userCla = object.getClass();
					/* 得到类中的所有属性集合 */
					Field[] fs = userCla.getDeclaredFields();
					for (int i = 0; i < fs.length; i++) {
						Field f = fs[i];
						f.setAccessible(true); // 设置些属性是可以访问的
						String key = f.getName();
						HashSet<Object> set = map.get(key);
						set.add(f.get(object));
						map.put(key, set);
					}
				}
				// 验证数据是否重复
				int size = datas.size();
				for (String name : map.keySet()) {
					HashSet<Object> set = map.get(name);
					result.put(name, set.size() != size);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

	public Class<T> getClz() {
		return clz;
	}

	public void setClz(Class<T> clz) {
		this.clz = clz;
	}

}
