package com.krs.uitls.entity;

import java.util.Date;

import com.krs.uitls.easypoi.ExcelCode;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author krs
 * @time 2018年12月1日 下午4:18:44
 * @describe
 */

@Getter
@Setter
public class PeopleEntity {
	
	@Excel(name="姓名")
	@ExcelCode(code="work_type")
	private String name;
	
	@Excel(name="年龄")
	private Integer age;
	
	@Excel(name="日期",format="YYYY-MM-DD")
	private Date time;

	public PeopleEntity(String name, Integer age, Date time) {
		super();
		this.name = name;
		this.age = age;
		this.time = time;
	}

	public PeopleEntity() {
		super();
	}

	@Override
	public String toString() {
		return "PeopleEntity [name=" + name + ", age=" + age + ", time=" + time + "]";
	}

	
}
