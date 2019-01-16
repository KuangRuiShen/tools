package com.krs.uitls.easypoi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Workbook;

import com.krs.uitls.entity.StudentExcelVO;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;

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
		exportSheetByTemplate();

	}

	public static Workbook exportSheetByTemplate() {
		// 查询数据,此处省略
		List<StudentExcelVO> list = new ArrayList<>();
//		ExcelName dto = new ExcelName();
//		dto.setName("dfsdfsf");
//		dto.setIndex(1);
//		list.add(dto);
//		list.add(dto);
//		list.add(dto);
		StudentExcelVO st = new StudentExcelVO();
		st.setIndex(1);
		st.setName("dsdfs");;
		list.add(st);

		// 获取导出excel指定模版，第二个参数true代表显示一个Excel中的所有 sheet
		TemplateExportParams params = new TemplateExportParams("D:/Template.xlsx", true);
		params.setTempParams("t");
		Map<String, Object> data = new HashMap<String, Object>();
//	        data.put("准考证号", 1);//导出一般都要日期
		data.put("list", list);// 导出list集合

		// 标题开始行
		params.setHeadingStartRow(0);
		// 标题行数
		params.setHeadingRows(3);
		
		Workbook book = ExcelExportUtil.exportExcel(params, data);
		FileOutputStream os = null;
		try {
			os = new FileOutputStream(new File("D:/aaaa.xlsx"));
//			book.write(os);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return book;
	}

}
