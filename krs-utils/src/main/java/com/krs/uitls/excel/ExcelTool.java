package com.krs.uitls.excel;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.krs.uitls.entity.Student;

/**
 * @author krs
 * @param <T>
 * @time 2018年11月8日 下午8:20:18
 * @describe excel 的工具类
 */

public class ExcelTool {
	
	
	public static void main(String[] args) {
		List<Student>  list= ExcelTool.ExportExcel(Student.class);	
		System.out.println(list.toString());
	}
	
	

	
	private  static <T> List<T> ExportExcel(Class<T> cls){
		try {
			List<T> datas= new ArrayList<T>();
			 T obj = cls.newInstance();
			 Field[] fs = cls.getDeclaredFields();
		        for (Field f : fs){
		            //获取字段上加的@Excel注解
		            ExcelField ef = f.getAnnotation(ExcelField.class);
		            if(ef !=null) {
		            	 System.out.println(ef.title());
		                 f.setAccessible(true); // 设置些属性是可以访问的
		                 f.set(obj, "张三");
		            }           
		        }
//		        System.out.println(obj.toString());
		        datas.add(obj);    
		        return datas;		        
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
       
	}
        // Get annotation method
//        Method[] ms = cls.getDeclaredMethods();
//        for (Method m : ms){
//            //获取方法上的注解
//            ExcelField ef = m.getAnnotation(ExcelField.class);
//            if (ef != null && (ef.type()==0 || ef.type()==type)){
//                  //操作同对字段的操作
//                }else{
//                    annotationList.add(new Object[]{ef, m});
//                }
//            }
//        }
//        // 对字段进行排序
//        Collections.sort(annotationList, new Comparator<Object[]>() {
//             //排序规则
//        });
//        // Initialize
//        List<String> headerList = Lists.newArrayList();
//        for (Object[] os : annotationList){
//            //获取注解title属性值
//            String t = ((ExcelField)os[0]).title();
//            //将字段名称保存在一个list中，交给初始化方法使用
//            headerList.add(t);
//        }
        //初始化操作，创建Excel，设置文件名称，表格标题，表头内容及单元格的格式等信息
//        initialize(title, headerList);
//    }
}
