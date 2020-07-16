package com.sunline.modules.common.vo;

/**
 * @description: 通用返回结果对象
 * @author: Larry Lai
 * @date: 2018/5/15 15:46
 * @version: v1.0
 */

public class ResponseVO {
    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误信息
     */
    private String message;

    /**
     * 返回对象
     */
    private Object result;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
