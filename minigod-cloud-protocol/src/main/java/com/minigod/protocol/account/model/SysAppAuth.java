package com.minigod.protocol.account.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SysAppAuth implements Serializable {
    private Integer id;

    /**
     * 终端产品key
     */
    private String appKey;

    /**
     * 安全密钥
     */
    private String appSecret;

    /**
     * 为空表示不限
     */
    private String appVersion;

    /**
     * 设备类型，1标识PC端 | 2标识手机端 | 3标识平板端, 多个用","分隔，为空表示所有
     */
    private String deviceTypes;

    /**
     * 操作系统类型，1标识Android | 2标识iOS | 3标识WindowPhone, 多个用","分隔，为空表示所有
     */
    private String osTypes;

    /**
     * 信任的ip，多个ip用","分隔，为空表示允许所有ip
     */
    private String believeIps;

    /**
     * 是否启动
     */
    private Boolean isEnabled;

    /**
     * 备注
     */
    private String remarks;

    private Date createTime;

    private Date updateTime;

    /**
     * 逻辑删除
     */
    private Boolean deleted;

    private static final long serialVersionUID = 1L;
}