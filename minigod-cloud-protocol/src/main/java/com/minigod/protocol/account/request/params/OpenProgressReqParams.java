package com.minigod.protocol.account.request.params;

import com.minigod.common.pojo.request.BaseRequestParams;
import lombok.Data;

import java.io.Serializable;

@Data
public class OpenProgressReqParams extends BaseRequestParams implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer flag;
}
