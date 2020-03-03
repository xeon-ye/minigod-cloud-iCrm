package com.minigod.notify.protocol.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class CaptchaSms implements Serializable {
    /**
    * 验证码id
    */
    private Integer id;

    /**
    * 手机号码
    */
    private String phone;

    /**
    * 验证码类型
    */
    private String type;

    /**
    * 验证码，6位
    */
    private String captcha;

    /**
    * 短信失效时间
    */
    private Date expiresTime;

    /**
    * 是否验证过
    */
    private Boolean isChecked;

    /**
    * 是否使用过
    */
    private Boolean isUsed;

    /**
    * 验证错误次数
    */
    private Byte validateCount;

    /**
    * 信息发送时间
    */
    private Date createTime;

    /**
    * 信息修改时间
    */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}