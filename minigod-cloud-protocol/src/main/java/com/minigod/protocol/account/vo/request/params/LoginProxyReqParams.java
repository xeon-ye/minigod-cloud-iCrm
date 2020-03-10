package com.minigod.protocol.account.vo.request.params;

import com.minigod.common.pojo.request.BaseRequestParams;
import lombok.Data;

import java.io.Serializable;

@Data
public class LoginProxyReqParams extends BaseRequestParams implements Serializable {
    private static final long serialVersionUID = 1L;

    private String account; // 第三方平台账号
    private String password; // 第三方平台密码
}
