/**
 * @Title: ETransType.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.enums.simu_ptf_trans;

/**
 * @description 模拟组合成交结束状态枚举类
 *
 * @author minigod
 * @date 2015-3-13 下午2:59:02
 * @version v1.0
 */

public enum ESimuPtfFinishStatus {
	NOT_FINISH("未结束", "N"), //
	FINISH("已结束", "Y"); //

	private String typeName;
	private String typeValue;

	private ESimuPtfFinishStatus(String typeName, String typeValue) {
		this.typeName = typeName;
		this.typeValue = typeValue;
	}
	
	public String getTypeName() {
		return this.typeName;
	}
	
	public String getTypeValue() {
		return this.typeValue;
	}
	
}
