package com.minigod.common.utils;

import java.math.BigDecimal;

public class NumberUtils {
	
	/**
	 * 格式化double类型数据
	 * @param value 
	 * @param bits 保留小数位数
	 * @return
	 */
	public static double formatDouble(double value,int bits) {
		BigDecimal bg = new BigDecimal(value);
		double f1 = bg.setScale(bits, BigDecimal.ROUND_HALF_UP).doubleValue();
		return f1;
	}
	
	/**
	 * 格式化float类型数据
	 * @param value
	 * @param bits 保留小数位数
	 * @return
	 */
	public static float formatFloat(float value,int bits) {
		BigDecimal bg = new BigDecimal(value);
		float f1 = bg.setScale(bits, BigDecimal.ROUND_HALF_UP).floatValue();
		return f1;
	}
	
	/**
	 * 格式化float类型数据(保留2位小数)
	 * @param value
	 * @return
	 */
	public static float formatFloat(float value) {
		return formatFloat(value,2);
	}

	//是否是数字
	public static boolean isNumeric(String str) {
		for (int i = str.length(); --i >= 0;) {
			int chr = str.charAt(i);
			if (chr < 48 || chr > 57)
				return false;
		}
		return true;
	}
}
