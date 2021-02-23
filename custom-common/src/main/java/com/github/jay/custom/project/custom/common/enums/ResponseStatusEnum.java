package com.github.jay.custom.project.custom.common.enums;

/**
 * 结果码映射
 * 
 * @author xiaojie
 * @version 1.0
 * @date 2020/11/1 1:40 下午
 */
public enum ResponseStatusEnum {

    /**
     * 成功
     */
    SUCCESS("0000", "成功"),

    /**
     * 失败
     */
    FAIL("9999", "失败");

    private final String code;

    private final String message;

    ResponseStatusEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
