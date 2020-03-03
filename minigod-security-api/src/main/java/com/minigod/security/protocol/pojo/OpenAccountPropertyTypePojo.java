package com.minigod.security.protocol.pojo;

import java.io.Serializable;


/**
 * 财产种类表
 * 
 * @author PENGFENG
 * @email 
 * @date 2018-09-28 14:10:22
 */
public class OpenAccountPropertyTypePojo implements Serializable {

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
