/**
 * @Title: ETransType.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.enums.real_ptf_trans;

/**
 * @description 模拟组合成交结束状态枚举类
 *
 * @author minigod
 * @date 2015-3-13 下午2:59:02
 * @version v1.0
 */

public enum ERealPtfFinishStatus {
	N("未结束"), //
	Y("已结束"); //

	private String typeName;

	private ERealPtfFinishStatus(String typeName) {
		this.typeName = typeName;
	}
	
	public String getTypeName() {
		return this.typeName;
	}
	
}
