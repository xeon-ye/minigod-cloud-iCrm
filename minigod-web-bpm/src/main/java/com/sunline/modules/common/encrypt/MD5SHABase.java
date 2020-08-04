package com.sunline.modules.common.encrypt;

import java.security.MessageDigest;

/**
 * Created by Dengfujun on 2016-11-09.
 */
public class MD5SHABase
{
    public static final int ENCRYPT_MD5    = 0;
    public static final int ENCRYPT_SHA1   = 1;
    public static final int ENCRYPT_SHA256 = 2;

    /**
     * MD5、SHA加密算法
     * @param byteData 原始数据
     * @param encryptType 加密类型，0 - MD5； 1 - SHA-1；2 - SHA-256
     * @return
     * 出错则返回null
     */
    public static String SHAMD5Encrypt(byte [] byteData, int encryptType)
    {
        try
        {
            String encryptTypeName = "";
            if (encryptType == ENCRYPT_SHA1)
                encryptTypeName = "SHA-1";
            else if (encryptType == ENCRYPT_SHA256)
                encryptTypeName = "SHA-256";
            else if (encryptType == ENCRYPT_MD5)
                encryptTypeName = "MD5";
            else
                return null;

            //MD5和SHA的实现方法是一样的，根据MessageDigest.getInstance()转入的算法名字来决定是MD5或者SHA-1或者SHA-256
            MessageDigest messageDigest = MessageDigest.getInstance(encryptTypeName);
            messageDigest.update(byteData);
            byte bMD5ByteList[] = messageDigest.digest();
            StringBuffer strBuf = new StringBuffer("");
            for (byte bBit : bMD5ByteList)
            {
                int iBit = bBit < 0 ? bBit + 256 : bBit;
                if(iBit < 16)
                {
                    strBuf.append("0");
                }

                strBuf.append(Integer.toHexString(iBit).toUpperCase());
            }
            return strBuf.toString();

        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
