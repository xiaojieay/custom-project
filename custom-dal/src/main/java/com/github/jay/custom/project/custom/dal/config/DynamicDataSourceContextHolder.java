package com.github.jay.custom.project.custom.dal.config;

import com.github.jay.custom.project.custom.dal.enums.DataSourceEnum;

/**
 * 动态数据库容器
 * 
 * @author xiaojie
 * @version 1.0
 * @date 2020/10/29 4:42 下午
 */
public class DynamicDataSourceContextHolder {

    /**
     * 动态数据源名称上下文
     */
    private static final ThreadLocal<String> DATASOURCE_CONTEXT_KEY_HOLDER = new ThreadLocal<>();

    /**
     * 设置数据源
     *
     * @param key
     *            数据源标示
     */
    public static void setContextKey(String key) {
        DATASOURCE_CONTEXT_KEY_HOLDER.set(key);
    }

    /**
     * 获取数据源名称
     */
    public static String getContextKey() {
        String key = DATASOURCE_CONTEXT_KEY_HOLDER.get();
        return key == null ? DataSourceEnum.DRUID.getCode() : key;
    }

    /**
     * 删除当前数据源名称
     */
    public static void removeContextKey() {
        DATASOURCE_CONTEXT_KEY_HOLDER.remove();
    }

}
