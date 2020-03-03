/*******************************************************************************
 * Copyright (c) 2016 minigod minigod.Co.Ltd. All rights reserved.
 ******************************************************************************/

package com.minigod.api.ptf.vo.req;

import com.minigod.api.vo.BaseVO;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description 委托概要查询请求类
 *
 * @author minigod
 * @date 2015-3-10 上午9:19:34
 * @version v2.0
 */
@TransferBean
public class OrderSummaryVO extends BaseVO {

	private static final long serialVersionUID = 1L;
	
	@TransferID
    private Long ptfId;
	
    private Integer brkId; // 券商ID
	
	private String custId; // 券商端的客户编号

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

	public Long getPtfId() {
		return ptfId;
	}

	public void setPtfId(Long ptfId) {
		this.ptfId = ptfId;
	}
	
	
}
