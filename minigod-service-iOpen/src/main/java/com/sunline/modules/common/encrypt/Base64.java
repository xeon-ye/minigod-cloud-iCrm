package com.sunline.modules.common.encrypt;

import com.sunline.modules.common.utils.Base64CodeUtil;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

public class Base64
{
    /**
     * 加密(自已实现的)
     * @param s
     * @return
     * 成功返回结果，失败返回""
     */
    public static String Encode(String s)
    {
        if (s == null)
        {
            return "";
        }

        return Base64CodeUtil.encode(s);
    }

    /**
     * 解密(自已实现的)
     * @param s
     * @return
     * 成功返回结果，失败返回""
     */
    public static String Decode(String s)
    {
        if (s == null)
        {
            return "";
        }

        return Base64CodeUtil.decode(s);
    }

    /**
     * 加密
     * @param data
     * @return
     * 成功返回结果，失败返回null
     */
    public static String encodeBuffer(String data)
    {
        if (data == null)
            return null;

        return encodeBuffer(data.getBytes());
    }

    /**
     * 加密
     * @param data
     * @return
     * 成功返回结果，失败返回null
     */
    public static String encodeBuffer(byte [] data)
    {
        if (data == null)
            return null;

        return new BASE64Encoder().encodeBuffer(data).replaceAll("\r\n", "");
    }

    /**
     * 解密
     * @param data
     * @return
     * 成功返回结果，失败返回null
     */
    public static String decodeBuffers(String data)
    {
        byte [] bData = decodeBufferb(data);
        if (bData == null)
            return null;

        return new String(bData);
    }

    /**
     * 解密
     * @param data
     * @return
     * 成功返回结果，失败返回null
     */
    public static byte [] decodeBufferb(String data)
    {
        if (data == null)
            return null;

        try
        {
            return new BASE64Decoder().decodeBuffer(data);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
