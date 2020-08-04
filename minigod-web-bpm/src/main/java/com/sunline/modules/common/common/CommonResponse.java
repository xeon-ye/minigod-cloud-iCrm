package com.sunline.modules.common.common;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author LiYangFeng
 * @createDate 2017/3/14
 * @description
 * @email justbelyf@gmail.com
 */
public class CommonResponse {
    @JSONField(name = "errorInfo")
    private CommonErrorCode commonErrorCode;

    @JSONField(name = "dataResult")
    private Object dataResult;

    public CommonErrorCode getCommonErrorCode() {
        return commonErrorCode;
    }

    public void setCommonErrorCode(CommonErrorCode commonErrorCode) {
        this.commonErrorCode = commonErrorCode;
    }

    public Object getDataResult() {
        return dataResult;
    }

    public void setDataResult(Object dataResult) {
        this.dataResult = dataResult;
    }

    public static CommonResponse getResponse(String errorCode, String errorMsg) {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setCommonErrorCode(CommonErrorCode.getErrorCode(errorCode, errorMsg));
        return commonResponse;
    }
}
