package com.sunline.common;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

/**
 * @author LiYangFeng
 * @createDate 2018/3/27
 * @description
 * @email justbelyf@gmail.com
 */
public class ConfigUtils {
    private static Map<String, String> configs;
    public static String get(String key){
        if (null == configs) {
            configs = Maps.newConcurrentMap();
            init();
        }
        return configs.get(key);
    }

    private static void init(){
        ResourceBundle resourceBundle = ResourceBundle.getBundle("setting/system");
        Set<String> keys = resourceBundle.keySet();
        for (String key : keys) {
            configs.put(key, resourceBundle.getString(key));
        }
    }

    public static void main(String[] args) {
        System.out.println(get("message.center.sms.url"));
    }
}
