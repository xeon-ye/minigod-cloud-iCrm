package com.minigod.common.exception;

import com.minigod.common.pojo.StaticType;
import lombok.Getter;

/**
 * 自定义 异常
 */

@Getter
public class InternalApiException extends RuntimeException {

    private Integer code;
    private String messageResource;

    public InternalApiException(Integer status, String message, String messageResource) {
        super(message);
        this.code = status;
        this.messageResource = messageResource;
    }

    public InternalApiException(String messageResource) {
        super(StaticType.CodeType.DISPLAY_ERROR.getMessage());
        this.code = StaticType.CodeType.DISPLAY_ERROR.getCode();
        this.messageResource = messageResource;
    }

    public InternalApiException(StaticType.CodeType codeType, String messageResource) {
        super(codeType.getMessage());
        this.code = codeType.getCode();
        this.messageResource = messageResource;
    }
}
