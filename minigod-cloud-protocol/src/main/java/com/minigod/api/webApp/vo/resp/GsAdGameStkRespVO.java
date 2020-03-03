/**
 * @Title: GsAdGameStkRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.resp;

import java.io.Serializable;

import com.minigod.common.anno.TransferBean;

/**
 * @description 
 *
 * @author panlz
 * @date 2015-9-11 下午5:17:02
 * @version v1.0
 */

@TransferBean
public class GsAdGameStkRespVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer gameStkId ; //private
	private String stkName ; //股票名称
	private String stkCode ; //股票代码
	private Integer  hasReason ; //是否有推荐理由 0-没有，1-有
	private Double changePct ; //盈亏，涨跌幅
	private String userName ; //荐股人
	private Integer isLike ; //是否点赞了 0-没有，1-有
	private Integer likeCnt ; //点赞数
	private Double tChangePct ; //日涨跌
	private String reason ; //推荐理由
	private Double price ; //最新价
	private Double cfmPrice; // 成交价
	private Integer isPrize; // 是否奖励 0-没有， 1- 有
	public Integer getIsPrize() {
		return isPrize;
	}
	public void setIsPrize(Integer isPrize) {
		this.isPrize = isPrize;
	}
	public Double getCfmPrice() {
		return cfmPrice;
	}
	public void setCfmPrice(Double cfmPrice) {
		this.cfmPrice = cfmPrice;
	}
	public Integer getGameStkId() {
		return gameStkId;
	}
	public void setGameStkId(Integer gameStkId) {
		this.gameStkId = gameStkId;
	}
	public String getStkName() {
		return stkName;
	}
	public void setStkName(String stkName) {
		this.stkName = stkName;
	}
	public String getStkCode() {
		return stkCode;
	}
	public void setStkCode(String stkCode) {
		this.stkCode = stkCode;
	}
	public Integer getHasReason() {
		return hasReason;
	}
	public void setHasReason(Integer hasReason) {
		this.hasReason = hasReason;
	}
	public Double getChangePct() {
		return changePct;
	}
	public void setChangePct(Double changePct) {
		this.changePct = changePct;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getIsLike() {
		return isLike;
	}
	public void setIsLike(Integer isLike) {
		this.isLike = isLike;
	}
	public Integer getLikeCnt() {
		return likeCnt;
	}
	public void setLikeCnt(Integer likeCnt) {
		this.likeCnt = likeCnt;
	}
	
	public Double gettChangePct() {
		return tChangePct;
	}
	public void settChangePct(Double tChangePct) {
		this.tChangePct = tChangePct;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
}
