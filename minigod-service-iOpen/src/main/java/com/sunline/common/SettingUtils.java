package com.sunline.common;

import cn.hutool.setting.Setting;

/**
 * @author LiYangFeng
 * @createDate 2018/3/27
 * @description
 * @email justbelyf@gmail.com
 */
public class SettingUtils {
    private SettingUtils(){}

    private SettingUtils settingUtils = new SettingUtils();

    public static String getValue(String key) {

        return null;
    }

    private void init(){
        Setting setting = new Setting("setting/system.setting");
    }
}
