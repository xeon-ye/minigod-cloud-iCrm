package com.minigod.protocol.account.szca.jfrequest;

import lombok.Data;

import java.io.Serializable;

@Data
public class JFSzcaSealPdfReqVo  implements Serializable {
    private static final long serialVersionUID = 2567158526227857817L;
    private String utoken;
    private String fileID;
    private String certDn;
    private String certSn;

}
