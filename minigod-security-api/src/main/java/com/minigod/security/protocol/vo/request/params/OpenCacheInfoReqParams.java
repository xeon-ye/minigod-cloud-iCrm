package com.minigod.security.protocol.vo.request.params;

import com.minigod.common.pojo.request.BaseRequestParams;
import lombok.Data;

import java.io.Serializable;

@Data
public class OpenCacheInfoReqParams extends BaseRequestParams implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer step;
    private Object info;

}
