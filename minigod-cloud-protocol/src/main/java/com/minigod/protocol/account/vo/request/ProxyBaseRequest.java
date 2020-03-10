package com.minigod.protocol.account.vo.request;

import com.minigod.common.pojo.request.BaseRequestParams;
import com.minigod.common.pojo.request.BaseRequestWrap;
import lombok.Data;

@Data
public class ProxyBaseRequest<T extends BaseRequestParams> extends BaseRequestWrap {
    private String authCode; // auth标识

    private T params;
}
