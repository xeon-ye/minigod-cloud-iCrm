/**
 * @Title: ERegion.java
 * @Copyright: © 2015 sunline
 * @Company: sunline
 */

package com.sunline.modules.common.common;

/**
 * 地区
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-05-18 11:12:43
 */

public enum ERegion {
	ML, // 中国大陆
	HK, // 中国香港
	US // 美股
	;
	
	/**
	 * 判断assetId末尾字符，返回对应的枚举值
	 * 若传入为空，则返回为null
	 * @param assetId
	 * @return
	 */
	public static ERegion recognizeAssetId(String assetId) {
		if (assetId == null) {
			return null;
		}
		if (assetId.endsWith(ERegion.HK.name())) {
			return ERegion.HK;
		} else if (assetId.endsWith(ERegion.US.name())) {
			return ERegion.US;
		}
		return ERegion.ML;
	}
	
}
