/*
 * FileName: SaveDiaryVO.java
 * Copyright: Copyright 2014-12-3 MiniGod Tech. Co. Ltd.All right reserved.
 * Description: 
 *
 */
package com.minigod.api.ptf.vo.req;

import com.minigod.api.vo.BaseVO;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;
/**
 * <code>SaveDiaryVO<code>
 *
 * @author Jimmy
 * @since  MiniGod v0.0.1 (2014-12-3)
 *
 */
@TransferBean
public class WriteNoteVO extends BaseVO{
	/**  */
	private static final long serialVersionUID = -8915667311246250661L;
	
	@Emoji
	private String content; // 内容
	@TransferID
	private Long ptfId;
	private String[] urls; //  图片的URL
	private String noteType; // 帖子类型 N-资讯分享
	private String busCon; // json串
	
	public String getNoteType() {
		return noteType;
	}
	public void setNoteType(String noteType) {
		this.noteType = noteType;
	}
	public String getBusCon() {
		return busCon;
	}
	public void setBusCon(String busCon) {
		this.busCon = busCon;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getPtfId() {
		return ptfId;
	}
	public void setPtfId(Long ptfId) {
		this.ptfId = ptfId;
	}
	public String[] getUrls() {
		return urls;
	}
	public void setUrls(String[] urls) {
		this.urls = urls;
	}
}
