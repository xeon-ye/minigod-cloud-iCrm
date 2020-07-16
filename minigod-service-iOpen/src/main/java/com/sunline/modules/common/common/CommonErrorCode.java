package com.sunline.modules.common.common;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author LiYangFeng
 * @createDate 2017/3/14
 * @description
 * @email justbelyf@gmail.com
 */
public class CommonErrorCode {
    @JSONField(name = "errorCode")
    private String errorCode;

    @JSONField(name = "errorMsg")
    private String errorMsg;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public static CommonErrorCode getErrorCode(String errorCode, String errorMsg) {
        CommonErrorCode commonErrorCode = new CommonErrorCode();
        commonErrorCode.setErrorCode(errorCode);
        commonErrorCode.setErrorMsg(errorMsg);
        return commonErrorCode;
    }
}
