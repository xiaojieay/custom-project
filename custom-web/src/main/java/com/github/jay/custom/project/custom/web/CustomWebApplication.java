package com.github.jay.custom.project.custom.web;

import com.alibaba.nacos.spring.context.annotation.discovery.EnableNacosDiscovery;
import com.github.jay.custom.project.custom.common.constant.SystemConstant;
import com.github.jay.custom.project.custom.web.util.SystemConfigCenterUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * 启动类
 * 
 * @author xiaojie
 * @date 2020/10/29 14/36
 */
@SpringBootApplication(scanBasePackages = "com.github.jay.custom.project",
    exclude = {DataSourceAutoConfiguration.class})
@EnableNacosDiscovery
public class CustomWebApplication {

    private static final Logger logger = LoggerFactory.getLogger(CustomWebApplication.class);

    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(new File(SystemConstant.CONFIG_PATH)));
            System.getProperties().putAll(properties);
            SystemConfigCenterUtils.initConfig();
        } catch (Exception e) {
            logger.error("初始化系统级配置失败");
            e.printStackTrace();
        }
        SpringApplication.run(CustomWebApplication.class, args);
    }
}
