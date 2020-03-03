package com.minigod.persist.po;
import com.minigod.persist.tables.TCashAcc;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 */
@Entity(table=TCashAcc.class)
public class CashAcc implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer accountId;//账户ID
	private String refIdType;//关联账户类型
	private String refIdNo;//关联账户
	private String name;//账户名称及描述
	private String subjectId;//账户所属科目
	private String direction;//余额方向
	private String ccy;//币种
	private Date dayInitDate;//日初日期
	private Integer dayActSeq = 0;//日内账户交易流水号
	private BigDecimal dayInitBal;//日初账户余额
	private BigDecimal dayInitFrzBal = new BigDecimal(0.00);//日初冻结余额
	private BigDecimal balance;//账户余额
	private BigDecimal frzBalance;//冻结余额
	private Boolean isStatus;//记录状态
	private Date createTime;//创建时间
	private Date updateTime;//修改时间
	private Integer lockVersion;//乐观锁版本号

    public Integer getAccountId () {
        return accountId;
    }

    public void setAccountId (Integer accountId) {
        this.accountId = accountId;
    }

    public String getRefIdType () {
        return refIdType;
    }

    public void setRefIdType (String refIdType) {
        this.refIdType = refIdType;
    }

    public String getRefIdNo () {
        return refIdNo;
    }

    public void setRefIdNo (String refIdNo) {
        this.refIdNo = refIdNo;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getSubjectId () {
        return subjectId;
    }

    public void setSubjectId (String subjectId) {
        this.subjectId = subjectId;
    }

    public String getDirection () {
        return direction;
    }

    public void setDirection (String direction) {
        this.direction = direction;
    }

    public String getCcy () {
        return ccy;
    }

    public void setCcy (String ccy) {
        this.ccy = ccy;
    }

    public Date getDayInitDate () {
        return dayInitDate;
    }

    public void setDayInitDate (Date dayInitDate) {
        this.dayInitDate = dayInitDate;
    }

    public Integer getDayActSeq () {
        return dayActSeq;
    }

    public void setDayActSeq (Integer dayActSeq) {
        this.dayActSeq = dayActSeq;
    }

    public BigDecimal getDayInitBal () {
        return dayInitBal;
    }

    public void setDayInitBal (BigDecimal dayInitBal) {
        this.dayInitBal = dayInitBal;
    }

    public BigDecimal getDayInitFrzBal () {
        return dayInitFrzBal;
    }

    public void setDayInitFrzBal (BigDecimal dayInitFrzBal) {
        this.dayInitFrzBal = dayInitFrzBal;
    }

    public BigDecimal getBalance () {
        return balance;
    }

    public void setBalance (BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getFrzBalance () {
        return frzBalance;
    }

    public void setFrzBalance (BigDecimal frzBalance) {
        this.frzBalance = frzBalance;
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