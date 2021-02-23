package com.github.jay.custom.project.custom.dal.enums;

/**
 * @author xiaojie
 * @version 1.0
 * @date 2020/10/29 4:23 下午
 */
public enum DataSourceEnum {

    /**
     * druid
     */
    DRUID("druid", "阿里druid数据源"),

    /**
     * hikaricp
     */
    HIKARICP("hikaricp", "开源hikaricp数据源");

    private final String code;

    private final String description;

    DataSourceEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
