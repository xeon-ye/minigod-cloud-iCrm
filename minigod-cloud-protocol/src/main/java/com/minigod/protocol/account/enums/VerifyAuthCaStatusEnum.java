package com.minigod.protocol.account.enums;

public final class VerifyAuthCaStatusEnum {
    public static final int UN_KNOW = 1 << 0; //未开始
    public static final int CA_P10 = 1 << 1; //已申请证书
    public static final int CA_SIGN = 1 << 2; //已签名
    public static final int CA_P7_PDF = 1 << 3; //已合成PDF

    public static boolean isFlag(int reqFlag, int mask) {
        return (reqFlag & mask) != 0;
    }
}
