package com.minigod.persist.po;
import com.minigod.persist.tables.TOpenUserInfo;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TOpenUserInfo.class)
public class OpenUserInfo implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long id;//自增主键
	private Integer userId;
	private Long inviter;
	private String info;//用户ID
	private Date createTime;//创建时间
	private Date updateTime;//更新时间
	private String pushrecved;//推送是否接收正常
	private String rtncode;//推送返回码
	private String openaccountacceptid;//开户返回账户ID
	private String openstatus;//0:开户成功，1:开户中，2:开户失败,3:基本资料错误，4:影像资料错误，5:基本资料和影像资料错误
	private Date openDate;//开户日期
	private String clientId;//客户号（交易帐号）
	private Integer isReward = 0;//是否领取奖励
	private Integer errCnt = 0;//失败次数
	private Integer isSend = 0;//是否发送消息
	private Integer openaccountaccessway;//1:H5开户 2:APP开户
	private String email;//邮箱
	private String idNo;//身份证号码

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

    public Long getInviter () {
        return inviter;
    }

    public void setInviter (Long inviter) {
        this.inviter = inviter;
    }

    public String getInfo () {
        return info;
    }

    public void setInfo (String info) {
        this.info = info;
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

    public String getPushrecved () {
        return pushrecved;
    }

    public void setPushrecved (String pushrecved) {
        this.pushrecved = pushrecved;
    }

    public String getRtncode () {
        return rtncode;
    }

    public void setRtncode (String rtncode) {
        this.rtncode = rtncode;
    }

    public String getOpenaccountacceptid () {
        return openaccountacceptid;
    }

    public void setOpenaccountacceptid (String openaccountacceptid) {
        this.openaccountacceptid = openaccountacceptid;
    }

    public String getOpenstatus () {
        return openstatus;
    }

    public void setOpenstatus (String openstatus) {
        this.openstatus = openstatus;
    }

    public Date getOpenDate () {
        return openDate;
    }

    public void setOpenDate (Date openDate) {
        this.openDate = openDate;
    }

    public String getClientId () {
        return clientId;
    }

    public void setClientId (String clientId) {
        this.clientId = clientId;
    }

    public Integer getIsReward () {
        return isReward;
    }

    public void setIsReward (Integer isReward) {
        this.isReward = isReward;
    }

    public Integer getErrCnt () {
        return errCnt;
    }

    public void setErrCnt (Integer errCnt) {
        this.errCnt = errCnt;
    }

    public Integer getIsSend () {
        return isSend;
    }

    public void setIsSend (Integer isSend) {
        this.isSend = isSend;
    }

    public Integer getOpenaccountaccessway () {
        return openaccountaccessway;
    }

    public void setOpenaccountaccessway (Integer openaccountaccessway) {
        this.openaccountaccessway = openaccountaccessway;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public String getIdNo () {
        return idNo;
    }

    public void setIdNo (String idNo) {
        this.idNo = idNo;
    }
}