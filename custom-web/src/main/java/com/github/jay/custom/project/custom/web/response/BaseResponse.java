package com.github.jay.custom.project.custom.web.response;

/**
 * 基础返回数据
 *
 * @author xiaojie
 * @version 1.0
 * @date 2020/11/1 1:33 下午
 */
public class BaseResponse {

    private String responseCode;

    private String responseMessage;

    public BaseResponse() {}

    public BaseResponse(String responseCode, String responseMessage) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
