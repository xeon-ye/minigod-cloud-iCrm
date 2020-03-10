package com.minigod.protocol.account.cubp.vo.request;

import java.io.Serializable;


/**
 * 财产种类
 */
public class CubpOpenAccountPropertyTypeReqVo implements Serializable {

	private static final long serialVersionUID = 1L;
	//财产种类
	private Integer propertyType;
	//财产金额
	private String propertyAmount;

	/**
	 * 设置：财产种类
	 */
	public void setPropertyType(Integer propertyType) {
		this.propertyType = propertyType;
	}
	/**
	 * 获取：财产种类
	 */
	public Integer getPropertyType() {
		return propertyType;
	}
	/**
	 * 设置：财产金额
	 */
	public void setPropertyAmount(String propertyAmount) {
		this.propertyAmount = propertyAmount;
	}
	/**
	 * 获取：财产金额
	 */
	public String getPropertyAmount() {
		return propertyAmount;
	}

}
