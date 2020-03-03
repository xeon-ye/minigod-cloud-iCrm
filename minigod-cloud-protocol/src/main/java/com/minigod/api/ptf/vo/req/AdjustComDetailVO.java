/*******************************************************************************
 * Copyright (c) 2016 minigod minigod.Co.Ltd. All rights reserved.
 ******************************************************************************/

package com.minigod.api.ptf.vo.req;

import com.minigod.api.vo.BaseVO;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;

/**
 * 
 * @description 调仓描述
 *
 * @author MiniGod
 * @date 2015-4-7 下午4:23:21
 * @version v1.0
 */
@TransferBean
public class AdjustComDetailVO extends BaseVO {

	private static final long serialVersionUID = 1L;
	
	private String isReal; // 是否实盘
	private Integer ptfTransId; // 组合交易ID
	@Emoji
	private String comment; // 调整说明
	private String[] groupIds;// 群分享列表
	
	public String getIsReal() {
		return isReal;
	}
	public void setIsReal(String isReal) {
		this.isReal = isReal;
	}
	public Integer getPtfTransId() {
		return ptfTransId;
	}
	public void setPtfTransId(Integer ptfTransId) {
		this.ptfTransId = ptfTransId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String[] getGroupIds() {
		return groupIds;
	}
	public void setGroupIds(String[] groupIds) {
		this.groupIds = groupIds;
	}
	
	
}
