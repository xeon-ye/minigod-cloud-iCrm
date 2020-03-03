/**
 * @Title: AdviserViewpointVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.adviser.vo.request;

import com.minigod.api.vo.BaseVO;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-10-30 下午4:22:32
 * @version v1.0
 */
@TransferBean
public class AdviserViewpointVO extends BaseVO{
	private static final long serialVersionUID = 1L;
	
	private String viewpointType;
	@Emoji
	private String title;
	@Emoji
	private String summary;
	private String firstImg;
	@Emoji
	private String content;
	
	public String getViewpointType() {
		return viewpointType;
	}
	public void setViewpointType(String viewpointType) {
		this.viewpointType = viewpointType;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getFirstImg() {
		return firstImg;
	}
	public void setFirstImg(String firstImg) {
		this.firstImg = firstImg;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
