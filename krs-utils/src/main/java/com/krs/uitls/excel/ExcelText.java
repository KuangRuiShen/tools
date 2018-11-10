package com.krs.uitls.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author krs
 * @time 2018年11月8日 下午8:20:43
 * @describe
 */

public class ExcelText {

	public static void main(String[] args) {

//		ExcelTool.getUtils(Student.class);

	}

	public static void getText(Integer headerIndex) {

		// 最小头为1
		if (headerIndex < 1) {
			headerIndex = 1;
		}
		// 获取文件路径
		File f = new File("d://1.xlsx");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(f);
			Workbook workbook = WorkbookFactory.create(fis);
//			workbook.getNumberOfSheets();
			Sheet sheet = workbook.getSheetAt(0);
			int rowCount = sheet.getPhysicalNumberOfRows();// 获取总行数

//			List<Map<String, Object>> datas = new ArrayList<Map<String, Object>>();
			List<String> heard = new ArrayList<String>();
			headerIndex = headerIndex - 1;// 行数减一(从O开始的)
			for (int i = headerIndex; i < rowCount; i++) {
				Row row = sheet.getRow(i);
				if (row == null) {
					continue;
				}
				// 如果是当前行是头
				if (i == headerIndex) {
					// 获取每一行的标题树
					int count = row.getPhysicalNumberOfCells();
					for (int head = 0; head < count; head++) {
						Cell c = row.getCell(head);
						heard.add(c.getStringCellValue());
					}
					System.out.println("头：" + heard.toString());
				} else {
					if (!heard.isEmpty()) {
						for (int h = 0; h < heard.size(); h++) {
							Cell c = row.getCell(h);
							
							heard.add(c.getStringCellValue());
							
						}
					} else {
						break;
					}
				}

//				Cell exportIdCell = row.getCell(0, Row.RETURN_BLANK_AS_NULL);// 获取每行的第一个单元格，空为null
//				if (exportIdCell == null) {
//					continue;
//				}

//				String certificationNumber = null;

//				if (row.getCell(41) != null) {
//					row.getCell(41).setCellType(Cell.CELL_TYPE_STRING);
//					certificationNumber = row.getCell(41).getStringCellValue();
//				}
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
