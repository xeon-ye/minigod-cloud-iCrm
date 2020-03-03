package com.minigod.security.protocol.pojo;

import java.io.Serializable;


/**
 * 税务信息表
 * 
 * @author PENGFENG
 * @email 
 * @date 2018-09-28 14:10:22
 */
public class OpenAccountTaxationInfoPojo implements Serializable {
	private static final long serialVersionUID = 1L;

	//司法管辖区
	private String taxCountry;
	//税务编号
	private String taxNumber;
	//是否有税务编号[0=否 1=是]
	private Integer hasTaxNumber;
	//理由类型
	private String reasonType;

	//理由描述
	private String reasonDesc;

	/**
	 * 设置：司法管辖区
	 */
	public void setTaxCountry(String taxCountry) {
		this.taxCountry = taxCountry;
	}
	/**
	 * 获取：司法管辖区
	 */
	public String getTaxCountry() {
		return taxCountry;
	}
	/**
	 * 设置：税务编号
	 */
	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}
	/**
	 * 获取：税务编号
	 */
	public String getTaxNumber() {
		return taxNumber;
	}
	/**
	 * 设置：是否有税务编号[0=否 1=是]
	 */
	public void setHasTaxNumber(Integer hasTaxNumber) {
		this.hasTaxNumber = hasTaxNumber;
	}
	/**
	 * 获取：是否有税务编号[0=否 1=是]
	 */
	public Integer getHasTaxNumber() {
		return hasTaxNumber;
	}
	/**
	 * 设置：理由类型
	 */
	public void setReasonType(String reasonType) {
		this.reasonType = reasonType;
	}
	/**
	 * 获取：理由类型
	 */
	public String getReasonType() {
		return reasonType;
	}
    /**
     * 获取：理由描述
     */
    public String getReasonDesc() {
        return reasonDesc;
    }
    /**
     * 设置：理由描述
     */
    public void setReasonDesc(String reasonDesc) {
        this.reasonDesc = reasonDesc;
    }
}
