package com.sunline.modules.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 类DateUtils的功能描述:
 * 将秒化成 时分秒
 * @auther lcs
 * @date 2017-08-25 16:12:36
 */
public class TimeUtils {
    public static String secondFormat(int second) {
        int hour = second / 3600;
        int min = second % 3600 / 60;
        int sec = second % 60;
        StringBuffer time = new StringBuffer();
        if(hour>=10){
            time.append(String.valueOf(hour)).append(":");
        }else{
            time.append("0").append(String.valueOf(hour)).append(":");
        }
        if(min>=10){
            time.append(String.valueOf(min)).append(":");
        }else{
            time.append("0").append(String.valueOf(min)).append(":");
        }
        if(sec>=10){
            time.append(String.valueOf(sec));
        }else{
            time.append("0").append(String.valueOf(sec));
        }
        return time.toString() ;
    }
}
