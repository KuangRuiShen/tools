package com.krs.uitls.easypoi;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.krs.uitls.entity.ExcelName;
import com.krs.uitls.entity.PeopleEntity;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;

/**
 * @author krs
 * @time 2018年12月1日 下午5:14:42
 * @describe
 */

public class ToolsText {
	public static void main(String[] args) {
//		ExcelDealTools tool = 	ExcelDealTools.init(PeopleEntity.class);
//		List<PeopleEntity> list = new ArrayList<>();
//		PeopleEntity p = new PeopleEntity();
//		p.setName("1");
//		list.add(p);
//		Map<String,String> resut = new HashMap<>();
//		resut.put("1", "张三");	
//		tool.setFileData("name", resut);
//		tool.conversionData(list);
//		System.out.println(list);

//		File f = new File("D://name.xlsx");
//		ImportParams param = new ImportParams();
//		param.setTitleRows(0);
//		param.setHeadRows(1);
//		List<ExcelName> datas = ExcelImportUtil.importExcel(f, ExcelName.class, param);
//		System.out.println(datas);
//		for (ExcelName name : datas) {
//			String n = name.getName();
//			System.out.println("n:" + n);
//			String[] aa = n.split(".");
//			System.out.println("key:" + aa[0] + "value :" + aa[1]);
//		}
//		
		String name ="4401.广东省广州市";
		String [] a = name.split("."); 
		System.out.println(a.toString());

	}
}
