package com.minigod.protocol.account.response;

import lombok.Data;

@Data
public class VerifyResVo {
    private Integer id;
    private Boolean isValid;
    private String remark;
}
