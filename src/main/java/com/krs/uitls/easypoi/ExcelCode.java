package com.krs.uitls.easypoi;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author krs
 * @time 2018年12月1日 下午4:55:47
 * @describe 用于查询代码组
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelCode {

		 String code() default "";

		 String name() default "";
		    
	

}
