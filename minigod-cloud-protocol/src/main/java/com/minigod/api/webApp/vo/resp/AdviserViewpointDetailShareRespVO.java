/**
 * @Title: AdviserViewpointDetailRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.resp;

import java.io.Serializable;

import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-11-5 上午10:03:08
 * @version v1.0
 */

@TransferBean
public class AdviserViewpointDetailShareRespVO implements Serializable{
	private static final long serialVersionUID = 1L;

	@TransferID
	private String uId;
	private String uImg;
	private String uName;
	private String adviserType;
	private String adviserOrg;
	private String[] adviserField;
	private String title;
	private String content;
	private Long viewpointTs;
	private Long readNum;
	private Integer isSelection;
	private Integer likeNum;
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
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
	public String getAdviserType() {
		return adviserType;
	}
	public void setAdviserType(String adviserType) {
		this.adviserType = adviserType;
	}
	public String getAdviserOrg() {
		return adviserOrg;
	}
	public void setAdviserOrg(String adviserOrg) {
		this.adviserOrg = adviserOrg;
	}
	public String[] getAdviserField() {
		return adviserField;
	}
	public void setAdviserField(String[] adviserField) {
		this.adviserField = adviserField;
	}
	public Integer getLikeNum() {
		return likeNum;
	}
	public void setLikeNum(Integer likeNum) {
		this.likeNum = likeNum;
	}
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
