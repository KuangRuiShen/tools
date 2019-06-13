package utils;

import java.io.File;
import java.io.FileOutputStream;
import java.text.MessageFormat;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.krs.uitls.AuthcServiceApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AuthcServiceApplication.class)
public class GetControllerUrlUtils {

	@Autowired
	@Qualifier("requestMappingHandlerMapping")
	private RequestMappingHandlerMapping handlerMapping;

	@GetMapping
	public void getAllUrl() {
		try {
			String basePackage = "com.ly.mc.controller";
			String path = "D:/url.sql";
			
			// 获取url与类和方法的对应信息
			Map<RequestMappingInfo, HandlerMethod> map = handlerMapping.getHandlerMethods();

			// 输出文件

			FileOutputStream output = new FileOutputStream(new File(path));

//			List<Resource> list = new ArrayList<Resource>();
			for (Entry<RequestMappingInfo, HandlerMethod> m : map.entrySet()) {
//				Resource rs = new Resource();
				RequestMappingInfo info = m.getKey();
				HandlerMethod method = m.getValue();
				String beanname = method.getBeanType().getName();
				 String purl = null;String id;String notes;String name;String optionMethod = null;
				if (beanname != null && beanname.startsWith(basePackage)) {

					PatternsRequestCondition p = info.getPatternsCondition();
					for (String url : p.getPatterns()) {
						 purl = url.replaceAll("\\{[^}]*\\}", "*");
						
					}
					 id = method.getBeanType().getSimpleName() + "_" + method.getMethod().getName();
					 name =method.getMethod().getName();
					RequestMethodsRequestCondition methodsCondition = info.getMethodsCondition();
					for (RequestMethod requestMethod : methodsCondition.getMethods()) {
//              	 map1.put("type", requestMethod.toString());
						optionMethod = requestMethod.toString();
					}
					
					String sql = MessageFormat.format(
							"INSERT INTO \"LY_XTGL_ZYB\"(\"ZYBH\", \"ZYMC\", \"ZYLJ\", \"ZYMS\", \"QQFS\",\"ISOPTION\") "
							+ " VALUES ({0}, {1}, {2}, {3}, {4}, {5}); \n",
							"'" + id + "'", 
							"'" + name + "'",
							"'" + purl + "'",
							"", 
							"'" + optionMethod + "'", "'1'");
					output.write(sql.getBytes());
				}
//				output.write("\n".getBytes());
			}
			output.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
