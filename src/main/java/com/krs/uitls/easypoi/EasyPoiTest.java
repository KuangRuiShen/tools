package com.krs.uitls.easypoi;

import java.io.File;

import com.krs.uitls.entity.PeopleEntity;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import cn.afterturn.easypoi.handler.inter.IExcelDataHandler;

/**
 * @author krs
 * @time 2018年12月1日 下午4:20:27
 * @describe
 */

public class EasyPoiTest {
	
	public static void main(String[] args) {
		
		File f = new File("D://people.xlsx");
		ImportParams param = new ImportParams();
		param.setTitleRows(1);
		param.setHeadRows(1);
		IExcelDataHandler<PeopleEntity>  handler = new PeopleHandler();
		handler.setNeedHandlerFields(new String[] { "姓名" });
		param.setDataHandler(handler);
		ExcelImportResult<PeopleEntity> datas = ExcelImportUtil.importExcelMore(f, PeopleEntity.class, param);
		
		
		System.out.println(datas);
	}

}
