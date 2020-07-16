package com.sunline.modules.hundsun.protocol.response;

/**
 * @description: 证券存入回参协议
 * @author: Larry Lai
 * @date: 2018/12/19 15:46
 * @version: v1.0
 */

public class StockDepositResponse {
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
    private Object data;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
