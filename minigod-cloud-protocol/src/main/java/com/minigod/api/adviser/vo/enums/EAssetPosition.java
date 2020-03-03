package com.minigod.api.adviser.vo.enums;

/**
 * <code>EAssetPosition</code> 股票仓位
 *
 * @author panlz
 * @date 2015-11-3 下午8:18:09
 * @version v1.0
 */
public enum EAssetPosition {
	EMPTY("空仓", "E"),
	LIGHT("轻仓", "L"),
	MIDDLE("半仓", "M"),
	HEAVY("重仓", "H"),
	FULL("全仓", "F"); 

	private String typeName;
	private String typeValue;

	private EAssetPosition(String typeName, String typeValue) {
		this.typeName = typeName;
		this.typeValue = typeValue;
	}

	public String getTypeValue() {
		return this.typeValue;
	}

	public static String getTypeValue(EAssetPosition index) {
		return index.getTypeValue();
	}

	public static String getDisplayName(String value) {
		for (EAssetPosition c : EAssetPosition.values()) {
			if (c.getTypeValue().equals(value)) {
				return c.typeName;
			}
		}
		return null;
	}

}
