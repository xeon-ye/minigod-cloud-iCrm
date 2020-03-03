package com.minigod.api.ptf.vo.resp;

import java.io.Serializable;

/**
 * @Title: PtfUpdateNotifyVO.java
 * @Description: 跟单组合通知返回VO类
 * @Copyright: © 2014 minigod
 * @Company: minigod
 *
 * @author panlz
 * @date 2015-03-16 上午11:33:48
 * @version v1.0
 */

public class PtfUpdateDetailVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String desc; // 用户头像地址
	private Long updTs; // 更新时间
	private String tType; // 交易类型
	private Long noteId;
	
	public Long getNoteId() {
		return noteId;
	}

	public void setNoteId(Long noteId) {
		this.noteId = noteId;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Long getUpdTs() {
		return updTs;
	}

	public void setUpdTs(Long updTs) {
		this.updTs = updTs;
	}

	public String gettType() {
		return tType;
	}

	public void settType(String tType) {
		this.tType = tType;
	}
	
}
