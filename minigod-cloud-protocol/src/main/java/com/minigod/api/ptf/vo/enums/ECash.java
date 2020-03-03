/**
 * @Title: ECash.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.enums;

/**
 * @description 现金枚举类
 * 
 * @author 谢尚河
 * @date 2015-7-29 下午11:01:18
 * @version v1.0
 */

public enum ECash {
	RMB_CHN("人民币", "RMB.CHN");

	private String typeName;
	private String typeValue;

	private ECash(String typeName, String typeValue) {
		this.typeName = typeName;
		this.typeValue = typeValue;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public String getTypeValue() {
		return this.typeValue;
	}

	/**
	 * 检查是否现金
	 * 
	 * @param assetId
	 * @return
	 */
	public static boolean isCash(String assetId) {
		for (ECash cash : ECash.values()) {
			if (cash.getTypeValue().equals(assetId)) {
				return true;
			}
		}
		return false;
	}

}
