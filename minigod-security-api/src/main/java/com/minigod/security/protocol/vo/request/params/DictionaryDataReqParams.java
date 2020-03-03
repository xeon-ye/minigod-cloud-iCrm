package com.minigod.security.protocol.vo.request.params;

import com.minigod.common.pojo.request.BaseRequestParams;
import lombok.Data;

import java.io.Serializable;

@Data
public class DictionaryDataReqParams extends BaseRequestParams implements Serializable {
    private static final long serialVersionUID = 1L;

    private String mark;


}
