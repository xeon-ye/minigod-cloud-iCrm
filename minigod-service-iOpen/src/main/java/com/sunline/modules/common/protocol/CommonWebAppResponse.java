package com.sunline.modules.common.protocol;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.sunline.modules.common.common.FastJsonFilter;

/**
 * @author PENGFENG
 * @version v1.0
 * @description 返回公共值对象
 * @date 2017-07-24
 */

public class CommonWebAppResponse {
    public CommonWebAppResponse() {
    }

    public CommonWebAppResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    //返回的状态
    @JSONField(name = "code")
    private Integer code;

    //返回的消息
    @JSONField(name = "message")
    private String message;

    //返回的结果
    @JSONField(name = "result")
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

    public static CommonWebAppResponse getDefaultSuccessResponse() {
        return new CommonWebAppResponse(0, "操作成功");
    }

    public static CommonWebAppResponse getDefaultFailResponse() {
        return new CommonWebAppResponse(-1, "操作失败");
    }

    public static CommonWebAppResponse getDefaultParamResponse() { return new CommonWebAppResponse(-2 , "参数错误"); }

    public static CommonWebAppResponse getDefaultLoginFailResponse() { return new CommonWebAppResponse(-3,"用户未登录"); }


    @Override
    public String toString() {
        return JSON.toJSONString(this, FastJsonFilter.nullAsEmptyFilter, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty);
    }


    public static void main(String[] args) {
        System.out.println(CommonWebAppResponse.getDefaultSuccessResponse().toString());
    }

}

