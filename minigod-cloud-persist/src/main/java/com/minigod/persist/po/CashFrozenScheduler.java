package com.minigod.persist.po;
import com.minigod.persist.tables.TCashFrozenScheduler;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 */
@Entity(table=TCashFrozenScheduler.class)
public class CashFrozenScheduler implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer cashFrozenId;//冻结id
	private Integer frozenTrxId;//冻结的交易ID
	private Integer accountId;//账户ID
	private String frozenType;
	private Date frozenDate;//解冻日期
	private BigDecimal frzAmount;//冻结金额
	private String unfrozenSrcTransId;//源系统客户端交易ID
	private Integer unfrozenTrxId;//解冻的交易ID
	private String examine = "N";//是否已审批
	private Boolean isStatus;//状态(0停用,默认1正常使用)
	private Date createTime;//创建时间
	private Date updateTime;//修改时间
	private Integer lockVersion;//乐观锁版本号

    public Integer getCashFrozenId () {
        return cashFrozenId;
    }

    public void setCashFrozenId (Integer cashFrozenId) {
        this.cashFrozenId = cashFrozenId;
    }

    public Integer getFrozenTrxId () {
        return frozenTrxId;
    }

    public void setFrozenTrxId (Integer frozenTrxId) {
        this.frozenTrxId = frozenTrxId;
    }

    public Integer getAccountId () {
        return accountId;
    }

    public void setAccountId (Integer accountId) {
        this.accountId = accountId;
    }

    public String getFrozenType () {
        return frozenType;
    }

    public void setFrozenType (String frozenType) {
        this.frozenType = frozenType;
    }

    public Date getFrozenDate () {
        return frozenDate;
    }

    public void setFrozenDate (Date frozenDate) {
        this.frozenDate = frozenDate;
    }

    public BigDecimal getFrzAmount () {
        return frzAmount;
    }

    public void setFrzAmount (BigDecimal frzAmount) {
        this.frzAmount = frzAmount;
    }

    public String getUnfrozenSrcTransId () {
        return unfrozenSrcTransId;
    }

    public void setUnfrozenSrcTransId (String unfrozenSrcTransId) {
        this.unfrozenSrcTransId = unfrozenSrcTransId;
    }

    public Integer getUnfrozenTrxId () {
        return unfrozenTrxId;
    }

    public void setUnfrozenTrxId (Integer unfrozenTrxId) {
        this.unfrozenTrxId = unfrozenTrxId;
    }

    public String getExamine () {
        return examine;
    }

    public void setExamine (String examine) {
        this.examine = examine;
    }

    public Boolean getIsStatus () {
        return isStatus;
    }

    public void setIsStatus (Boolean isStatus) {
        this.isStatus = isStatus;
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

    public Integer getLockVersion () {
        return lockVersion;
    }

    public void setLockVersion (Integer lockVersion) {
        this.lockVersion = lockVersion;
    }
}