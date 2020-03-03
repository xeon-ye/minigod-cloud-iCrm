package com.minigod.persist.po;
import com.minigod.persist.tables.TSecPoundageFree;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 入金免手续费记录表
 */
@Entity(table=TSecPoundageFree.class)
public class SecPoundageFree implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long id;//主键
	private Integer userId;//客户id
	private String userName;//客户名称
	private String userPhoneNum;//客户手机号
	private Long transactId;//对应交易流水号
	private String transAccount;//交易账号
	private String capitalAccount;//资金账号
	private String depositAccountType;//存入方式:1:大陆银行卡2:香港银行卡
	private String currency;//币种 1港币 2 美元
	private String depositAccount;//存入账户
	private String depositBank;//存入银行
	private Date applicationTime;//申请时间
	private Double depositMoney;//存入金额
	private Double poundageMoney;//入金手续费
	private Integer status = 0;//申请免手续费状态
	private Date createdTime;//创建时间
	private Date updateTime;//修改时间
	private String refuseReasons;//拒绝原因
	private String createdBy;//创建人
	private String updateBy;//修改人
	private Integer recordStatus = 0;//记录状态:0:有效1:无效
	private String rmk;//备注
	private String activiTimes;//活动次数
	private String activiDate;//活动时间

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

    public String getUserName () {
        return userName;
    }

    public void setUserName (String userName) {
        this.userName = userName;
    }

    public String getUserPhoneNum () {
        return userPhoneNum;
    }

    public void setUserPhoneNum (String userPhoneNum) {
        this.userPhoneNum = userPhoneNum;
    }

    public Long getTransactId () {
        return transactId;
    }

    public void setTransactId (Long transactId) {
        this.transactId = transactId;
    }

    public String getTransAccount () {
        return transAccount;
    }

    public void setTransAccount (String transAccount) {
        this.transAccount = transAccount;
    }

    public String getCapitalAccount () {
        return capitalAccount;
    }

    public void setCapitalAccount (String capitalAccount) {
        this.capitalAccount = capitalAccount;
    }

    public String getDepositAccountType () {
        return depositAccountType;
    }

    public void setDepositAccountType (String depositAccountType) {
        this.depositAccountType = depositAccountType;
    }

    public String getCurrency () {
        return currency;
    }

    public void setCurrency (String currency) {
        this.currency = currency;
    }

    public String getDepositAccount () {
        return depositAccount;
    }

    public void setDepositAccount (String depositAccount) {
        this.depositAccount = depositAccount;
    }

    public String getDepositBank () {
        return depositBank;
    }

    public void setDepositBank (String depositBank) {
        this.depositBank = depositBank;
    }

    public Date getApplicationTime () {
        return applicationTime;
    }

    public void setApplicationTime (Date applicationTime) {
        this.applicationTime = applicationTime;
    }

    public Double getDepositMoney () {
        return depositMoney;
    }

    public void setDepositMoney (Double depositMoney) {
        this.depositMoney = depositMoney;
    }

    public Double getPoundageMoney () {
        return poundageMoney;
    }

    public void setPoundageMoney (Double poundageMoney) {
        this.poundageMoney = poundageMoney;
    }

    public Integer getStatus () {
        return status;
    }

    public void setStatus (Integer status) {
        this.status = status;
    }

    public Date getCreatedTime () {
        return createdTime;
    }

    public void setCreatedTime (Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdateTime () {
        return updateTime;
    }

    public void setUpdateTime (Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRefuseReasons () {
        return refuseReasons;
    }

    public void setRefuseReasons (String refuseReasons) {
        this.refuseReasons = refuseReasons;
    }

    public String getCreatedBy () {
        return createdBy;
    }

    public void setCreatedBy (String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdateBy () {
        return updateBy;
    }

    public void setUpdateBy (String updateBy) {
        this.updateBy = updateBy;
    }

    public Integer getRecordStatus () {
        return recordStatus;
    }

    public void setRecordStatus (Integer recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getRmk () {
        return rmk;
    }

    public void setRmk (String rmk) {
        this.rmk = rmk;
    }

    public String getActiviTimes () {
        return activiTimes;
    }

    public void setActiviTimes (String activiTimes) {
        this.activiTimes = activiTimes;
    }

    public String getActiviDate () {
        return activiDate;
    }

    public void setActiviDate (String activiDate) {
        this.activiDate = activiDate;
    }
}