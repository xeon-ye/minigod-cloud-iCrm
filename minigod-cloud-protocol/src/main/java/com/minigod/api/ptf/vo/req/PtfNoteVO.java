/*
 * FileName: PtfNoteVO.java
 * Copyright: Copyright 2014-12-4 MiniGod Tech. Co. Ltd.All right reserved.
 * Description: 
 *
 */
package com.minigod.api.ptf.vo.req;

import com.minigod.api.ptf.vo.enums.EPtfNoteType;
import com.minigod.api.vo.BaseVO;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * 
 * @description 投资圈请求类
 *
 * @author MiniGod
 * @date 2015-4-8 下午3:55:30
 * @version v1.0
 */
@TransferBean
public class PtfNoteVO extends BaseVO{
	/**  */
	private static final long serialVersionUID = 1971793878074090369L;

	@TransferID
	private Long userId; // 查看观点对应的用户Id
	private EPtfNoteType uType; // 观点类型
	@TransferID
	private Long ptfId; // 组合ID
	private Integer action; // 拉取方式
	private Integer count; // 拉取数量
	private Integer noteId; // 从这个帖子开始拉取
	private String assetId;

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public EPtfNoteType getuType() {
		return uType;
	}
	public void setuType(EPtfNoteType uType) {
		this.uType = uType;
	}
	public Long getPtfId() {
		return ptfId;
	}
	public void setPtfId(Long ptfId) {
		this.ptfId = ptfId;
	}
	public Integer getAction() {
		return action;
	}
	public void setAction(Integer action) {
		this.action = action;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getNoteId() {
		return noteId;
	}
	public void setNoteId(Integer noteId) {
		this.noteId = noteId;
	}
}
