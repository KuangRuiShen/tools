package com.krs.uitls.poi;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;

/**
 * @author krs
 * @time 2019年2月18日 上午11:28:45
 * @describe 图标导出
 */

public class ExportExcelUtils {
	
	public static <T> HSSFWorkbook  export(String type,List<T> list) {
		try {
			int totalSize = 2;
			// 1.创建工作簿
			HSSFWorkbook workbook = new HSSFWorkbook();
			// 1.1创建合并单元格对象
			CellRangeAddress callRangeAddress = new CellRangeAddress(0, 0, 0, 14);// 起始行,结束行,起始列,结束列
			// 小计
			CellRangeAddress totalBegin = new CellRangeAddress(totalSize + 2, totalSize + 2, 0, 6);// 起始行,结束行,起始列,结束列
			CellRangeAddress totalEnd = new CellRangeAddress(totalSize + 2, totalSize + 2, 11, 14);
			// 2.创建工作表
			HSSFSheet sheet = workbook.createSheet("收入统计");
			sheet.autoSizeColumn(1, true);// 自适应
			// 2.1加载合并单元格对象
			sheet.addMergedRegion(callRangeAddress);
			sheet.addMergedRegion(totalBegin);// 开始
			sheet.addMergedRegion(totalEnd);// 结束

			// 设置默认列宽
			sheet.setDefaultColumnWidth(15);
			sheet.setDefaultRowHeightInPoints(20);
			sheet.setColumnWidth(0, 6 * 256);
			// 3.1创建头标题行;并且设置头标题
			HSSFRow headRow = sheet.createRow(0);
			// 设置高度
			headRow.setHeightInPoints(40);
			HSSFCell headCell = headRow.createCell(0);
			// 加载单元格样式
			HSSFCellStyle headStyle = createCellStyle(workbook, (short) 10, true);
			headCell.setCellStyle(headStyle);
			headCell.setCellValue("2018年学院培训收入统计");

			// 标题样式
			HSSFCellStyle colStyle = createCellStyle(workbook, (short) 9, true);
			// 3.2创建列标题;并且设置列标题
			HSSFRow titleRow = sheet.createRow(1);
			titleRow.setHeightInPoints(20);

			String[] titles = { "序号", "项目编号", "项目名称", "申请部门", "申请人", "申请日期", "收入", "支出", "结余", "利润率%", "类别", "是否已结项",
					"备注1", "备注2", "财务核查" };// ""为占位字符串
			
			for (int i = 0; i < titles.length; i++) {
				HSSFCell cell = titleRow.createCell(i);
				cell.setCellStyle(colStyle);
				cell.setCellValue(titles[i]);
			}
			// 数据样式
			HSSFCellStyle textStyle = createCellStyle(workbook, (short) 10, false);
			for (int i = 0; i < totalSize; i++) {
				Row row = sheet.createRow(i + 2);// 获取索引为i的行，以0开始
				row.setHeightInPoints(20);
				for (int j = 0; j < titles.length; j++) {
					Cell cell = row.createCell(j);
					cell.setCellStyle(textStyle);
					if (j == 0) {
						cell.setCellValue(i + 1);
					} else {
						cell.setCellValue(j + "ddd");
					}
				}
			}
			// 合计行
			HSSFCellStyle totalStyle = createCellStyle(workbook, (short) 9, true);	
			
			Row total = sheet.createRow(totalSize + 2);
			total.setHeightInPoints(25);
			total.createCell(0).setCellValue("合计");
			total.createCell(7).setCellValue("7");	
			total.createCell(8).setCellValue("8");
			total.createCell(9).setCellValue("9");
			total.createCell(10).setCellValue("10");
			//设置样式
			for (int i = 0 ,len = titles.length; i < len;i++) {
				 Cell cell = total.getCell(i);
				 if(cell == null) {
					 cell = total.createCell(i);
				 }
				 cell.setCellStyle(totalStyle);
			}
			
			return workbook;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param workbook
	 * @param fontsize
	 * @return 单元格样式
	 */
	private static HSSFCellStyle createCellStyle(HSSFWorkbook workbook, short fontsize, boolean flag) {
		// TODO Auto-generated method stub
		HSSFCellStyle style = workbook.createCellStyle();
		// 是否水平居中
		style.setAlignment(HorizontalAlignment.CENTER);// 水平居中
		style.setVerticalAlignment(VerticalAlignment.CENTER);// 垂直居中
		style.setBorderBottom(BorderStyle.THIN); // 下边框
		style.setBorderLeft(BorderStyle.THIN);// 左边框
		style.setBorderTop(BorderStyle.THIN);// 上边框
		style.setBorderRight(BorderStyle.THIN);// 右边框
		// 创建字体
		HSSFFont font = workbook.createFont();
		// 是否加粗字体
		if (flag) {
			font.setBold(true);
		}
		font.setFontName("宋体");
		font.setFontHeightInPoints(fontsize);
		// 加载字体
		style.setFont(font);
		return style;
	}

}
