/**
 * @Title: PKContentRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.resp;

import java.io.Serializable;
import java.util.List;

import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-7-30 下午5:17:02
 * @version v1.0
 */

@TransferBean
public class PKContentRespVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String pageType;
	@TransferID
	private String uId;
	private String uName;
	private String uImg;
	private String ptfName;
	private Double cYield;
	private Integer[] pkResult;
	private Double ptfYield;
	private Double sPrice;
	private Double sYield;
	private String pkStatus;
	private String cardNum;
	private String goldNum;
	private List<String> gift;
	private String time;
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public Double getcYield() {
		return cYield;
	}
	public void setcYield(Double cYield) {
		this.cYield = cYield;
	}
	public String getPkStatus() {
		return pkStatus;
	}
	public void setPkStatus(String pkStatus) {
		this.pkStatus = pkStatus;
	}
	public String getPageType() {
		return pageType;
	}
	public void setPageType(String pageType) {
		this.pageType = pageType;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuImg() {
		return uImg;
	}
	public void setuImg(String uImg) {
		this.uImg = uImg;
	}
	public String getPtfName() {
		return ptfName;
	}
	public void setPtfName(String ptfName) {
		this.ptfName = ptfName;
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
	
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public String getGoldNum() {
		return goldNum;
	}
	public void setGoldNum(String goldNum) {
		this.goldNum = goldNum;
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
