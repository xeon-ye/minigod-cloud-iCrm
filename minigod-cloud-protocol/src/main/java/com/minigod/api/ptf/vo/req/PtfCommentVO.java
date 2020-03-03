package com.minigod.api.ptf.vo.req;

import java.io.Serializable;

import com.minigod.api.vo.BaseVO;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @Title: PtfComment.java
 * @Description: 组合变更笔记值对象
 * @Copyright: © 2014 minigod
 * @Company: minigod
 *
 * @author minigod
 * @date 2014-11-7 下午3:45:23
 * @version v1.0
 */
@TransferBean
public class PtfCommentVO extends BaseVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@TransferID
	private Long ptfId; // 组合id
	
	private Integer eventId; // 时间id
	
	private String comment; // 本次调整的描述

	public Long getPtfId() {
		return ptfId;
	}

	public void setPtfId(Long ptfId) {
		this.ptfId = ptfId;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
