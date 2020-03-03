package com.minigod.api.ptf.vo.resp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


public class GetOrderGenerateInfoRespVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String ptfName;//组合名	String	
	private String targetTimeDesc;//目标收益时间限制描述	String	
	private String priceType;//价格类型	String	N:正价 S:优惠价格 客户可享受的价格类型
	private BigDecimal price;//价格	String	订单价格
	private BigDecimal salePrice;//促销价格
	private BigDecimal vipPrice;//VIP价格
	private BigDecimal targetYield;//目标收益率	String	
	private Date beginDate;//服务开始日期	Int64	
	private Date endDate;//服务结束日期	Int64
	private String saleDesc;
	

	public String getSaleDesc() {
		return saleDesc;
	}
	public void setSaleDesc(String saleDesc) {
		this.saleDesc = saleDesc;
	}
	public BigDecimal getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}
	public String getPtfName() {
		return ptfName;
	}
	public void setPtfName(String ptfName) {
		this.ptfName = ptfName;
	}
	public String getTargetTimeDesc() {
		return targetTimeDesc;
	}
	public void setTargetTimeDesc(String targetTimeDesc) {
		this.targetTimeDesc = targetTimeDesc;
	}

	public String getPriceType() {
		return priceType;
	}
	public void setPriceType(String priceType) {
		this.priceType = priceType;
	}

	
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getTargetYield() {
		return targetYield;
	}
	public void setTargetYield(BigDecimal targetYield) {
		this.targetYield = targetYield;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public BigDecimal getVipPrice() {
		return vipPrice;
	}
	public void setVipPrice(BigDecimal vipPrice) {
		this.vipPrice = vipPrice;
	}
}
