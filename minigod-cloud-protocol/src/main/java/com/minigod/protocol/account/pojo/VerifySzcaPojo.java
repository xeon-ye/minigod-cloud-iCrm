package com.minigod.protocol.account.pojo;

import lombok.Data;

@Data
public class VerifySzcaPojo {
    private Integer id;
    private String token;
    private String certDn;
    private String certSn;
    private Integer status;
    private String fileHash;
    private String fileId;
    private String fileUrl;
    private Boolean isValid;
    private String remark;
}
