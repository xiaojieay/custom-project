package com.github.jay.custom.project.custom.web.util;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import com.github.jay.custom.project.custom.common.constant.BusinessConstant;
import com.github.jay.custom.project.custom.common.constant.SystemConstant;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * 注册中心工具类(保证一个JVM中只存在一个configService)
 *
 * @author xiaojie
 * @version 1.0
 * @date 2021/1/26 3:30 下午
 */
public class SystemConfigCenterUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(SystemConfigCenterUtils.class);

    private static volatile ConfigService configService;

    public static final Map<String, Properties> LOCAL_PROPERTIES = new HashMap<>();

    private SystemConfigCenterUtils() {}

    /**
     * 外部配置中心服务类
     * 
     * @throws Exception
     *             配置中心连接异常
     */
    private static void getConfigService() throws Exception {
        String serverAddr = Optional.ofNullable(System.getProperties().getProperty(SystemConstant.NACOS_SERVER_ADDR))
            .filter(StringUtils::isNotEmpty).orElseThrow(() -> new Exception("配置中心连接地址不能为空"));
        String namespace = Optional.ofNullable(System.getProperties().getProperty(SystemConstant.NACOS_NAMESPACE))
            .filter(StringUtils::isNotEmpty).orElseThrow(() -> new Exception("命名空间不能为空"));
        try {
            if (configService == null) {
                synchronized (SystemConfigCenterUtils.class) {
                    if (configService == null) {
                        Properties properties = new Properties();
                        properties.setProperty(PropertyKeyConst.SERVER_ADDR, serverAddr);
                        properties.setProperty(PropertyKeyConst.NAMESPACE, namespace);
                        configService = NacosFactory.createConfigService(properties);
                    }
                }
            }
        } catch (NacosException e) {
            LOGGER.error("配置中心连接异常");
            throw new Exception("配置中心连接异常");
        }
    }

    /**
     * 初始化配置
     * 
     * @throws Exception
     *             获取配置异常
     */
    public static void initConfig() throws Exception {
        getConfigService();
        String customGroup = Optional.ofNullable(System.getProperties().getProperty(SystemConstant.NACOS_GROUP))
            .filter(StringUtils::isNotEmpty).orElse(SystemConstant.DEFAULT_GROUP);
        long timeout = Optional.of(Long.parseLong(System.getProperties().getProperty(SystemConstant.NACOS_TIMEOUT)))
            .filter(min -> min >= 3000).filter(max -> max <= 6000)
            .orElseThrow(() -> new Exception("timeout必须在3000到6000之间"));
        Optional.ofNullable(System.getProperties().getProperty(SystemConstant.NACOS_SYSTEM_DATAIDS))
            .filter(StringUtils::isNotEmpty).ifPresent(
                systemIds -> Arrays.stream(systemIds.split(BusinessConstant.DATA_ID_SPLIT_STR)).forEach(dataStr -> {
                    try {
                        Properties properties = new Properties();
                        String content = configService.getConfig(dataStr, customGroup, timeout);
                        Optional.ofNullable(content).ifPresent(properStr -> buildSystemConfig(properStr, properties));
                    } catch (NacosException e) {
                        LOGGER.error("获取系统配置dataID:{},group:{}的配置异常！", dataStr, customGroup);
                    }
                }));
        Optional.ofNullable(System.getProperties().getProperty(SystemConstant.NACOS_BUSINESS_DATAIDS))
            .filter(StringUtils::isNotEmpty).ifPresent(
                businessIds -> Arrays.stream(businessIds.split(BusinessConstant.DATA_ID_SPLIT_STR)).forEach(dataStr -> {
                    try {
                        Properties properties = new Properties();
                        String content = configService.getConfig(dataStr, customGroup, timeout);
                        Optional.ofNullable(content)
                            .ifPresent(properStr -> buildBusinessConfig(properStr, dataStr, properties));
                    } catch (NacosException e) {
                        LOGGER.error("获取业务配置dataID:{},group:{}的配置异常！", dataStr, customGroup);
                    }
                }));
    }

    private static void buildSystemConfig(String propertiesStr, Properties properties) {
        String[] propertiesStrArray = propertiesStr.split(BusinessConstant.PRO_STR_SPLIT_STR);
        Arrays.stream(propertiesStrArray).forEach(proStr -> {
            int index = proStr.indexOf(BusinessConstant.KEY_VALUE_SPLIT_STR);
            properties.setProperty(proStr.substring(0, index), proStr.substring(index + 1));
        });
        System.getProperties().putAll(properties);
    }

    private static void buildBusinessConfig(String propertiesStr, String dataId, Properties properties) {
        String[] propertiesStrArray = propertiesStr.split(BusinessConstant.PRO_STR_SPLIT_STR);
        Arrays.stream(propertiesStrArray).forEach(proStr -> {
            int index = proStr.indexOf(BusinessConstant.KEY_VALUE_SPLIT_STR);
            properties.setProperty(proStr.substring(0, index), proStr.substring(index + 1));
        });
        LOCAL_PROPERTIES.put(dataId, properties);
    }
}
