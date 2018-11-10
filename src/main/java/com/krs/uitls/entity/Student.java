package com.krs.uitls.entity;

import com.krs.uitls.excel.ExcelField;

public class Student {
	
	@ExcelField(title="名称")
	private String name;
	
	private Integer age;
	
	private String className;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Student(String name, Integer age, String className) {
		super();
		this.name = name;
		this.age = age;
		this.className = className;
	}

	public Student() {
		super();
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", className=" + className + "]";
	}



	
	
	
}
