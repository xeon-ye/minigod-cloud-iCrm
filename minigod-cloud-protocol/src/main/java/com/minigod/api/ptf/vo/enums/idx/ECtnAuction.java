/**
 * @Title: ECtnAuction.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.enums.idx;

/**
 * @description  
 *
 * @author Jimmy
 * @date 2015-3-30 上午9:13:39
 * @version v1.0
 */

public enum ECtnAuction {
	IS ("1"), // 是集合竞价的时间
	NO("0"); // 不是
	
	private String isCtnAuction;

	private ECtnAuction(String isCtnAuction) {
		this.isCtnAuction = isCtnAuction;
	}

	public String getVal() {
		return isCtnAuction;
	}

	public void setVal(String isCtnAuction) {
		this.isCtnAuction = isCtnAuction;
	}
	
}
