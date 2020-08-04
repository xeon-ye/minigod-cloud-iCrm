package com.sunline.modules.common.common;

/**
 * @author LiYangFeng
 * @createDate 2017/2/14
 * @description
 * @email justbelyf@gmail.com
 */
public class CommonResultCode {
    private String errorCode;

    private String errorMessage;


    public static CommonResultCode getDefaultSucceed() {
        CommonResultCode commonResultCode = new CommonResultCode();
        commonResultCode.setErrorCode("0");
        commonResultCode.setErrorMessage("succeed");
        return commonResultCode;
    }

    public static CommonResultCode getDefaultFailed() {
        CommonResultCode commonResultCode = new CommonResultCode();
        commonResultCode.setErrorCode("-1");
        commonResultCode.setErrorMessage("failed");
        return commonResultCode;
    }

    public static CommonResultCode getCommonResultCode(String errorCode, String errorMessage) {
        CommonResultCode commonResultCode = new CommonResultCode();
        commonResultCode.setErrorCode(errorCode);
        commonResultCode.setErrorMessage(errorMessage);
        return commonResultCode;

    }


    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
