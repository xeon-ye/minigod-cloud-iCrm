package com.sunline.modules.ccass.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-05-18 11:12:43
 */
public class CcassHoldingsEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer id;
    //参与者编号
    private Integer participantId;
    //股票代码
    private String stockCode;
    //股票英文名
    private String stockNameEn;
    //持股数量
    private BigDecimal stockHolding;
    //持股市值
    private BigDecimal stockValue;
    //持股比例
    private String stakePercentage;
    //持股日期
    private String holdDate;
    // CCASS更新日期
    private String updateDate;

    private String createTime;
    private String updateTime;

    /**
     * 设置：
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置：参与者编号
     */
    public void setParticipantId(Integer participantId) {
        this.participantId = participantId;
    }

    /**
     * 获取：参与者编号
     */
    public Integer getParticipantId() {
        return participantId;
    }

    /**
     * 设置：股票代码
     */
    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    /**
     * 获取：股票代码
     */
    public String getStockCode() {
        return stockCode;
    }

    /**
     * 设置：股票英文名
     */
    public void setStockNameEn(String stockNameEn) {
        this.stockNameEn = stockNameEn;
    }

    /**
     * 获取：股票英文名
     */
    public String getStockNameEn() {
        return stockNameEn;
    }

    /**
     * 设置：持股数量
     */
    public void setStockHolding(BigDecimal stockHolding) {
        this.stockHolding = stockHolding;
    }

    /**
     * 获取：持股数量
     */
    public BigDecimal getStockHolding() {
        return stockHolding;
    }

    /**
     * 设置：持股市值
     */
    public void setStockValue(BigDecimal stockValue) {
        this.stockValue = stockValue;
    }

    /**
     * 获取：持股市值
     */
    public BigDecimal getStockValue() {
        return stockValue;
    }

    /**
     * 设置：持股比例
     */
    public void setStakePercentage(String stakePercentage) {
        this.stakePercentage = stakePercentage;
    }

    /**
     * 获取：持股比例
     */
    public String getStakePercentage() {
        return stakePercentage;
    }

    public String getHoldDate() {
        return holdDate;
    }

    public void setHoldDate(String holdDate) {
        this.holdDate = holdDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
