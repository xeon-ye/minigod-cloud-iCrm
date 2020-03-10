package com.minigod.protocol.account.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomDevice implements Serializable {
    /**
     * 设备ID
     */
    private Integer id;

    /**
     * 设备唯一标识，UUID
     */
    private String deviceCode;

    /**
     * 设备类型 1(1<<0)标识PC端 | 2(1<<1)标识手机端 | 4(1<<2)标识平板端
     */
    private Byte deviceType;

    private String deviceModel;

    private String deviceName;

    /**
     * 操作系统类型 1(1<<0)标识Android | 2(1<<1)标识iOS | 4(1<<2)标识WindowPhone
     */
    private Byte osType;

    /**
     * 操作系统版本
     */
    private String osVersion;

    /**
     * 授权产品Id
     */
    private Integer appId;

    private String appVersion;

    /**
     * 状态(手机丢失后，用户可以禁用该设备,1正常使用，0禁用)
     */
    private Boolean status;

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