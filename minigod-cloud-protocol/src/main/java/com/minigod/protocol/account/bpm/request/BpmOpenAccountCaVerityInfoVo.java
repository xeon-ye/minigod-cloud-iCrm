package com.minigod.protocol.account.bpm.request;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class BpmOpenAccountCaVerityInfoVo implements Serializable {
    private static final long serialVersionUID = 4738512623933513977L;

    private String applicationId;
    private String caVerifyStatus;
    private String caVerifyMsg;
    private String caSignHashCode;
    private String caVerifyFileUrl;

    private List<BpmOpenAccountCaVeritySnInfoVo> CaVerityInfoList;

}
