package com.github.jay.custom.project.custom.facade.response;

import java.io.Serializable;

/**
 * @author xiaojie
 * @version 1.0
 * @date 2020/11/3 10:45 下午
 */
public class BaseResponse implements Serializable {

    private static final long serialVersionUID = -43418167977275656L;

    private String code;

    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
