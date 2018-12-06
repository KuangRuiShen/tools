package com.krs.uitls.easypoi;

import com.krs.uitls.entity.PeopleEntity;

import cn.afterturn.easypoi.handler.impl.ExcelDataHandlerDefaultImpl;

/**
 * @author krs
 * @time 2018年12月1日 下午4:49:46
 * @describe
 */

public class PeopleHandler extends ExcelDataHandlerDefaultImpl<PeopleEntity> {
	

	@Override
	public Object importHandler(PeopleEntity obj, String name, Object value) {
//		log.info(name+":"+value);
		System.out.println("name=" + name + "value=" + value);
		return super.importHandler(obj, name, value);
	}

}
