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

public enum ESimuWithDrawStatus {
	NO_WITHDRAW("未撤单", "N"), //
	WITHDRAWED("已撤单", "Y"); //

	private String typeName;
	private String typeValue;

	private ESimuWithDrawStatus(String typeName, String typeValue) {
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
