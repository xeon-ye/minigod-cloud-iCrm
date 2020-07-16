package com.sunline.modules.commission.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 柜台佣金套餐设置表
 *
 * @author lcs
 * @email
 * @date 2018-08-20 13:17:13
 */
public class FarePackageSetupEntity implements Serializable {
	private static final long serialVersionUID = 1L;

    //自增ID
    private Integer id;
    //套餐编号
    private String fareKind;
    //证券市场[K-港交所 P-美国市场]
    private String exchangeType;
    //委托方式[7-网上委托 T-电话委托]
    private String entrustWay;
    //收费方式[0-按百分比 1-按固定笔数 5-按固定股数]
    private String feeType;
    //付费数值
    private BigDecimal balanceRatio;
    //固定费用
    private BigDecimal feeCountFix;
    //最低费用
    private BigDecimal minFare;
    //最高费用
    private BigDecimal maxFare;
    //开始日期
    private Date beginDate;
    //结束日期
    private Date endDate;
    //创建时间
    private Date createTime;
    //修改时间
    private Date updateTime;

    private Integer channelId;
    private String channelName;
    private int fareType;

    //费用描述
    private String fareRemark;

    /**
     * 设置：自增ID
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * 获取：自增ID
     */
    public Integer getId() {
        return id;
    }
    /**
     * 设置：套餐编号
     */
    public void setFareKind(String fareKind) {
        this.fareKind = fareKind;
    }
    /**
     * 获取：套餐编号
     */
    public String getFareKind() {
        return fareKind;
    }
    /**
     * 设置：证券市场[K-港交所 P-美国市场]
     */
    public void setExchangeType(String exchangeType) {
        this.exchangeType = exchangeType;
    }
    /**
     * 获取：证券市场[K-港交所 P-美国市场]
     */
    public String getExchangeType() {
        return exchangeType;
    }
    /**
     * 设置：委托方式[7-网上委托 T-电话委托]
     */
    public void setEntrustWay(String entrustWay) {
        this.entrustWay = entrustWay;
    }
    /**
     * 获取：委托方式[7-网上委托 T-电话委托]
     */
    public String getEntrustWay() {
        return entrustWay;
    }
    /**
     * 设置：收费方式[0-按百分比 1-按固定笔数 5-按固定股数]
     */
    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }
    /**
     * 获取：收费方式[0-按百分比 1-按固定笔数 5-按固定股数]
     */
    public String getFeeType() {
        return feeType;
    }
    /**
     * 设置：付费数值
     */
    public void setBalanceRatio(BigDecimal balanceRatio) {
        this.balanceRatio = balanceRatio;
    }
    /**
     * 获取：付费数值
     */
    public BigDecimal getBalanceRatio() {
        return balanceRatio;
    }
    /**
     * 设置：固定费用
     */
    public void setFeeCountFix(BigDecimal feeCountFix) {
        this.feeCountFix = feeCountFix;
    }
    /**
     * 获取：固定费用
     */
    public BigDecimal getFeeCountFix() {
        return feeCountFix;
    }
    /**
     * 设置：最低费用
     */
    public void setMinFare(BigDecimal minFare) {
        this.minFare = minFare;
    }
    /**
     * 获取：最低费用
     */
    public BigDecimal getMinFare() {
        return minFare;
    }
    /**
     * 设置：最高费用
     */
    public void setMaxFare(BigDecimal maxFare) {
        this.maxFare = maxFare;
    }
    /**
     * 获取：最高费用
     */
    public BigDecimal getMaxFare() {
        return maxFare;
    }
    /**
     * 设置：开始日期
     */
    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }
    /**
     * 获取：开始日期
     */
    public Date getBeginDate() {
        return beginDate;
    }
    /**
     * 设置：结束日期
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    /**
     * 获取：结束日期
     */
    public Date getEndDate() {
        return endDate;
    }
    /**
     * 设置：创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    /**
     * 获取：创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }
    /**
     * 设置：修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    /**
     * 获取：修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public int getFareType() {
        return fareType;
    }

    public void setFareType(int fareType) {
        this.fareType = fareType;
    }

    public String getFareRemark() {
        return fareRemark;
    }

    public void setFareRemark(String fareRemark) {
        this.fareRemark = fareRemark;
    }
}
