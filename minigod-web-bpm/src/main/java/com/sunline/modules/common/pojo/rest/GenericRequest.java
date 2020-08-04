package com.sunline.modules.common.pojo.rest;

/**
 * @description: 定义通用请求参数基本格式
 * @author: Larry Lai
 * @date: 2018/8/16 10:36
 * @version: v1.0
 */

public class GenericRequest<T> {

    private T params;

    public T getParams() {
        return params;
    }

    public void setParams(T params) {
        this.params = params;
    }
}
