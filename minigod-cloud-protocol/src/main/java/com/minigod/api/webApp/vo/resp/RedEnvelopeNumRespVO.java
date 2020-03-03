/**
 * @Title: NiuLimitNumReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.resp;

import java.io.Serializable;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-6-17 下午6:14:52
 * @version v1.0
 */

public class RedEnvelopeNumRespVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer status;
	private Integer count;
	private Integer fdNum;
	private Integer adId;
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getFdNum() {
		return fdNum;
	}
	public void setFdNum(Integer fdNum) {
		this.fdNum = fdNum;
	}
	public Integer getAdId() {
		return adId;
	}
	public void setAdId(Integer adId) {
		this.adId = adId;
	}
}
