package com.krs.uitls.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author krs
 * @time 2018年12月19日 上午11:22:38
 * @describe 考生导出excel的Vo
 */

@Getter
@Setter
public class StudentExcelVO {
	
	//序号
	@Excel(name="序号")
	private Integer index;
	private String num;
	private String name;
	private String idType;
	private String idCard;
	private String specialSign;
	private String birth;
	private String sex;
	private String education;
	private String workingYears;
	private String workUnit;
	private String lastQualificationLevel;
	private String copies;
	private String examType;
	private String appraiser;
	private String personnel;
	private String residence;
	private String registeredResidence;
	private String nation;
	private String political;
	private String marital;
	private String professional;//国家职业资格等级
	private String positionLevel;//专业技术职务级别
	private String country;
	private String address;
	private String signDate;
	private String title;
	private String phone;
	private String train;
	private String exemptTheory;//是否免考理论
	private String makeupTheory;//补考理论
	private String makeupOption;//补考实操
	private String theoryScore;//理论成绩
	private String optionScore;//实操成绩
	private String markupScore1;//补考成绩
	private String markupScore2;
	private String markupScore3;
	private String markupScore4;
	private String examScore1;//加考成绩
	private String examScore2;
	private String examScore3;
	private String examScore4;
	
	
	

}
