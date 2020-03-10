package com.minigod.protocol.account.vo.request.params;

import com.minigod.common.pojo.request.BaseRequestParams;
import lombok.Data;

import java.io.Serializable;

@Data
public class RetisterReqParams extends BaseRequestParams implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer certType; // 账号类型 0 手机号 1 邮箱 2 token
    private String certCode; // 账号
    private Integer checkWays; // 登录方式 0 密码登录 2 验证码登录 3 token登录
    private Integer captchaId; // 验证码ID
    private String password; // 登录密码/验证码

}
