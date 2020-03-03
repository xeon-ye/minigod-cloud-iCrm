/**
 * @Title: AdAdviserWeekWinRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.resp;

import java.io.Serializable;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-11-30 下午3:33:10
 * @version v1.0
 */

public class AdAdviserWeekWinRespVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer status;
	private String userName;
	private Integer questionFlag;
	private Integer viewpointFlag;
	private Integer imMsgFlag;
	private Integer transFlag;
	private Integer investFlag;
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getQuestionFlag() {
		return questionFlag;
	}
	public void setQuestionFlag(Integer questionFlag) {
		this.questionFlag = questionFlag;
	}
	public Integer getViewpointFlag() {
		return viewpointFlag;
	}
	public void setViewpointFlag(Integer viewpointFlag) {
		this.viewpointFlag = viewpointFlag;
	}
	public Integer getImMsgFlag() {
		return imMsgFlag;
	}
	public void setImMsgFlag(Integer imMsgFlag) {
		this.imMsgFlag = imMsgFlag;
	}
	public Integer getTransFlag() {
		return transFlag;
	}
	public void setTransFlag(Integer transFlag) {
		this.transFlag = transFlag;
	}
	public Integer getInvestFlag() {
		return investFlag;
	}
	public void setInvestFlag(Integer investFlag) {
		this.investFlag = investFlag;
	}
}
