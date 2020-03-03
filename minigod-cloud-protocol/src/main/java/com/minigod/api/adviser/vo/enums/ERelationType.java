/**
 * @Title: ERelationType.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.adviser.vo.enums;

/**
 * @description
 * 
 * @author panlz
 * @date 2015-10-30 下午4:56:47
 * @version v1.0
 */

public enum ERelationType {
	F("我的好友"), C("我的粉丝"), A("我关注的自媒体");

	private String typeName;

	private ERelationType(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public boolean equals(String str) {
		return this.toString().equals(str);
	}

	/**
	 * 取对方视角中的关系，投顾--客户，好友--好友
	 * 
	 * @return
	 */
	public ERelationType toReverse() {
		if (this == ERelationType.F) {
			return this;
		} else if (this == ERelationType.A) {
			return ERelationType.C;
		} else {
			return ERelationType.A;
		}
	}
}
