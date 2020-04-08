package com.minigod.protocol.account.response;

import lombok.Data;

@Data
public class VerifyResVo {
    private Boolean isValid;
    private String remark;
}
