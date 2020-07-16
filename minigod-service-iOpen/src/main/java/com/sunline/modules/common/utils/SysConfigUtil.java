package com.sunline.modules.common.utils;

import com.sunline.modules.sys.service.SysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 系统参数静态方法
 *
 * @author lcs
 */

@Component
public class SysConfigUtil {

    @Autowired
    private SysConfigService sysConfigService;
    private static SysConfigService configService;

    @PostConstruct
    public void init() {
        configService = sysConfigService;
    }

    /**
     * 通过KeyId获取参数值，无默认值
     *
     * @param keyId
     * @return
     */
    public static String getSysConfigValueByKeyId(String keyId) {
        return configService.getValueByKeyId(keyId);
    }

    /**
     * 通过Key获取参数值，自定义默认值
     *
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getSysConfigValue(String key, String defaultValue) {
        return configService.getValue(key, defaultValue);
    }

}
