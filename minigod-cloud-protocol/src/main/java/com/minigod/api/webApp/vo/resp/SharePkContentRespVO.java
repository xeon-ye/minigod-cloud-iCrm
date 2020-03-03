/**
 * @Title: SharePkContentRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.resp;

import java.io.Serializable;
import java.util.List;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-8-3 上午11:28:46
 * @version v1.0
 */

public class SharePkContentRespVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String pageType;
	private String ptfName;
	private String uImg;
	private String uName;
	private String pkStatus;
	private Double ptfYield;
	private Double sPrice;
	private Double sYield;
	private Integer[] pkResult;
	private Double cYield;
	private List<String> gift;
	public String getPageType() {
		return pageType;
	}
	public void setPageType(String pageType) {
		this.pageType = pageType;
	}
	public String getPtfName() {
		return ptfName;
	}
	public void setPtfName(String ptfName) {
		this.ptfName = ptfName;
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
	public String getPkStatus() {
		return pkStatus;
	}
	public void setPkStatus(String pkStatus) {
		this.pkStatus = pkStatus;
	}
	public Double getPtfYield() {
		return ptfYield;
	}
	public void setPtfYield(Double ptfYield) {
		this.ptfYield = ptfYield;
	}
	public Double getsYield() {
		return sYield;
	}
	public void setsYield(Double sYield) {
		this.sYield = sYield;
	}
	public Integer[] getPkResult() {
		return pkResult;
	}
	public void setPkResult(Integer[] pkResult) {
		this.pkResult = pkResult;
	}
	public Double getcYield() {
		return cYield;
	}
	public void setcYield(Double cYield) {
		this.cYield = cYield;
	}
	public List<String> getGift() {
		return gift;
	}
	public void setGift(List<String> gift) {
		this.gift = gift;
	}
	public Double getsPrice() {
		return sPrice;
	}
	public void setsPrice(Double sPrice) {
		this.sPrice = sPrice;
	}
}
