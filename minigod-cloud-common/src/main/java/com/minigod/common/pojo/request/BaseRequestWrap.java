package com.minigod.common.pojo.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseRequestWrap implements Serializable {
    private static final long serialVersionUID = -8082926869795522051L;

    // 前端请求接口的版本号
    private String version;

    // 签名
    private String sign;

    // 并发标识，相对于token唯一
    // APP端生成规则：app当前时间的timestamp+6位自增长数字，例如：1425908755444000001，改时间可能重复但风险不大
    private String id;

    private String src;

    //客户端请求ip
    private String ip;
}
