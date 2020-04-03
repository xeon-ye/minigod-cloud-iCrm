package com.minigod.protocol.account.request.params;

import com.minigod.common.pojo.request.BaseRequestParams;
import lombok.Data;

import java.io.Serializable;

/**
 * CUBP配置信息请求参数
 */
@Data
public class DictionaryDataReqParams extends BaseRequestParams implements Serializable {
    private static final long serialVersionUID = 1L;

    private String mark;


}
