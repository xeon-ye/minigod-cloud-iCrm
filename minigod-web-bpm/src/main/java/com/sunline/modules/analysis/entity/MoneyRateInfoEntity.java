package com.sunline.modules.analysis.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 汇率信息表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-05-03 13:15:29
 */
public class MoneyRateInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//自增ID
	private Long id;
	//汇率日期
	private String initDate;
	//源货币
	private String fromMoneyType;
	//目标货币
	private String toMoneyType;
	//正向汇率
	private BigDecimal exchRate;
	//反向汇率
	private BigDecimal reverseRate;
	//有效时间
	private Date validDate;
	//创建时间
	private String createTime;
	//修改时间
	private String updateTime;
	// 汇率
	private BigDecimal exchangeRate;

	/**
	 * 设置：自增ID
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：自增ID
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：汇率日期
	 */
	public void setInitDate(String initDate) {
		this.initDate = initDate;
	}
	/**
	 * 获取：汇率日期
	 */
	public String getInitDate() {
		return initDate;
	}
	/**
	 * 设置：源货币
	 */
	public void setFromMoneyType(String fromMoneyType) {
		this.fromMoneyType = fromMoneyType;
	}
	/**
	 * 获取：源货币
	 */
	public String getFromMoneyType() {
		return fromMoneyType;
	}
	/**
	 * 设置：目标货币
	 */
	public void setToMoneyType(String toMoneyType) {
		this.toMoneyType = toMoneyType;
	}
	/**
	 * 获取：目标货币
	 */
	public String getToMoneyType() {
		return toMoneyType;
	}
	/**
	 * 设置：正向汇率
	 */
	public void setExchRate(BigDecimal exchRate) {
		this.exchRate = exchRate;
	}
	/**
	 * 获取：正向汇率
	 */
	public BigDecimal getExchRate() {
		return exchRate;
	}
	/**
	 * 设置：反向汇率
	 */
	public void setReverseRate(BigDecimal reverseRate) {
		this.reverseRate = reverseRate;
	}
	/**
	 * 获取：反向汇率
	 */
	public BigDecimal getReverseRate() {
		return reverseRate;
	}
	/**
	 * 设置：有效时间
	 */
	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}
	/**
	 * 获取：有效时间
	 */
	public Date getValidDate() {
		return validDate;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public String getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：修改时间
	 */
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：修改时间
	 */
	public String getUpdateTime() {
		return updateTime;
	}

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
}
