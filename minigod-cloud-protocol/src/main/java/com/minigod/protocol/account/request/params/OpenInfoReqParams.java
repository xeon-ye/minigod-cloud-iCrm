package com.minigod.protocol.account.request.params;

import com.alibaba.fastjson.JSONObject;
import com.minigod.common.pojo.request.BaseRequestParams;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;

@Data
public class OpenInfoReqParams extends BaseRequestParams implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer openType;
    private Integer accessWay;
    private Integer fundAccountType;
    private Integer inviteId;
    private String channelId;
    private Integer activeId;
    private Integer language;
    private ArrayList<Integer> accountMarkets;
    private JSONObject formData;
}