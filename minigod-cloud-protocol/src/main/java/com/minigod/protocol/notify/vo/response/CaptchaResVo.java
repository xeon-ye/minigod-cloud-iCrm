package com.minigod.protocol.notify.vo.response;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
public class CaptchaResVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer captchaId;// 验证码事件Id
    private Date expiresTime;

}
