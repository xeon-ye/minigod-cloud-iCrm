package com.minigod.persist.po;
import com.minigod.persist.tables.TGrmClientFeeFree;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 客户免佣信息表
 */
@Entity(table=TGrmClientFeeFree.class)
public class GrmClientFeeFree implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer id;//主键，无实际业务意义
	private String serialNo;//序号，标记一次免佣行为（客户可以多次免佣）
	private String clientId;//客户账号
	private String fundAccount;//资产账户
	private String fareDict;//费用类型字典(0:服务费 1：交易费)
	private String fareType;//费用类别：0-佣金等
	private String exchangeType;//交易类别(即市场）：K-港股，P-美股
	private String entrustWay;//委托方式：47ABCDEHI等
	private String minFareInTrd;//最低佣金，保存交易系统返回来的值，未进行格式化。
	private String minFare;//最低佣金，格式化后的：小数，默认保留二位小数。
	private String feeCountInTrd;//佣金率，保存交易系统返回来的值，未进行格式化。
	private String feeCount;//佣金率，格式化后的：百分比化的小数，即交易系统返回的数乘100。
	private Date startDate;//免佣开始时间
	private Date endDate;//免佣结束时间
	private Boolean isSetFreeStart;//是否已在交易系统中设置免佣开始(1-已设置,0-未设置)
	private Boolean isSetFreeEnd;//是否已在交易系统中设置免佣结束(1-已设置,0-未设置)
	private Date createTime;//创建时间
	private Date updateTime;//最后修改时间

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public String getSerialNo () {
        return serialNo;
    }

    public void setSerialNo (String serialNo) {
        this.serialNo = serialNo;
    }

    public String getClientId () {
        return clientId;
    }

    public void setClientId (String clientId) {
        this.clientId = clientId;
    }

    public String getFundAccount () {
        return fundAccount;
    }

    public void setFundAccount (String fundAccount) {
        this.fundAccount = fundAccount;
    }

    public String getFareDict () {
        return fareDict;
    }

    public void setFareDict (String fareDict) {
        this.fareDict = fareDict;
    }

    public String getFareType () {
        return fareType;
    }

    public void setFareType (String fareType) {
        this.fareType = fareType;
    }

    public String getExchangeType () {
        return exchangeType;
    }

    public void setExchangeType (String exchangeType) {
        this.exchangeType = exchangeType;
    }

    public String getEntrustWay () {
        return entrustWay;
    }

    public void setEntrustWay (String entrustWay) {
        this.entrustWay = entrustWay;
    }

    public String getMinFareInTrd () {
        return minFareInTrd;
    }

    public void setMinFareInTrd (String minFareInTrd) {
        this.minFareInTrd = minFareInTrd;
    }

    public String getMinFare () {
        return minFare;
    }

    public void setMinFare (String minFare) {
        this.minFare = minFare;
    }

    public String getFeeCountInTrd () {
        return feeCountInTrd;
    }

    public void setFeeCountInTrd (String feeCountInTrd) {
        this.feeCountInTrd = feeCountInTrd;
    }

    public String getFeeCount () {
        return feeCount;
    }

    public void setFeeCount (String feeCount) {
        this.feeCount = feeCount;
    }

    public Date getStartDate () {
        return startDate;
    }

    public void setStartDate (Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate () {
        return endDate;
    }

    public void setEndDate (Date endDate) {
        this.endDate = endDate;
    }

    public Boolean getIsSetFreeStart () {
        return isSetFreeStart;
    }

    public void setIsSetFreeStart (Boolean isSetFreeStart) {
        this.isSetFreeStart = isSetFreeStart;
    }

    public Boolean getIsSetFreeEnd () {
        return isSetFreeEnd;
    }

    public void setIsSetFreeEnd (Boolean isSetFreeEnd) {
        this.isSetFreeEnd = isSetFreeEnd;
    }

    public Date getCreateTime () {
        return createTime;
    }

    public void setCreateTime (Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime () {
        return updateTime;
    }

    public void setUpdateTime (Date updateTime) {
        this.updateTime = updateTime;
    }
}