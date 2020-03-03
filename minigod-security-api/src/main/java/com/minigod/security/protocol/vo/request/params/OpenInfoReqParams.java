package com.minigod.security.protocol.vo.request.params;

import com.alibaba.fastjson.JSONObject;
import com.minigod.common.pojo.request.BaseRequestParams;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class OpenInfoReqParams extends BaseRequestParams implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer openType;
    private JSONObject info;
}