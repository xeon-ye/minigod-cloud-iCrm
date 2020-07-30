package com.minigod.protocol.account.szca.jfrequest;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

@Data
public class JFSzcaSignP7ForPdfReqVo implements Serializable {
    private static final long serialVersionUID = 4003542442630693325L;
    private String utoken;

    private String certDn;
    private String certSn;
    private String fileID;

    @JSONField(name = "P1SignData")
    private String p1SignData;
    private String applyType;
    private String ifTsa;

}
