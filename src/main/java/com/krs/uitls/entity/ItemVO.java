package com.krs.uitls.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * @author krs
 * @date 创建时间2017年7月31日 下午5:32:49 
 * @describe 封装页面需要的实体
 */

public class ItemVO {
	
	private String key;
	
	private String value;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public ItemVO(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}
	public ItemVO() {
		super();
	}
	
	
	
	
}
