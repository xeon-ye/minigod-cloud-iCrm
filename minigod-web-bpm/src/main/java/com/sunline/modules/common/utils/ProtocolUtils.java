package com.sunline.modules.common.utils;

import com.sunline.security.SecurityKey;
import com.sunline.security.util.AESUtil;
import org.apache.commons.lang.StringUtils;

/**
 * @author ken
 * @version v1.0
 * @Title: ProtocolUtils.java
 * @Description: 协议层通用工具
 * @Copyright: 2015 sunline
 * @Company: sunline
 * @date 2015-3-23 上午11:24:10
 */

public class ProtocolUtils {

    //手机号加密
    public static String getEncryptPhone(String phone) {
        return AESUtil.encrypt(phone, SecurityKey.MOBILE_PHONE_KEY);
    }

    //通讯录名称加密
    public static String getEncryptNickName(String nickName) {
        return AESUtil.encrypt(nickName, SecurityKey.MOBILE_NAME_KEY);
    }

    // 手机号解密
    public static String getDecryptPhone(String phone) {
        return AESUtil.decrypt(phone, SecurityKey.MOBILE_PHONE_KEY);
    }

    // 通讯录名称解密
    public static String getDecryptNickName(String nickName) {
        return AESUtil.decrypt(nickName, SecurityKey.MOBILE_NAME_KEY);
    }


    /**
     * 比较两个版本号的大小,设定版本号为X.X.X...形式，X不超过3位
     * 1:version1>version2
     * 0:version1=version2
     * -1:version1<version2
     * 规则:缺省的用0补全 如X.X->X.X.0
     * 按照.进行切片，从左至右逐位比较
     *
     * @param version1
     * @param version2
     * @return
     */
    public static int compareVersion(String version1, String version2) {
        int arr1[] = {0, 0, 0};
        int arr2[] = {0, 0, 0};
        String v1[] = version1.split("\\.");
        String v2[] = version2.split("\\.");
        for (int i = 0; i < v1.length; i++) {
            if (StringUtils.isNotEmpty(v1[i])) {
                arr1[i] = Integer.valueOf(v1[i]);
            }
        }
        for (int i = 0; i < v2.length; i++) {
            if (StringUtils.isNotEmpty(v2[i])) {
                arr2[i] = Integer.valueOf(v2[i]);
            }
        }

        return compare(arr1, arr2, 0, 3);//从0位开始比较，往后递归
    }

    /**
     * 比较，前提是两个数组的长度要相等
     *
     * @param arr
     * @param brr
     * @param i
     * @param n   比较的最大位数，如果输入的超出比较位数的数组，返回前面N位比较的结果
     * @return
     */
    private static int compare(int arr[], int brr[], int i, int n) {
        if (i < n) {
            if (arr[i] > brr[i]) {
                return 1;
            } else if (arr[i] < brr[i]) {
                return -1;
            } else {
                return compare(arr, brr, i + 1, n);
            }
        } else {
            return 0;
        }

    }

    /**
     * 手机号加*处理
     *
     * @param phone
     * @return
     */
    public static String phone2Star(String phone) {
        if (StringUtils.isBlank(phone)) {
            return null;
        }
        if (phone.contains("-")) {
            //国际号处理
            phone = phone.substring(phone.lastIndexOf("-") + 1);
            return phone.replaceAll("(\\d{3})\\d{2}(\\d{3})", "$1**$2");
        } else {
            //国内号处理
            return phone.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
        }
    }

    public static void main(String[] args) {
//        System.out.println(getEncryptPhone("18268158078"));
        String encrypt = AESUtil.encrypt("123", SecurityKey.AES_IV);
        String decrypt = AESUtil.decrypt(encrypt, SecurityKey.AES_IV);
        System.err.println(ProtocolUtils.phone2Star("852-65599201"));

    }
}
