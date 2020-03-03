package com.minigod.persist.po;
import com.minigod.persist.tables.TSecDepositFunds;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 存入资金表
 */
@Entity(table=TSecDepositFunds.class)
public class SecDepositFunds implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long id;//主键
	private Integer currency;//币种 1港币 2 美元
	private Integer bankType;//银行 1大陆 2香港
	private String clientId;//交易账户
	private String bankName;//银行名称
	private String bankCode;//银行代码
	private String depositAccount;//存入账户
	private String depositAccountName;//存入账户名称
	private Double depositMoney;//存入金额
	private Integer inviter;//邀请人
	private String remarks;//备注信息
	private Integer state;//状态 0已提交 1已受理 2已退回 3已完成
	private Integer userId;//用户ID
	private Integer isFind = 1;//是否全部加载 0 否 1 是
	private Double chargeMoney;//手续费
	private Long accImgId;//上传凭证图片ID
	private String backPerson;//操作人
	private String backReason;//退回理由
	private String info;//前端保存信息
	private Date createdTime;//创建时间
	private Date modifyTime;//更新时间
	private String getAccount;//收款账户号码
	private String getAccountName;//收款人账户名
	private String getAddress;//收款人地址
	private String getBankNameCn;//收款银行中文名
	private String getBankNameEn;//收款银行英文名
	private String getBankAddress;//收款银行地址
	private String swiftCode;//SWIFT代码
	private Integer isReward = 0;//是否发放奖励

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public Integer getCurrency () {
        return currency;
    }

    public void setCurrency (Integer currency) {
        this.currency = currency;
    }

    public Integer getBankType () {
        return bankType;
    }

    public void setBankType (Integer bankType) {
        this.bankType = bankType;
    }

    public String getClientId () {
        return clientId;
    }

    public void setClientId (String clientId) {
        this.clientId = clientId;
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

    public String getDepositAccount () {
        return depositAccount;
    }

    public void setDepositAccount (String depositAccount) {
        this.depositAccount = depositAccount;
    }

    public String getDepositAccountName () {
        return depositAccountName;
    }

    public void setDepositAccountName (String depositAccountName) {
        this.depositAccountName = depositAccountName;
    }

    public Double getDepositMoney () {
        return depositMoney;
    }

    public void setDepositMoney (Double depositMoney) {
        this.depositMoney = depositMoney;
    }

    public Integer getInviter () {
        return inviter;
    }

    public void setInviter (Integer inviter) {
        this.inviter = inviter;
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

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public Integer getIsFind () {
        return isFind;
    }

    public void setIsFind (Integer isFind) {
        this.isFind = isFind;
    }

    public Double getChargeMoney () {
        return chargeMoney;
    }

    public void setChargeMoney (Double chargeMoney) {
        this.chargeMoney = chargeMoney;
    }

    public Long getAccImgId () {
        return accImgId;
    }

    public void setAccImgId (Long accImgId) {
        this.accImgId = accImgId;
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

    public String getInfo () {
        return info;
    }

    public void setInfo (String info) {
        this.info = info;
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

    public String getGetAccount () {
        return getAccount;
    }

    public void setGetAccount (String getAccount) {
        this.getAccount = getAccount;
    }

    public String getGetAccountName () {
        return getAccountName;
    }

    public void setGetAccountName (String getAccountName) {
        this.getAccountName = getAccountName;
    }

    public String getGetAddress () {
        return getAddress;
    }

    public void setGetAddress (String getAddress) {
        this.getAddress = getAddress;
    }

    public String getGetBankNameCn () {
        return getBankNameCn;
    }

    public void setGetBankNameCn (String getBankNameCn) {
        this.getBankNameCn = getBankNameCn;
    }

    public String getGetBankNameEn () {
        return getBankNameEn;
    }

    public void setGetBankNameEn (String getBankNameEn) {
        this.getBankNameEn = getBankNameEn;
    }

    public String getGetBankAddress () {
        return getBankAddress;
    }

    public void setGetBankAddress (String getBankAddress) {
        this.getBankAddress = getBankAddress;
    }

    public String getSwiftCode () {
        return swiftCode;
    }

    public void setSwiftCode (String swiftCode) {
        this.swiftCode = swiftCode;
    }

    public Integer getIsReward () {
        return isReward;
    }

    public void setIsReward (Integer isReward) {
        this.isReward = isReward;
    }
}