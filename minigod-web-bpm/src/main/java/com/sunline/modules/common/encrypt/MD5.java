package com.sunline.modules.common.encrypt;

public class MD5 extends MD5SHABase
{
	public static String Md5(byte [] byteData)
	{
		return Md5_32(byteData);
	}
	
	public static String Md5(String strData)
	{
		return Md5_32(strData);
	}

	public static String Md5_16(byte [] byteData)
	{
		String strMd532 =  Md5_32(byteData);
		return strMd532 == null ? null : strMd532.substring(8, 24);
	}

	public static String Md5_16(String strData)
	{
		String strMd532 =  Md5_32(strData);
		return strMd532 == null ? null : strMd532.substring(8, 24);
	}

	public static String Md5_32(String strData)
	{
		try
		{
			return Md5_32(strData.getBytes("UTF-8"));
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public static String Md5_32(byte [] byteData)
	{
		return SHAMD5Encrypt(byteData, ENCRYPT_MD5);
	}

//	public static String Md5_32(byte [] byteData)
//	{
//		try
//		{
//			MessageDigest md5 = MessageDigest.getInstance("MD5");
//			md5.update(byteData);
//			byte bMD5ByteList[] = md5.digest();
//			StringBuffer strBuf = new StringBuffer("");
//			for (byte bBit : bMD5ByteList)
//			{
//				int iBit = bBit < 0 ? bBit + 256 : bBit;
//				if(iBit < 16)
//				{
//					strBuf.append("0");
//				}
//
//				strBuf.append(Integer.toHexString(iBit).toUpperCase());
//			}
//			return strBuf.toString();
//
//		}
//		catch (Exception e)
//		{
//			e.printStackTrace();
//			return null;
//		}
//	}
}
