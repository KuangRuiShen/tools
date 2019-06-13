package com.ly.cloud.authc.resource.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//@SpringBootTest(classes = AuthcServiceApplication.class)
public class BatchInsertAuthorizationUtils {
	
private final static Log logger = LogFactory.getLog(ScanResourceUtils.class);
	
	private final static String serviceId = "ly-iacp-sv";
	
	private final static List<Map<String, String>> auths = new ArrayList<Map<String, String>>();
	
	private final static String[] opers = new String[]{
			"insert",
			"delete",
			"update",
			"query",
	};
	
	public void initData() {
		Map<String, String> auth1 = new HashMap<String, String>();
		auth1.put("id", "departmentTypeMgt");
		auth1.put("name", "部门类型管理");
		auths.add(auth1);
		
		Map<String, String> auth2 = new HashMap<String, String>();
		auth2.put("id", "userTypeMgt");
		auth2.put("name", "用户类型管理");
		auths.add(auth2);
		
		Map<String, String> auth3 = new HashMap<String, String>();
		auth3.put("id", "organizationMgt");
		auth3.put("name", "机构管理");
		auths.add(auth3);
		
		Map<String, String> auth4 = new HashMap<String, String>();
		auth4.put("id", "departmentMgt");
		auth4.put("name", "部门管理");
		auths.add(auth4);
		
		Map<String, String> auth5 = new HashMap<String, String>();
		auth5.put("id", "userMgt");
		auth5.put("name", "用户管理");
		auths.add(auth5);
		
		Map<String, String> auth6 = new HashMap<String, String>();
		auth6.put("id", "roleMgt");
		auth6.put("name", "角色管理");
		auths.add(auth6);
		
		Map<String, String> auth7 = new HashMap<String, String>();
		auth7.put("id", "postMgt");
		auth7.put("name", "岗位管理");
		auths.add(auth7);
		
		Map<String, String> auth8 = new HashMap<String, String>();
		auth8.put("id", "userGroupMgt");
		auth8.put("name", "用户组管理");
		auths.add(auth8);
		
		Map<String, String> auth9 = new HashMap<String, String>();
		auth9.put("id", "serviceMgt");
		auth9.put("name", "服务管理");
		auths.add(auth9);
		
		Map<String, String> auth10 = new HashMap<String, String>();
		auth10.put("id", "appMgt");
		auth10.put("name", "应用管理");
		auths.add(auth10);
		
		Map<String, String> auth11 = new HashMap<String, String>();
		auth11.put("id", "authorizationMgt");
		auth11.put("name", "权限管理");
		auths.add(auth11);
		
		Map<String, String> auth12 = new HashMap<String, String>();
		auth12.put("id", "resourceMgt");
		auth12.put("name", "资源管理");
		auths.add(auth12);
		
//		Map<String, String> auth13 = new HashMap<String, String>();
//		auth13.put("id", "personSetting");
//		auth5.put("name", "个人设置");
	}
	
	public String getOperName(String operId) {
		if("insert".equals(operId)) {
			return "新增";
		} else if("delete".equals(operId)) {
			return "删除";
		} else if("update".equals(operId)) {
			return "修改";
		} else if("query".equals(operId)) {
			return "查询";
		}
		return operId;	
	}
	
//	@Autowired
//	private AuthorityService authorityService;
//	
//	@Test
//	public void batchInsertAuthorization() {
//		
//		initData();
//		
//		List<AuthorityPo> batchInsertList = new ArrayList<AuthorityPo>();
//		
//		for (int i = 0; i < auths.size(); i++) {
//			Map<String, String> auth = auths.get(i);
//			AuthorityPo po = new AuthorityPo();
//			po.setAuthorityId(serviceId + "_" + auth.get("id")+ "_*");
//			po.setAuthorityName(auth.get("name"));
//			po.setOrderNumber((double) i);
//			po.setParentId("-1");
//			po.setServiceId(serviceId);
//			po.setType("module");
//			for (int j = 0; j < opers.length; j++) {
//				AuthorityPo oper = new AuthorityPo();
//				oper.setAuthorityId(po.getAuthorityId().substring(0, po.getAuthorityId().indexOf("*"))+opers[j]);
//				oper.setAuthorityName(getOperName(opers[j]));
//				oper.setOrderNumber((double) j);
//				oper.setParentId(po.getAuthorityId());
//				oper.setServiceId(serviceId);
//				oper.setType("function");
//				batchInsertList.add(oper);
//			}
//			batchInsertList.add(po);
//		}
//		authorityService.insertBatch(batchInsertList);
//		
//	}

}
