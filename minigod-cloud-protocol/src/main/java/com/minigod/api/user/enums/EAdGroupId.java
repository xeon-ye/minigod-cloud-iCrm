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

public enum EAdGroupId {
	All("全站用户", 0),
	DESIGNATE("指定用户", 1);

	private String typeName;
	private Integer typeValue;

	private EAdGroupId(String typeName, Integer typeValue) {
		this.typeName = typeName;
		this.typeValue = typeValue;
	}
	
	public Integer getTypeValue() {
		return this.typeValue;
	}
	
	public static String getTypeName(Integer index) {
		for (EAdGroupId eAdGroupId : EAdGroupId.values()) {
			if (eAdGroupId.getTypeValue().equals(index)) {
				return eAdGroupId.typeName;
			}
		}
		return null;
	}
	
	public static Integer getTypeValue(Integer index) {
		for (EAdGroupId eAdGroupId : EAdGroupId.values()) {
			if (eAdGroupId.getTypeValue().equals(index)) {
				return eAdGroupId.getTypeValue();
			}
		}
		return null;
	}
}
