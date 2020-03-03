/**
 * @Title: AdviserViewpointDetailRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.resp;

import java.io.Serializable;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-11-5 上午10:03:08
 * @version v1.0
 */

public class AdviserViewpointDetailRespVO implements Serializable{
	private static final long serialVersionUID = 1L;

	private String title;
	private String content;
	private Long viewpointTs;
	private Long readNum;
	private Integer isSelection;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getViewpointTs() {
		return viewpointTs;
	}
	public void setViewpointTs(Long viewpointTs) {
		this.viewpointTs = viewpointTs;
	}
	public Long getReadNum() {
		return readNum;
	}
	public void setReadNum(Long readNum) {
		this.readNum = readNum;
	}
	public Integer getIsSelection() {
		return isSelection;
	}
	public void setIsSelection(Integer isSelection) {
		this.isSelection = isSelection;
	}
}
