package com.minigod.protocol.account.cubp.request;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CubpOpenAccountCaVerityInfoVo implements Serializable {
    private static final long serialVersionUID = 4738512623933513977L;

    private String applicationId;
    private String caVerifyStatus;
    private String caVerifyMsg;
    private String caSignHashCode;
    private String caVerifyFileUrl;

    private List<CubpOpenAccountCaVeritySnInfoVo> CaVerityInfoList;

}
