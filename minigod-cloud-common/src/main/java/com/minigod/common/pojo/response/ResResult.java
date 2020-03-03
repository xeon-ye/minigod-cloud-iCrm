package com.minigod.common.pojo.response;

import com.minigod.common.pojo.StaticType;
import lombok.Data;

/**
 * 自定义响应结构
 */
@Data
public class ResResult {
    private Integer code = StaticType.CodeType.OK.getCode(); //返回的状态
    private String message; //返回的消息
    private Object result; //返回的结果

    public ResResult() {
    }

    public ResResult(Integer code, String msg, Object result) {
        this.code = code;
        this.message = msg;
        this.result = result;
    }

    public static ResResult success(Object result) {
        int code = StaticType.CodeType.OK.getCode();
        String msg = StaticType.CodeType.OK.getMessage();
        return new ResResult(code, msg, result);
    }

    public static ResResult success() {
        return success(null);
    }

    public static ResResult errorWithMessage(String errorMessage) {
        ResResult r = new ResResult();
        r.setCode(StaticType.CodeType.DISPLAY_ERROR.getCode());
        r.setMessage(errorMessage);
        return r;
    }
}
