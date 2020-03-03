/*******************************************************************************
 * Copyright (c) 2016 minigod minigod.Co.Ltd. All rights reserved.
 ******************************************************************************/

package com.minigod.api.ptf.vo.req;

import java.io.Serializable;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2016-2-25 下午2:34:32
 * @version v1.0
 */

public class BrokerAcc implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer brkId;// 券商ID
	private String custId;// 客户ID

	public Integer getBrkId() {
		return brkId;
	}

	public void setBrkId(Integer brkId) {
		this.brkId = brkId;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

}
