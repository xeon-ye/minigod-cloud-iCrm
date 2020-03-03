/**
 * @Title: ERedisChannelAction.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.enums;

/**
 * @description 市场状态
 *
 * @author 余俊斌
 * @date 2016年1月12日 下午2:33:47
 * @version v1.0
 */
public enum EMarketStatus {
	
	/**
	 * 未知状态
	 */
	UNKNOWN(null),
	/**
	 * 开市前
	 */
	PREOPEN("S"),
	/**
	 * 等待开市
	 */
	WAITING("W"),
	/**
	 * 交易期间（含中间休市）
	 */
	TRADING("T"),
	/**
	 * 熔断状态 - 可恢复
	 */
	RECOVERABLLY_FUSED("M"),
	/**
	 * 熔断状态 - 不可恢复
	 */
	UNRECOVERABLLY_FUSED("N"),
	/**
	 * 闭市期间
	 */
	CLOSED("E"),
	;
	
	private String shValue;
	
	private EMarketStatus(String shVal) {
		this.shValue = shVal;
	}
	
	public String shValue() {
		return this.shValue;
	}
	
	public static EMarketStatus valueOfSh(String shVal) {
		if (shVal == null) {
			return UNKNOWN;
		}
		for (EMarketStatus eMarketStatus : values()) {
			if (shVal.equals(eMarketStatus.shValue)) {
				return eMarketStatus;
			}
		}
		// 找不到则返回null
		return null;
	}
}
