/**
 * @Title: ViewpointUserCommentVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.adviser.vo.response;

import java.io.Serializable;

import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-11-3 下午2:23:46
 * @version v1.0
 */

@TransferBean
public class ViewpointUserCommentVO implements Serializable{
	private static final long serialVersionUID = 1L;

	@TransferID
	private Long uId;
	private String uImg;
	@Emoji
	private String uName;
	private Integer uType;
	private String relationType;
	private Integer isEnterHome;
	private Integer isHighlight;
	public Integer getIsHighlight() {
		return isHighlight;
	}
	public void setIsHighlight(Integer isHighlight) {
		this.isHighlight = isHighlight;
	}
	public Integer getIsEnterHome() {
		return isEnterHome;
	}
	public void setIsEnterHome(Integer isEnterHome) {
		this.isEnterHome = isEnterHome;
	}
	public Long getuId() {
		return uId;
	}
	public void setuId(Long uId) {
		this.uId = uId;
	}
	public String getuImg() {
		return uImg;
	}
	public void setuImg(String uImg) {
		this.uImg = uImg;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public Integer getuType() {
		return uType;
	}
	public void setuType(Integer uType) {
		this.uType = uType;
	}
	public String getRelationType() {
		return relationType;
	}
	public void setRelationType(String relationType) {
		this.relationType = relationType;
	} 
}
