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

public enum ESimuPtfTransType {
	CREATE("创建", "C"), //
	BUY("买入", "B"), //
	SALE("卖出", "S"),
	REBALANCE("调仓", "R"),
	DIVIDEND("分红", "D"),
	WITHDRAW("撤单", "W"); //

	private String typeName;
	private String typeValue;

	private ESimuPtfTransType(String typeName, String typeValue) {
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
