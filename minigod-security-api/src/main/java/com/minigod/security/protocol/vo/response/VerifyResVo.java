package com.minigod.security.protocol.vo.response;

import lombok.Data;

@Data
public class VerifyResVo {
    private Boolean isValid;
    private String remark;
}
