package com.minigod.common;

import java.io.Serializable;

/**
 * @author LiYangFeng
 * @createDate 2017/10/11
 * @description
 * @email justbelyf@gmail.com
 */
public class CommonErrorCode implements Serializable {
    private Integer errorCode;
    private String errorMessage;

    public static CommonErrorCode getErrorCode(int errorCode, String errorMessage) {
        CommonErrorCode commonErrorCode = new CommonErrorCode();
        commonErrorCode.setErrorCode(errorCode);
        commonErrorCode.setErrorMessage(errorMessage);

        return commonErrorCode;
    }


    public static CommonErrorCode getDefaultSucceedErrorCode(){
        return getErrorCode(0,"SUCCEED");
    }


    public static CommonErrorCode getDefaultFailedErrorCode(){
        return getErrorCode(-1,"FAILED");
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
