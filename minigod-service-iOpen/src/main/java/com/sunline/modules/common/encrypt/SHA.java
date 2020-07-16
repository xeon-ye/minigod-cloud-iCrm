package com.sunline.modules.common.encrypt;

import java.io.UnsupportedEncodingException;

/**
 * Created by Dengfujun on 2016-11-09.
 */
public class SHA extends MD5SHABase
{

    public static String SHA1(byte [] byteData)
    {
        return SHA(byteData, ENCRYPT_SHA1);
    }

    public static String SHA1(String strData)
    {
        try
        {
            return SHA(strData.getBytes("UTF-8"), ENCRYPT_SHA1);
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public static String SHA256(byte [] byteData)
    {
        return SHA(byteData, ENCRYPT_SHA256);
    }

    public static String SHA256(String strData)
    {
        try
        {
            return SHA(strData.getBytes("UTF-8"), ENCRYPT_SHA256);
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * SHA加密算法
     * @param byteData 原始数据
     * @param encryptType 加密类型，1 - SHA-1；2 - SHA-256
     * @return
     */
    public static String SHA(byte [] byteData, int encryptType)
    {
        return SHAMD5Encrypt(byteData, encryptType);
    }
}
