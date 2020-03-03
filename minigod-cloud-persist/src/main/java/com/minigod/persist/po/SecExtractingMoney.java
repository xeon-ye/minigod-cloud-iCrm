package com.minigod.persist.po;
import com.minigod.persist.tables.TSecExtractingMoney;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 提取资金表
 */
@Entity(table=TSecExtractingMoney.class)
public class SecExtractingMoney implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long id;//提取资金表id
	private Integer userId;//用户id
	private String extAccount;//提取账户
	private String extAccountName;//提取账户名称
	private String clientId;//交易账户
	private Integer extMethod;//提取方式 1大陆银行 2香港银行
	private String bankName;//收款银行名称
	private String bankCode;//收款银行代码
	private String swiftCode;//电讯码
	private String payee;//收款人
	private String address;//联系地址
	private String bankAccount;//银行账号
	private BigDecimal availableAmount;//可提金额
	private BigDecimal extractionAmount;//提取金额
	private String remarks;//备注信息
	private Integer state;//状态 0已提交 1已受理 2已退回 3已完成
	private Integer currency;//币种 1港币 2美元
	private BigDecimal chargeMoney;//手续费
	private String backPerson;//操作人
	private String backReason;//退回理由
	private Integer isFind = 1;//是否全部加载 0 否 1 是
	private Date createdTime;//创建时间
	private Date modifyTime;//更新时间

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public String getExtAccount () {
        return extAccount;
    }

    public void setExtAccount (String extAccount) {
        this.extAccount = extAccount;
    }

    public String getExtAccountName () {
        return extAccountName;
    }

    public void setExtAccountName (String extAccountName) {
        this.extAccountName = extAccountName;
    }

    public String getClientId () {
        return clientId;
    }

    public void setClientId (String clientId) {
        this.clientId = clientId;
    }

    public Integer getExtMethod () {
        return extMethod;
    }

    public void setExtMethod (Integer extMethod) {
        this.extMethod = extMethod;
    }

    public String getBankName () {
        return bankName;
    }

    public void setBankName (String bankName) {
        this.bankName = bankName;
    }

    public String getBankCode () {
        return bankCode;
    }

    public void setBankCode (String bankCode) {
        this.bankCode = bankCode;
    }

    public String getPayee () {
        return payee;
    }

    public void setPayee (String payee) {
        this.payee = payee;
    }

    public String getBankAccount () {
        return bankAccount;
    }

    public void setBankAccount (String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public BigDecimal getAvailableAmount () {
        return availableAmount;
    }

    public void setAvailableAmount (BigDecimal availableAmount) {
        this.availableAmount = availableAmount;
    }

    public BigDecimal getExtractionAmount () {
        return extractionAmount;
    }

    public void setExtractionAmount (BigDecimal extractionAmount) {
        this.extractionAmount = extractionAmount;
    }

    public String getRemarks () {
        return remarks;
    }

    public void setRemarks (String remarks) {
        this.remarks = remarks;
    }

    public Integer getState () {
        return state;
    }

    public void setState (Integer state) {
        this.state = state;
    }

    public Integer getCurrency () {
        return currency;
    }

    public void setCurrency (Integer currency) {
        this.currency = currency;
    }

    public BigDecimal getChargeMoney () {
        return chargeMoney;
    }

    public void setChargeMoney (BigDecimal chargeMoney) {
        this.chargeMoney = chargeMoney;
    }

    public String getBackPerson () {
        return backPerson;
    }

    public void setBackPerson (String backPerson) {
        this.backPerson = backPerson;
    }

    public String getBackReason () {
        return backReason;
    }

    public void setBackReason (String backReason) {
        this.backReason = backReason;
    }

    public Integer getIsFind () {
        return isFind;
    }

    public void setIsFind (Integer isFind) {
        this.isFind = isFind;
    }

    public Date getCreatedTime () {
        return createdTime;
    }

    public void setCreatedTime (Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifyTime () {
        return modifyTime;
    }

    public void setModifyTime (Date modifyTime) {
        this.modifyTime = modifyTime;
    }
    
    public String getSwiftCode() {
		return swiftCode;
	}

	public void setSwiftCode(String swiftCode) {
		this.swiftCode = swiftCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}