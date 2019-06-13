package com.ly.cloud.authc.resource.service;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;

import com.krs.uitls.AuthcServiceApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AuthcServiceApplication.class)
public class ResourceTestCase {
	
	private final static Log logger = LogFactory.getLog(ResourceTestCase.class);

//	@Autowired
//	private ResourcesService resourcesService;
	
	/** 
	 * Method Name:  insertResourcesByAnnotation
	 * Description:   
	 * 扫描控制器，增加URL到资源表
	 * @return void
	 * @throws ClassNotFoundException 
	 * @exception 	
	 * @author WenboLi
	 * @mail WenboLi@ly-sky.com
	 * @date: 2018年5月21日
	 */
	@Test
	public void insertResourcesByAnnotation() {
		
		List<ResourcesPo> resources = new ArrayList<ResourcesPo>();
		String patt = "\\{[\\w\\d-]+\\}";
		Pattern r = Pattern.compile(patt);
		
		String basePackage = "com.ly.cloud.authc.controller";
		String classpath = AuthcServiceApplication.class.getResource("/").getPath();
		String searchPath = classpath + basePackage.replace(".", File.separator);
		searchPath = searchPath.replace("test-classes", "classes");
		List<String> classPaths = new ArrayList<String>();
		classPaths = doPath(new File(searchPath));
		for(String classPath : classPaths) {
			try {
				classPath = classPath.replace(classpath.replace("/", "\\").replaceFirst("\\\\", ""), "")
						.replace("\\", ".").replace(".class", "");
				classpath = classPath.substring(classPath.indexOf(basePackage));
				Class<?> cls = Class.forName(classpath);
				RequestMapping controllerRequestMappingAnnotation = cls.getAnnotation(RequestMapping.class);
				String perfix = "";
				if(controllerRequestMappingAnnotation!=null) {
					perfix = controllerRequestMappingAnnotation.value()[0];
				}
				Method[] methods = cls.getMethods();
				for (int i = 0; i < methods.length; i++) {
					Method method = methods[i];
					RequestMapping requestMappingAnnotation = method.getAnnotation(RequestMapping.class);
					if(requestMappingAnnotation!=null) {
						String url = perfix+requestMappingAnnotation.value()[0];
						String requestMethod = requestMappingAnnotation.method()[0].name();
						ResourcesPo resource = new ResourcesPo();
						resource.setResourcesId("authc_"+UUID.randomUUID().toString());
						resource.setOrderNumber(1.0+"");
						resource.setStatus(1+"");
						resource.setAction(requestMethod.toLowerCase());
						
						String uri =  url;
						Matcher matcher = r.matcher(uri);
						while(matcher.find()) {
							uri = matcher.replaceAll("[\\\\w\\\\d-]+");
						}
						if(uri.endsWith("/")) {
							uri.substring(0, uri.length()-1);
						}
						resource.setUri("^"+uri);
						resources.add(resource);
						
//						System.out.println(cls.getName()+":"+method.getName()+"=============================="+requestMethod+":"+url+"============="+uri);
					}
				}
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}
		
		for(Iterator<ResourcesPo> it = resources.iterator(); it.hasNext();) {
			ResourcesPo rs = it.next();
//			System.out.println(rs.getAction()+"----------------- "+rs.getUri());
//			resourcesService.insert(rs);
		}
	}
	
	private List<String> doPath(File file) {
		List<String> classPaths = new ArrayList<String>();
        if (file.isDirectory()) {//文件夹
            //文件夹我们就递归
            File[] files = file.listFiles();
            for (File f1 : files) {
                if (f1.getName().endsWith(".class")) {
                	classPaths.add(f1.getPath());
                }
            }
        }
        
        return classPaths;
    }
}
  