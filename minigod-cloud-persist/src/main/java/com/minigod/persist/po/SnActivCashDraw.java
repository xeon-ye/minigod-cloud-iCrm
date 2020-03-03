package com.minigod.persist.po;
import com.minigod.persist.tables.TSnActivCashDraw;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TSnActivCashDraw.class)
public class SnActivCashDraw implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long id;//主键
	private String seqid;//标示Id
	private Long userId;//用户id
	private String wechatId;//微信号
	private Long money = 0l;//提现金额
	private Integer drawStatus;//提现状态(1:未申请,2:已申请,3:退回,4:已完成)
	private Date drawDatetime;//提现时间
	private Integer STATUS = 0;//记录状态 0有效 1失效
	private Date createTime;//创建时间
	private Date updateTime;//修改时间
	private String backReason;//退回理由
	private String backPerson;//操作人

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getSeqid () {
        return seqid;
    }

    public void setSeqid (String seqid) {
        this.seqid = seqid;
    }

    public Long getUserId () {
        return userId;
    }

    public void setUserId (Long userId) {
        this.userId = userId;
    }

    public Long getMoney () {
        return money;
    }

    public void setMoney (Long money) {
        this.money = money;
    }

    public Integer getDrawStatus () {
        return drawStatus;
    }

    public void setDrawStatus (Integer drawStatus) {
        this.drawStatus = drawStatus;
    }

    public Date getDrawDatetime () {
        return drawDatetime;
    }

    public void setDrawDatetime (Date drawDatetime) {
        this.drawDatetime = drawDatetime;
    }

    public Integer getSTATUS () {
        return STATUS;
    }

    public void setSTATUS (Integer STATUS) {
        this.STATUS = STATUS;
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

    public String getBackReason () {
        return backReason;
    }

    public void setBackReason (String backReason) {
        this.backReason = backReason;
    }

    public String getBackPerson () {
        return backPerson;
    }

    public void setBackPerson (String backPerson) {
        this.backPerson = backPerson;
    }
    public String getWechatId() {
		return wechatId;
	}

	public void setWechatId(String wechatId) {
		this.wechatId = wechatId;
	}
}