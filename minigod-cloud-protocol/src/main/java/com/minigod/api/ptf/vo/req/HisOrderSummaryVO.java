/*******************************************************************************
 * Copyright (c) 2016 minigod minigod.Co.Ltd. All rights reserved.
 ******************************************************************************/

package com.minigod.api.ptf.vo.req;

import com.minigod.api.vo.BaseVO;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description 交易历史查询请求类
 * 
 * @author minigod
 * @date 2015-3-10 上午9:19:34
 * @version v2.0
 */
@TransferBean
public class HisOrderSummaryVO extends BaseVO {

	private static final long serialVersionUID = 1L;

	@TransferID
	private Long ptfId;

	private Integer brkId; // 券商ID

	private String custId; // 券商端的客户编号

	private Integer reqNum; // 请求的记录数

	private Integer pos; // 当前记录读到哪里

	private Integer pullMode; // 拉取方式

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

	public Integer getReqNum() {
		return reqNum;
	}

	public void setReqNum(Integer reqNum) {
		this.reqNum = reqNum;
	}

	public Integer getPos() {
		return pos;
	}

	public void setPos(Integer pos) {
		this.pos = pos;
	}

	public Integer getPullMode() {
		return pullMode;
	}

	public void setPullMode(Integer pullMode) {
		this.pullMode = pullMode;
	}

	public Long getPtfId() {
		return ptfId;
	}

	public void setPtfId(Long ptfId) {
		this.ptfId = ptfId;
	}

}
