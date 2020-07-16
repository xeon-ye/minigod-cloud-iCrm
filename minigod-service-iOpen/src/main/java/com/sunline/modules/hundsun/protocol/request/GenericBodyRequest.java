package com.sunline.modules.hundsun.protocol.request;

/**
 * @description: Body请求体
 * @author: Larry Lai
 * @date: 2018/12/19 13:33
 * @version: v1.0
 */

public class GenericBodyRequest<T extends Object> {
    private T body;

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
