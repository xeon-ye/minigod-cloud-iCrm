package com.minigod.protocol.account.szca.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SzcaSealPdfReqVo implements Serializable {
    private static final long serialVersionUID = 2567158526227857817L;
    private String fileID;
    private String certDn;
    private String certSn;

}
