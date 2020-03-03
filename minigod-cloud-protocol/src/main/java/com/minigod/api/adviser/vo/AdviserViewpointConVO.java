/**
 * @Title: AdviserViewpointConVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.adviser.vo;

import java.io.Serializable;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-10-31 下午4:43:48
 * @version v1.0
 */

public class AdviserViewpointConVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String title;
	private String firstImg;
	private String summary;
	private String content;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirstImg() {
		return firstImg;
	}
	public void setFirstImg(String firstImg) {
		this.firstImg = firstImg;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
