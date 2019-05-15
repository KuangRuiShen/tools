package com.krs.uitls.poi;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author krs
 * @time 2019年2月18日 上午11:26:19
 * @describe 自定义excel导出
 */

public class CustomExcel {
	
	public static void main(String[] args) {
		//模拟部分数据
				List<WorkSheetDetail> detail = new ArrayList<WorkSheetDetail>();
		 
				WorkSheetDetail d1 =new WorkSheetDetail("23",23f,43,34,243f,54f,"34");
				WorkSheetDetail d2 =new WorkSheetDetail("23",23f,43,34,243f,54f,"34");
				WorkSheetDetail d3 =new WorkSheetDetail("23",23f,43,34,243f,54f,"34");
				WorkSheetDetail d4 =new WorkSheetDetail("23",23f,43,34,243f,54f,"34");
				WorkSheetDetail d5 =new WorkSheetDetail("23",23f,43,34,243f,54f,"34");
				detail.add(d1);
				detail.add(d2);
				detail.add(d3);
				detail.add(d4);
				detail.add(d5);
		        try  
		        {  
		            FileOutputStream fout = new FileOutputStream("E:/students1.xls");
//		    		new ExportExcel().getValue(detail, fout);
		            fout.close();  
		        }  
		        catch (Exception e)  
		        {  
		            e.printStackTrace();  
		        }  
	}

}
