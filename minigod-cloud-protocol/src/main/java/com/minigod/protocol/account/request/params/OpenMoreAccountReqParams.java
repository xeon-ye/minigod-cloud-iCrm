package com.minigod.protocol.account.request.params;

import com.alibaba.fastjson.JSONObject;
import com.minigod.common.pojo.request.BaseRequestParams;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;

@Data
public class OpenMoreAccountReqParams extends BaseRequestParams implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer type;
    private JSONObject formData;
}