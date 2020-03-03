package com.minigod.common.security;

/**
 * @Title: StringUtil.java
 * @Description: 
 * @Copyright:  2016 minigod
 * @Company: minigod
 *
 * @author
 * @date 2015-5-2 下午2:40:45
 * @version v1.0
 */

public class SecurityUtil {

	public static boolean isBlank(String str) {
		int strLen;
		if (str == null || (strLen = str.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if ((Character.isWhitespace(str.charAt(i)) == false)) {
				return false;
			}
		}
		return true;
	}
}
