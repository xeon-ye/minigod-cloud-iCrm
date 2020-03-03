package com.minigod.common.utils;

import com.minigod.common.exception.MiniGodException;

/**
 * @Title: MathsUtil.java
 * @Description: 数学公式处理
 * @Copyright:  2016 minigod
 * @Company: minigod
 *
 * @author
 * @date 2015-3-16 下午9:30:44
 * @version v1.0
 */

public class MathsUtil {

	/**
	 * 求最大公约数
	 * @param array 自然数
	 * @return
	 */
	public static int divisor(Integer[] array) {
		if (array == null || array.length == 0) {
			throw new MiniGodException("parameter array handler.");
		}
		int min = array[0];

		for (int i = 0; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			}
		}

		while (min >= 1) {
			boolean isCommon = true;
			for (int i = 0; i < array.length; i++) {
				Integer arry = array[i];
				if (arry == null) {
					throw new MiniGodException("parameter array handler.");
				}
				if (arry % min != 0) {
					isCommon = false;
					break;
				}
			}
			if (isCommon) {
				break;
			}
			min--;
		}
		return min;
	}
}
