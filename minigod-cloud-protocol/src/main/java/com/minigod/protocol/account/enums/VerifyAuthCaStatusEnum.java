package com.minigod.protocol.account.enums;

import lombok.Data;
import lombok.Getter;

@Getter
public enum VerifyAuthCaStatusEnum {
    UN_KNOW(-1,"未知"),
    UN_START(0,"未开始"),
    CA_P10(1,"已申请证书"),
    CA_SIGN(2,"已签名"),
    CA_P7_PDF(3,"已合并");

    private Integer code;
    private String value;

    private VerifyAuthCaStatusEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public static boolean isFlag(int reqCode, VerifyAuthCaStatusEnum enums) {
        return reqCode >= enums.getCode();
    }

}
