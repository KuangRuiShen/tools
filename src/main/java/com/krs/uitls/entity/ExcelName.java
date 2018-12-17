package com.krs.uitls.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author krs
 * @time 2018年12月14日 上午11:46:20
 * @describe
 */
@Getter
@Setter
public class ExcelName {
	
	@Excel(name="姓名")
	private String name;

}
