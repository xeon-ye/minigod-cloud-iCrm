package com.minigod.common.verify.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.minigod.common.utils.DateUtils;
import com.minigod.common.utils.NumberUtils;
import org.apache.commons.lang.StringUtils;

public class VerifyUtil {
	public static List<String> serialNos = new ArrayList<String>();
	private static String pattern = "((11|12|13|14|15|21|22|23|31|32|33|34|35|36|37|41|42|43|44|45|46|50|51|52|53|54|61|62|63|64|65|71|81|82|91)\\d{4})((((19|20)(([02468][048])|([13579][26]))0229))|((20[0-9][0-9])|(19[0-9][0-9]))((((0[1-9])|(1[0-2]))((0[1-9])|(1\\d)|(2[0-8])))|((((0[1,3-9])|(1[0-2]))(29|30))|(((0[13578])|(1[02]))31))))((\\d{3}(x|X))|(\\d{4}))";
	public static int uniqueKey = 1;

	public static boolean isMobNO(String mobiles) {
//		Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0-9])|(147)|(145))\\d{8}$");
		Pattern p = Pattern.compile("\\d{11}"); // 新规则，放宽为11位纯数字
		Matcher m = p.matcher(mobiles);
		return m.matches();
	}

	public static boolean isIDNo(String idNumber) {
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(idNumber);
		return m.matches();
	}

	public static boolean isEmail(String email) {
		String str = "^[a-zz0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$";
		Pattern p = Pattern.compile(str);
		Matcher m = p.matcher(email);
		return m.matches();
	}

	public static boolean isNull(String... values) {
		for (String string : values) {
			if (string == null || "".equals(string)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isNumber(String source) {
		char[] seq = source.toCharArray();
		for (char c : seq) {
			if (c < 48 || c > 57) {
				return false;
			}
		}
		return true;
	}

	public static boolean containSpaces(String... values) {
		for (String str : values) {
			if (str.contains(" ")) {
				return true;
			}
		}
		return false;
	}

	public static boolean isValidPwd(String pwd) {
		if (pwd == null) {
			return false;
		}
		if (!containSpaces(pwd)) {
			return false;
		}
		if (pwd.length() != 32) {
			return false;
		}
		return true;
	}

	public static Date fromatDate(String date, String format) {
		try {
			return DateUtils.stringToDate(date, format);
		} catch (Exception ex) {
			return null;
		}
	}

	public static boolean verifyDateTime(String dateTime, String format) {
		boolean flag = false;

		flag = verifyStr(dateTime);
		if (!flag) {
			return flag;
		}
		flag = verifyStr(format);
		if (!flag) {
			return flag;
		}

		if (dateTime == null || "".equals(dateTime)) {
			return flag;
		}

		Date d = fromatDate(dateTime, format);
		if (d != null) {
			flag = true;
		}
		return flag;
	}

	public static boolean verifyDate(String date) {
		return verifyDateTime(date, "yyyy-MM-dd");
	}

	public static boolean verifyStr(String str) {
		boolean flag = false;
		if (str == null || "".equals(str.trim())) {
			return flag;
		}
		if ("NA".equalsIgnoreCase(str)) {
			return flag;
		}
		flag = true;
		return flag;
	}

	public static boolean isIP(String ip) {
		String regex = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\." + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\." + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
				+ "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(ip);
		return m.matches();
	}

	/**
	 * 校验手机格式
	 *
	 * @param mobile
	 * @return
	 */
	public static boolean verifyMobile(String mobile) {
		if (StringUtils.isBlank(mobile)) {
			return false;
		}
		if (mobile.indexOf("-") == -1) {//国内手机号
			return isMobNO(mobile);
		} else {//国际手机号
			return isInternationalMobile(mobile);
		}
	}


	/**
	 * 校验手机格式是否合法，拼接区号的国际手机号，形如：“852-95525227”。
	 *
	 * @param mobile
	 * @return
	 */
	public static boolean isInternationalMobile(String mobile) {
		if (StringUtils.isBlank(mobile)) {
			return false;
		}
		String str = mobile.replace("-", "");
		if (!NumberUtils.isNumeric(str)) {
			return false;
		} else {
			return true;
		}
	}
}
