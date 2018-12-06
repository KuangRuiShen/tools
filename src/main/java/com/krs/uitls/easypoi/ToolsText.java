package com.krs.uitls.easypoi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.krs.uitls.entity.PeopleEntity;

/**
 * @author krs
 * @time 2018年12月1日 下午5:14:42
 * @describe
 */


public class ToolsText {
	public static void main(String[] args) {
		ExcelDealTools tool = 	ExcelDealTools.init(PeopleEntity.class);
		List<PeopleEntity> list = new ArrayList<>();
		PeopleEntity p = new PeopleEntity();
		p.setName("1");
		list.add(p);
		Map<String,String> resut = new HashMap<>();
		resut.put("1", "张三");	
		tool.setFileData("name", resut);
		tool.conversionData(list);
		System.out.println(list);

	}
}
