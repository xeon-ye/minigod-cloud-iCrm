package com.minigod.protocol.account.szca.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

@Data
public class SzcaSignP7ForPdfReqVo implements Serializable {
    private static final long serialVersionUID = 4003542442630693325L;

    private String certDn;
    private String certSn;
    private String fileID;

    @JSONField(name = "P1SignData")
    private String p1SignData;
    private String applyType;
    private String ifTsa;

}
