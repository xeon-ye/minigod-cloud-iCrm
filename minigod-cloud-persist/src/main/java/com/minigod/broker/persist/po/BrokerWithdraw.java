package com.minigod.broker.persist.po;
import com.minigod.broker.persist.tables.TBrokerWithdraw;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 经理人提现申请
 */
@Entity(table=TBrokerWithdraw.class)
public class BrokerWithdraw implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long id;//主键
	private Long accountId;//账户ID
	private Long flowId;//流水表ID
	private Integer withType;//提现类型 1:微信提现 2:银行卡提现
	private BigDecimal amount = new BigDecimal(0.00);//提现金额
	private BigDecimal actualAmount = new BigDecimal(0.00);//到账金额
	private String feeRate = "0.00";//手续费
	private String accountNo;//到账账号
	private String accountName;//账户名称
	private String withDesc;//提现描述
	private Integer state = 0;//发送状态 0:等待审批 1:已发送 2:发送失败
	private String failReason;//发送失败原因
	private Date withDate;//提现日期
	private Date createTime;//创建时间
	private Date updateTime;//修改时间

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public Long getAccountId () {
        return accountId;
    }

    public void setAccountId (Long accountId) {
        this.accountId = accountId;
    }

    public Long getFlowId () {
        return flowId;
    }

    public void setFlowId (Long flowId) {
        this.flowId = flowId;
    }

    public Integer getWithType () {
        return withType;
    }

    public void setWithType (Integer withType) {
        this.withType = withType;
    }

    public BigDecimal getAmount () {
        return amount;
    }

    public void setAmount (BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getActualAmount () {
        return actualAmount;
    }

    public void setActualAmount (BigDecimal actualAmount) {
        this.actualAmount = actualAmount;
    }

    public String getFeeRate () {
        return feeRate;
    }

    public void setFeeRate (String feeRate) {
        this.feeRate = feeRate;
    }

    public String getAccountNo () {
        return accountNo;
    }

    public void setAccountNo (String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountName () {
        return accountName;
    }

    public void setAccountName (String accountName) {
        this.accountName = accountName;
    }

    public String getWithDesc () {
        return withDesc;
    }

    public void setWithDesc (String withDesc) {
        this.withDesc = withDesc;
    }

    public Integer getState () {
        return state;
    }

    public void setState (Integer state) {
        this.state = state;
    }

    public String getFailReason () {
        return failReason;
    }

    public void setFailReason (String failReason) {
        this.failReason = failReason;
    }

    public Date getWithDate () {
        return withDate;
    }

    public void setWithDate (Date withDate) {
        this.withDate = withDate;
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