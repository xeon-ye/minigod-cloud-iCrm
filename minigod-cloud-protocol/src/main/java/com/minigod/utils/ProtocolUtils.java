package com.minigod.utils;

import com.minigod.common.exception.MiniGodException;
import com.minigod.common.utils.ReflectUtil;
import com.minigod.security.SecurityKey;
import com.minigod.security.util.AESUtil;
import com.minigod.security.util.RSAUtil;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.URLDecoder;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @Title: ProtocolUtils.java
 * @Description: 协议层通用工具
 * @Copyright:  2015 minigod
 * @Company: minigod
 *
 * @author ken
 * @date 2015-3-23 上午11:24:10
 * @version v1.0
 */

public class ProtocolUtils {

	/**
	 * 基于对象组装URL
	 * @param t
	 * @return
	 */
	public static <T extends Serializable> String getUrl(String baseUrl, T t) {
		Map<String, Field> fieldMap = ReflectUtil.getFieldMap(t.getClass());
		StringBuffer sb = new StringBuffer(baseUrl);
		sb.append("?");
		for (Entry<String, Field> entry : fieldMap.entrySet()) {
			String fieldName = entry.getKey();
			Field field = entry.getValue();
			try {
				//去掉静态方法
				if (!Modifier.isFinal(field.getModifiers())) {
					field.setAccessible(true);
					Object obj = field.get(t);
					if (obj != null) {
						sb.append(fieldName).append("=").append(escapeSpecialChar(obj.toString())).append("&");
					}
				}
			} catch (Exception e) {
				throw new MiniGodException("get url handler.", e);
			}
		}
		if (sb != null && sb.length() > 0) {
			sb.delete(sb.length() - 1, sb.length());
		}
		return sb.toString();
	}

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
	 * 转义http中的
	 * @param value
	 * @return
	 */
	private static String escapeSpecialChar(String value) {
		return value.replaceAll("%", "%25").replaceAll(" ", "%20").replaceAll("/", "%2F").replaceAll("\\?", "%3F").replaceAll("\\+", "%2B").replaceAll("#", "%23")
				.replaceAll("&", "%26").replaceAll("=", "%3D");
	}

	public static String getPwd(String pwd, String key) {
		try {
			pwd = pwd.trim();
			pwd = URLDecoder.decode(pwd, "UTF-8");
			key = URLDecoder.decode(key, "UTF-8");
			//解析密码
			pwd = RSAUtil.decrypt(pwd, key);
			return pwd;
		} catch (Exception e) {
			throw new MiniGodException("decoder pwd handler.", e);
		}
	}

	public static void main(String[] args) {
		//pwd":"XDQB87hK%2BUF09CyisGIP7Q%3D%3D"},"sign":"qEgdcXbkiGodMNAQ2RBayqcMDLc=
		/*System.err
				.println(getPwd(
						"SGqMR35c2WgBbAaFMot9cA%3D%3D",
						"WvVE1GX7bKaTl6vMYzkqPfRQA163X8j8XfJT9%2Ba%2F9lyi9k8JVYKUuJlO1nOpxSoWqI0we5tk%0AFvtTxofaappZuGGCVCQ2WzFoLf77xqo8lWpjPmLgtt%2B9E6OZiWQ2VXYlJl0vxClGuJzYLqFl%0AJZ4%2FucJ3SGKUQO0BH%2BZJ6zVRUhg%3D"));

		GXLoginRequest loginReq = new GXLoginRequest();
		loginReq.setAuthdata("123");
		loginReq.setAuthtype("哈哈");
		loginReq.setOperway("xxx");
		System.err.println(ProtocolUtils.getUrl("", loginReq));*/
		String encryptMobile = ProtocolUtils.getEncryptPhone("852-18123663572");
		System.err.println("encryptMobile: "+encryptMobile);
		System.err.println("decryptMobile: "+ProtocolUtils.getDecryptPhone("z3H8NlLncOewxzuMl2lBsQ=="));


	}
}
