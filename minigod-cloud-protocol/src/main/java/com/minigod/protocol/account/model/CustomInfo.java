package com.minigod.protocol.account.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomInfo implements Serializable {
    /**
     * 自增主键
     */
    private Integer id;

    /**
     * 第三方平台用户ID
     */
    private Integer thirdCode;

    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 注册来源
     */
    private String regSource;

    /**
     * 注册邀请人
     */
    private Integer regInviteId;

    /**
     * 注册渠道
     */
    private String regChannel;

    /**
     * 昵称
     */
    private String nickname;

    private String password;

    /**
     * 用户状态 0-停用,1-正常,2-锁定
     */
    private Integer status;

    private String lastLoginIp;

    private Date lastLoginTime;

    private Long loginCount;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}