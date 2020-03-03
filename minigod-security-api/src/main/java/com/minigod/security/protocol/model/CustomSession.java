package com.minigod.security.protocol.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class CustomSession implements Serializable {
    /**
    * 会话的id（自增主键）
    */
    private Integer id;

    /**
    * 用户ID
    */
    private Integer userId;

    /**
    * 设备ID
    */
    private Integer deviceId;

    private String token;

    /**
    * session过期时间
    */
    private Date expireTime;

    /**
    * 是否有效(1有效,0无效)
    */
    private Boolean isStatus;

    private String msg;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 最后修改时间
    */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}