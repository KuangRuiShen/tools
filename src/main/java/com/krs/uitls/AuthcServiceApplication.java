package com.krs.uitls;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author krs
 * @time 2019年5月22日 下午4:22:50
 * @describe
 */

@SpringBootApplication(scanBasePackages = {"com.ly.cloud" })
@EnableTransactionManagement
public class AuthcServiceApplication {

	private final static Logger logger = LoggerFactory.getLogger(AuthcServiceApplication.class);

    public static void main(String[] args) {
        if (logger.isDebugEnabled()) {
            logger.debug("启动基础数据服务......");
        }
        SpringApplication.run(AuthcServiceApplication.class, args);
        System.setProperty("tomcat.util.http.parser.HttpParser.requestTargetAllow","^");
    }
}
  