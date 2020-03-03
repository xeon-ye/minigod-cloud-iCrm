package com.minigod.persist.po;
import com.minigod.persist.tables.TInformMobileContent;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 短信内容信息表
 */
@Entity(table=TInformMobileContent.class)
public class InformMobileContent implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long id;//主键
	private Integer tempCode;//模板编码
	private Integer userType;//用户类型
	private Integer userId;//用户ID
	private String cellPhone;//手机号码
	private String title;//短信标题
	private String content;//短信内容
	private String discription;//描述
	private Integer channel = 1;//短信渠道(1:玖富)
	private Integer sendStatus = 0;//推送状态(0-未发送，1-已发送 2-发送失败)
	private Integer sendType;//发送类型(0-即时 1-定时)
	private Date timing;//定时发送时间
	private Integer failCnt = 0;//失败次数
	private Integer retryCnt = 0;//重发次数
	private Date sendTime;//发送时间
	private Date receiveTime;//接收时间
	private Integer oprId;//权限审核人ID
	private String oprName;//权限审核人名称
	private Date createTime = new Date();//创建时间
	private Date updateTime = new Date();//更新时间

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public Integer getTempCode () {
        return tempCode;
    }

    public void setTempCode (Integer tempCode) {
        this.tempCode = tempCode;
    }

    public Integer getUserType () {
        return userType;
    }

    public void setUserType (Integer userType) {
        this.userType = userType;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public String getCellPhone () {
        return cellPhone;
    }

    public void setCellPhone (String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getTitle () {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public String getContent () {
        return content;
    }

    public void setContent (String content) {
        this.content = content;
    }

    public String getDiscription () {
        return discription;
    }

    public void setDiscription (String discription) {
        this.discription = discription;
    }

    public Integer getChannel () {
        return channel;
    }

    public void setChannel (Integer channel) {
        this.channel = channel;
    }

    public Integer getSendStatus () {
        return sendStatus;
    }

    public void setSendStatus (Integer sendStatus) {
        this.sendStatus = sendStatus;
    }

    public Integer getSendType () {
        return sendType;
    }

    public void setSendType (Integer sendType) {
        this.sendType = sendType;
    }

    public Date getTiming () {
        return timing;
    }

    public void setTiming (Date timing) {
        this.timing = timing;
    }

    public Integer getFailCnt () {
        return failCnt;
    }

    public void setFailCnt (Integer failCnt) {
        this.failCnt = failCnt;
    }

    public Integer getRetryCnt () {
        return retryCnt;
    }

    public void setRetryCnt (Integer retryCnt) {
        this.retryCnt = retryCnt;
    }

    public Date getSendTime () {
        return sendTime;
    }

    public void setSendTime (Date sendTime) {
        this.sendTime = sendTime;
    }

    public Date getReceiveTime () {
        return receiveTime;
    }

    public void setReceiveTime (Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public Integer getOprId () {
        return oprId;
    }

    public void setOprId (Integer oprId) {
        this.oprId = oprId;
    }

    public String getOprName () {
        return oprName;
    }

    public void setOprName (String oprName) {
        this.oprName = oprName;
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