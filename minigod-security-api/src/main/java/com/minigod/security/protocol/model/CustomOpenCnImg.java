package com.minigod.security.protocol.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class CustomOpenCnImg implements Serializable {
    private Integer id;

    private Integer userId;

    /**
     * 图片位置[0=未知 1=身份证正面照坐标 2=身份证反面照片坐标 3=指定动作1照坐标 4=指定动作2照坐标 5=指定动作3照坐标 6=电子签名照坐标]
     */
    private String locationKey;

    /**
     * 图片类型[0=未知 1=身份证正面照 2=身份证反面照片 3=左手竖起1个指头 4=右手竖起1个指头 5=左手竖起2个指头 6=右手竖起2个指头 7=左手竖起3个指头 8=右手竖起3个指头 9=正面照 10=电子签名照]
     */
    private String locationType;

    private String url;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 标识错误图片，1:图片错误
     */
    private Integer errorStatus;

    private static final long serialVersionUID = 1L;
}