package com.krs.uitls.excel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author krs
 * @time 2018年11月8日 下午9:07:26
 * @describe
 */

@Target({ElementType.FIELD,ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelField {
	 String value() default "";

	    String title();
	    
//	    int type() default 0;
//
//	    int align() default 0;
//
//	    int sort() default 0;

//	    String dictType() default "";
//
//	    Class<?> fieldType() default Class.class;

//	    int[] groups() default {};
}
