package com.ly.cloud.authc.resource.service;

import java.io.File;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMapping;

import com.krs.uitls.AuthcServiceApplication;


public class ScanResourceUtils {

    private final static Log logger = LogFactory.getLog(ScanResourceUtils.class);

    private final static String serviceId = "ly-iacp-svc";

    @Test
    public void scanResources() {
        List<ResourcesPo> resources = new ArrayList<>();
        String patt = "\\{[\\w\\d-]+\\}";
        Pattern r = Pattern.compile(patt);

        String basePackage = "com.ly.cloud.authc.controller";
        String classpath = AuthcServiceApplication.class.getResource("/").getPath();
        String searchPath = classpath + basePackage.replace(".", File.separator);
        searchPath = searchPath.replace("test-classes", "classes");
        List<String> classPaths;
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
                        resource.setResourcesId(serviceId + "_" + cls.getSimpleName() + "_" + method.getName());
                        resource.setOrderNumber("1");
                        resource.setStatus("1");
                        resource.setAction(requestMethod.toLowerCase());
                        resource.setServiceId(serviceId);

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
                    }
                }
            } catch (Exception e) {
                logger.error(classPath);
                logger.error(e.getMessage(), e);
            }
        }

        for(Iterator<ResourcesPo> it = resources.iterator(); it.hasNext();) {
            ResourcesPo rs = it.next();
            String sql = MessageFormat.format("insert into ly_xtgl_zy (zybh, uri, action, zt, pxh, fwbh) values ({0}, {1}, {2}, {3}, {4}, {5});", "'"+rs.getResourcesId()+"'", "'"+rs.getUri()+"'", "'"+rs.getAction()+"'", "'"+rs.getStatus()+"'", "'"+rs.getOrderNumber()+"'", "'"+rs.getServiceId()+"'");
            System.out.println(sql);
        }
    }

    private List<String> doPath(File file) {
        List<String> classPaths = new ArrayList<>();
        if (file.isDirectory()) {//文件夹
            //文件夹递归
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
