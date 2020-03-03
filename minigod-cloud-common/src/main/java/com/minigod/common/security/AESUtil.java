package com.minigod.common.security;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESUtil {
	private static byte[] iv = null;

	//加密
	public static String encrypt(String data, String key) {
		try {
			if (SecurityUtil.isBlank(data)) {
				throw new MiniGodSecurityException("AES encrypt parameter handler.");
			}

			if ((SecurityUtil.isBlank(key)) || (key.length() != 16)) {
				throw new MiniGodSecurityException("AES encrypt key length: 16 bytes.");
			}

			if (iv == null) {
				iv = SecurityKey.AES_IV.getBytes("UTF-8");
			}

			SecretKeySpec keySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
			IvParameterSpec ivSpec = new IvParameterSpec(iv);

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(1, keySpec, ivSpec);

			return new String(Base64.encode(cipher.doFinal(data.getBytes("UTF-8"))));
		} catch (Exception e) {
			throw new MiniGodSecurityException("AES encrypt handler.", e);
		}
	}

	//加密
	public static String encrypt(byte[] data, byte[] key, byte[] ivKey) {
		try {
			SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
			IvParameterSpec ivSpec = new IvParameterSpec(ivKey);

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(1, keySpec, ivSpec);

			return new String(Base64.encode(cipher.doFinal(data)));
		} catch (Exception e) {
			throw new MiniGodSecurityException("AES encrypt handler.", e);
		}
	}

	//解密
	public static String decrypt(String data, String key) {
		try {
			if (SecurityUtil.isBlank(data)) {
				throw new MiniGodSecurityException("AES decrypt parameter handler.");
			}

			if ((SecurityUtil.isBlank(key)) || (key.length() != 16)) {
				throw new MiniGodSecurityException("AES decrypt key length: 16 bytes.");
			}

			if (iv == null) {
				iv = SecurityKey.AES_IV.getBytes("UTF-8");
			}

			SecretKeySpec keySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
			IvParameterSpec ivSpec = new IvParameterSpec(iv);

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(2, keySpec, ivSpec);

			return new String(cipher.doFinal(Base64.decode(data)), "UTF-8");
		} catch (Exception e) {
			throw new MiniGodSecurityException("AES decrypt handler.", e);
		}
	}

	//解密
	public static String decrypt(byte[] data, byte[] key, byte[] ivKey) {
		try {
			SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
			IvParameterSpec ivSpec = new IvParameterSpec(ivKey);

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(2, keySpec, ivSpec);

			return new String(cipher.doFinal(Base64.decode(data)), "UTF-8");
		} catch (Exception e) {
			throw new MiniGodSecurityException("AES decrypt handler.", e);
		}
	}

	private static String getPwdKey(Integer userId) {
		String key = userId + IDTransUtil.encodeId(userId, SecurityKey.getIdKey()) + String.valueOf(userId);
		return key.substring(2, 18);
	}
	// 手机号加密
	public static String getEncryptPhone(String phone) {
		return AESUtil.encrypt(phone, SecurityKey.MOBILE_PHONE_KEY);
	}

	// 手机号解密
	public static String getDecryptPhone(String phone) {
		return AESUtil.decrypt(phone, SecurityKey.MOBILE_PHONE_KEY);
	}

	public static void main(String[] args) {
		/*String aa = encrypt("123456", SecurityKey.AES_IV);
		System.out.println(aa);
*/
		String a = "gUg23i1fIWE12MJin01pbg==";
		String b = getDecryptPhone(a);
		System.out.println(b);

		String iphone = "18926516159";
		String e = getEncryptPhone(iphone);
		System.out.println("s="+e);
		/**/

		String ad = "9fstocksns";
		String ea = encrypt(ad, SecurityKey.AES_IV);
		System.out.println(ea);
		/*String b = decrypt(a, SecurityKey.AES_IV);
		System.out.println(b);*/

		/*List list = new ArrayList();
		list.add("1");

		Object obj = new Object();
		obj = list;
		System.out.println(obj);
		List as = (List) obj;
		System.out.println(as);*/
	}
}
