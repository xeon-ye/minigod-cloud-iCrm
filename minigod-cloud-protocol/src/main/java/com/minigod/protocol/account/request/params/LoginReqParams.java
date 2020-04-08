package com.minigod.protocol.account.request.params;

import com.minigod.common.pojo.request.BaseRequestParams;
import lombok.Data;

import java.io.Serializable;

@Data
public class LoginReqParams extends BaseRequestParams implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer certType; // 账号类型 0-其他系统账号 1-手机 2-邮箱 3-用户账号 4-交易账号
    private String certCode; // 账号
    private Integer captchaId; // 验证码ID
    private Integer passwordType; // 密码类型 0-其他 1-验证码 2-密码
    private String password; // 登录密码/验证码/第三方登录凭证
}
