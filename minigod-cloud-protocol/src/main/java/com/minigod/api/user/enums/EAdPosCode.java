/**
 * @Title: EAdLinkGroupType.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.user.enums;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-6-15 下午12:19:15
 * @version v1.0
 */

public enum EAdPosCode {
	CUSTOM("自定义广告", 1000),
	PTFNOTE("投顾广场", 1001),
	INDEXPUSH("弹屏广告页", 1002),
	ADVISERPLATFORM("投顾工作后台", 1003),
	FINANCIAL("理财版本", 1005),
	STARTUP("启动广告页", 1006),
	INDEXAD("首页广告页", 1007),
	FRIENDAD("推荐股友广告页", 1008),
	BROKERAD("经理人广告页", 1009);

	private String typeName;
	private Integer typeValue;

	private EAdPosCode(String typeName, Integer typeValue) {
		this.typeName = typeName;
		this.typeValue = typeValue;
	}
	
	public Integer getTypeValue() {
		return this.typeValue;
	}
	
	public static String getTypeName(Integer index) {
		for (EAdPosCode eAdPosCode : EAdPosCode.values()) {
			if (eAdPosCode.getTypeValue().equals(index)) {
				return eAdPosCode.typeName;
			}
		}
		return null;
	}
	
	public static Integer getTypeValue(Integer index) {
		for (EAdPosCode eAdPosCode : EAdPosCode.values()) {
			if (eAdPosCode.getTypeValue().equals(index)) {
				return eAdPosCode.getTypeValue();
			}
		}
		return null;
	}
}
