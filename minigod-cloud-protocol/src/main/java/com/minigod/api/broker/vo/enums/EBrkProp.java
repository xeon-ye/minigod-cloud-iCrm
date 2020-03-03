/**
 * @Title: EBrkProp.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.broker.vo.enums;

/**
 * @description 
 *
 * @author Jimmy
 * @date 2015-3-21 下午3:24:23
 * @version v1.0
 */

public enum EBrkProp {
	OB("0B", "证券买入"),
	OS("0S", "证券卖出"),
	oa("0a", "对方买入"),
	ob("0b", "本方买入"),
	oc("0c", "即时买入"),
	od("0d", "五档买入"),
	oe("0e", "全额买入"),
	og("0g", "本方卖出"),
	oh("0h", "即时卖出"),
	oi("0i", "五档卖出"),
	oj("0j", "全额卖出"),
	oq("0q", "转限买入"),
	or("0r", "转限卖出");
	
	private String typeName;
	private String typeValue;

	private EBrkProp(String typeName, String typeValue) {
		this.typeName = typeName;
		this.typeValue = typeValue;
	}

	public String getTypeValue() {
		return this.typeValue;
	}

	public String getTypeName() {
		return this.typeName;
	}
}
