/**
 * @Title: ETransType.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.enums.simu_ptf_trans;

/**
 * @description 
 *
 * @author minigod
 * @date 2015-3-13 下午2:59:02
 * @version v1.0
 */

public enum ESimuConfirmStatus {
	NO_DEAL("未成交", "N"), //
	ALL_DEAL("全部成交", "S"),
	PART_DEAL("部分成交", "P"); //

	private String typeName;
	private String typeValue;

	private ESimuConfirmStatus(String typeName, String typeValue) {
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
