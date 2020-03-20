package com.minigod.protocol.account.vo.request.params;

import com.minigod.common.pojo.request.BaseRequestParams;
import lombok.Data;

import java.io.Serializable;

@Data
public class OpenProgressProxyReqParams extends BaseRequestParams implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer flag;
}
