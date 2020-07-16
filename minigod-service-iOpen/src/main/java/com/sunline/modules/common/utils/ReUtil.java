package com.sunline.modules.common.utils;

/**
 * @description: 正则工具
 * @author: Larry Lai
 * @date: 2019/9/3 11:40
 * @version: v1.0
 */

public class ReUtil {

    /**
     * 密码的校验：大小写字母、数字、特殊字符中的至少3种
     * @param input
     * @return
     */
    public static boolean rexCheckPassword(String input) {
        // 8-20 位，字母、数字、字符
        String regStr = "^(?![a-zA-Z]+$)(?![A-Z0-9]+$)(?![A-Z\\W_]+$)(?![a-z0-9]+$)(?![a-z\\W_]+$)(?![0-9\\W_]+$)[a-zA-Z0-9\\W_]{8,20}$";
        return input.matches(regStr);
    }

}
