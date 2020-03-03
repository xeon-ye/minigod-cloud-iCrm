package com.minigod.persist.po;
import com.minigod.persist.tables.TPayXfCardBound;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 银行卡绑定表
 */
@Entity(table=TPayXfCardBound.class)
public class PayXfCardBound implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer cardBoundId;//银行卡绑定ID,主键，自增长
	private Integer userId;//用户ID
	private Integer bindSeq;//绑定序号,0表示当前绑定其余数字为历史绑定卡号
	private String cardNo;//卡号
	private String bankId;//银行编码,如ICBC
	private String bankName;//银行名称
	private Date unbindTime;//解绑时间
	private Date createTime;//记录创建时间
	private Date updateTime;//记录修改时间
	private Integer lockVersion;//乐观锁版本号

    public Integer getCardBoundId () {
        return cardBoundId;
    }

    public void setCardBoundId (Integer cardBoundId) {
        this.cardBoundId = cardBoundId;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public Integer getBindSeq () {
        return bindSeq;
    }

    public void setBindSeq (Integer bindSeq) {
        this.bindSeq = bindSeq;
    }

    public String getCardNo () {
        return cardNo;
    }

    public void setCardNo (String cardNo) {
        this.cardNo = cardNo;
    }

    public String getBankId () {
        return bankId;
    }

    public void setBankId (String bankId) {
        this.bankId = bankId;
    }

    public String getBankName () {
        return bankName;
    }

    public void setBankName (String bankName) {
        this.bankName = bankName;
    }

    public Date getUnbindTime () {
        return unbindTime;
    }

    public void setUnbindTime (Date unbindTime) {
        this.unbindTime = unbindTime;
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