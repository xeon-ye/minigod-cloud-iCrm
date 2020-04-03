package com.minigod.protocol.common.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ConfigLanguage implements Serializable {
    /**
    * 配置id（自增主键）
    */
    private Integer id;

    /**
    * 手机号码
    */
    private String configKey;

    /**
    * 邮箱
    */
    private String langKey;

    /**
    * 密码（可空）
    */
    private String content;

    /**
    * 描述
    */
    private String marks;

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