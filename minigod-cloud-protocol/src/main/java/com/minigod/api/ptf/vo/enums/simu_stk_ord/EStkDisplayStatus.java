/**
 * @Title: SimuBusType.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.enums.simu_stk_ord;

/**
 * @description 委托展示状态枚举类
 * 
 * @author minigod
 * @date 2015-3-13 下午5:25:47
 * @version v1.0
 */

public enum EStkDisplayStatus {
	A("待成交"), //
	B("部分成交"), //
	C("全部成交"), //
	D("部分撤销"), //
	E("全部撤销"), //
	F("委托失败"), //
	G("发送异常"), //
	H("未成交"), //
	I("撤单中");//

	private String typeName;

	private EStkDisplayStatus(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeName() {
		return this.typeName;
	}
}
