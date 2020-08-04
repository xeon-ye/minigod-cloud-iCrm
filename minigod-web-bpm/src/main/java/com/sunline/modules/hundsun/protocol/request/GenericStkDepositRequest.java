package com.sunline.modules.hundsun.protocol.request;

/**
 * @description: 证券存入请求参数基本格式
 * @author: Larry Lai
 * @date: 2018/8/16 10:36
 * @version: v1.0
 */

public class GenericStkDepositRequest<T extends Object> {

    private String sid;

    private String sourceModule;

    private T params;

    public T getParams() {
        return params;
    }

    public void setParams(T params) {
        this.params = params;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSourceModule() {
        return sourceModule;
    }

    public void setSourceModule(String sourceModule) {
        this.sourceModule = sourceModule;
    }
}
