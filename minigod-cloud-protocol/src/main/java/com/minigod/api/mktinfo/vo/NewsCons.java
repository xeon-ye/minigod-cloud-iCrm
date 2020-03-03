package com.minigod.api.mktinfo.vo;

import java.text.NumberFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;


public class NewsCons {
	public static double DEGREE = 0.9;
	public static int TITLE_WIDTH = 246;
	public static int TITLE_HEIGHT = 180;
	public static int HEAD_WIDTH = 1242;
	public static int HEAD_HEIGHT = 600;
	
	static final Map<Integer,String> newsbusimap = new HashMap<Integer,String>();
	public static enum NewsBusi {
		_FT(1,"富途证券"), 
		_QS(2,"青石证券"), 
		_LH(3,"老虎证劵"),
		_SKT(4,"史考特"),
		_DYZJ(5,"第一证卷"),
		_MBJR(6,"美豹金融"),
		_MMZJ(7,"米盟证券"),
		_XY(8,"雪盈证券"),
		_XQ(9,"雪球");
		private NewsBusi(int val,String desc) {
			newsbusimap.put(val,desc);
		}
		
		public static final boolean isNewsbusi(String newsTitle) {
			if (StringUtils.isEmpty(newsTitle)) {
				return false;
			}
			Collection<String> newsbusi = newsbusimap.values();
			for (Iterator<String> newsbusiinterator = newsbusi.iterator(); 
					newsbusiinterator.hasNext();) {
				if (newsTitle.indexOf(newsbusiinterator.next()) != -1) {
					return true;
				}
			}
			return false;
		}
	}
	
	/** 
	* 相似度转百分比 
	*/
	public static String similarityResult(double resule) {

		return NumberFormat.getPercentInstance(new Locale("en ", "US "))
				.format(resule);

	}

	/**
	 * 相似度比较
	 * 
	 * @param strA
	 * @param strB
	 * @return
	 */
	public static double SimilarDegree(String strA, String strB) {

		String newStrA = removeSign(strA);

		String newStrB = removeSign(strB);

		int temp = Math.max(newStrA.length(), newStrB.length());

		int temp2 = longestCommonSubstring(newStrA, newStrB).length();

		return temp2 * 1.0 / temp;

	}

	private static String removeSign(String str) {

		StringBuffer sb = new StringBuffer();

		for (char item : str.toCharArray())

			if (charReg(item)) {

				// System.out.println("--"+item);

				sb.append(item);

			}

		return sb.toString();

	}

	private static boolean charReg(char charValue) {

		return (charValue >= 0x4E00 && charValue <= 0X9FA5)

		|| (charValue >= 'a' && charValue <= 'z')

		|| (charValue >= 'A' && charValue <= 'Z')

		|| (charValue >= '0' && charValue <= '9');

	}

	private static String longestCommonSubstring(String strA, String strB) {

		char[] chars_strA = strA.toCharArray();

		char[] chars_strB = strB.toCharArray();

		int m = chars_strA.length;

		int n = chars_strB.length;

		int[][] matrix = new int[m + 1][n + 1];

		for (int i = 1; i <= m; i++) {

			for (int j = 1; j <= n; j++) {

				if (chars_strA[i - 1] == chars_strB[j - 1])

					matrix[i][j] = matrix[i - 1][j - 1] + 1;

				else

					matrix[i][j] = Math.max(matrix[i][j - 1], matrix[i - 1][j]);

			}

		}

		char[] result = new char[matrix[m][n]];

		int currentIndex = result.length - 1;

		while (matrix[m][n] != 0) {

			if (matrix[m][n] == matrix[m][n - 1])

				n--;

			else if (matrix[m][n] == matrix[m - 1][n])

				m--;

			else {

				result[currentIndex] = chars_strA[m - 1];

				currentIndex--;

				n--;

				m--;

			}
		}

		return new String(result);

	}
}
