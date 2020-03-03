package com.minigod.api.mktmgr.vo.req;

import com.minigod.api.vo.BaseVO;



public class OrderMktReqVO extends BaseVO {
	private static final long serialVersionUID = 1L;

	private Long userId;//
	private String pCode;//产品套餐标识
	private String loginFrom;//来源平台
	private String loginIp;//登录IP
	private String orderWay;//产品购买方式
	private Integer orderNum = 1;
	private Double realAmount = 0.00;
	private String remark;
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getpCode() {
		return pCode;
	}
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}
	public String getLoginFrom() {
		return loginFrom;
	}
	public void setLoginFrom(String loginFrom) {
		this.loginFrom = loginFrom;
	}
	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	public String getOrderWay() {
		return orderWay;
	}
	public void setOrderWay(String orderWay) {
		this.orderWay = orderWay;
	}
	public Double getRealAmount() {
		return realAmount;
	}
	public void setRealAmount(Double realAmount) {
		this.realAmount = realAmount;
	}
	
}
