package com.minigod.persist.po;
import com.minigod.persist.tables.TInformEmailContent;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 邮件内容信息表
 */
@Entity(table=TInformEmailContent.class)
public class InformEmailContent implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long id;//主键
	private Integer tempCode;//模板编码
	private String title;//邮件标题
	private String content;//邮件内容
	private String description;//描述
	private String address;//邮件地址
	private Integer sendStatus = 0;//推送状态(0-未发送，1-已发送 2-发送失败)
	private Integer sendType;//发送类型(-即时 1-定时)
	private Date sendTime;//定时发送时间
	private Integer retryCnt;//重发次数
	private Boolean hasAttach = false;//是否有附件(0-否 1-是)
	private String attachUris;//附件地址
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

    public String getDescription () {
        return description;
    }

    public void setDescription (String description) {
        this.description = description;
    }

    public String getAddress () {
        return address;
    }

    public void setAddress (String address) {
        this.address = address;
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

    public Date getSendTime () {
        return sendTime;
    }

    public void setSendTime (Date sendTime) {
        this.sendTime = sendTime;
    }

    public Integer getRetryCnt () {
        return retryCnt;
    }

    public void setRetryCnt (Integer retryCnt) {
        this.retryCnt = retryCnt;
    }

    public Boolean getHasAttach () {
        return hasAttach;
    }

    public void setHasAttach (Boolean hasAttach) {
        this.hasAttach = hasAttach;
    }

    public String getAttachUris () {
        return attachUris;
    }

    public void setAttachUris (String attachUris) {
        this.attachUris = attachUris;
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