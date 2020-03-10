package com.minigod.protocol.account.vo.request.params;

import com.minigod.common.pojo.request.BaseRequestParams;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

@Data
public class AuthProxyReqParams extends BaseRequestParams implements Serializable {
    private static final long serialVersionUID = 1L;

    private String appKey; // 产品标识（使用secretKey进行RSA加密）
    private String secret; // 密钥
    private DeviceInfo deviceInfo; // 设备信息

    @Getter
    public class DeviceInfo {
        private String deviceCode;  // 设备唯一标识
        private Byte deviceType; // 设备类型(0 PC; 1 手机; 2 平板)
        private String deviceModel; // 设备信息
        private String deviceName;  // 名称
        private Byte osType;     // 操作系统类型(0安卓，1苹果，2WP)
        private String osVersion;   // 操作系统版本
        private String appVersion;  // 产品版本
    }
}


