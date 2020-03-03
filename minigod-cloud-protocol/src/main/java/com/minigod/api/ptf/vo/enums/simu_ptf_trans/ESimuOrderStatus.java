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

public enum ESimuOrderStatus {
	TO_BE_DEAL("待成交", "0"), //
	PART_DEAL("部分成交", "1"), //
	ALL_DEAL("全部成交", "2"),
	PART_CANCEL("部分撤销", "3"),
	ALL_CANCEL("全部撤销", "4"),
	FAILED("提交失败", "5"); //

	private String typeName;
	private String typeValue;

	private ESimuOrderStatus(String typeName, String typeValue) {
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
