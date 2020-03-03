package com.minigod.persist.po;
import com.minigod.persist.tables.TInformTemplateType;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 模块类型信息表
 */
@Entity(table=TInformTemplateType.class)
public class InformTemplateType implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long id;//主键
	private Integer busType;//业务类型 1-邮件 2-短信 3-系统通知 4-消息通知
	private String tempName;//类型名称
	private Long parentId = 0l;//子类型 0-主类型
	private Integer sendWay;//发送方式(0-自动 1-手动)
	private Boolean isStatus = true;//是否有效(0-无效，1-有效)
	private Date createTime = new Date();//创建时间
	private Date updateTime = new Date();//更新时间

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public Integer getBusType () {
        return busType;
    }

    public void setBusType (Integer busType) {
        this.busType = busType;
    }

    public String getTempName () {
        return tempName;
    }

    public void setTempName (String tempName) {
        this.tempName = tempName;
    }

    public Long getParentId () {
        return parentId;
    }

    public void setParentId (Long parentId) {
        this.parentId = parentId;
    }

    public Integer getSendWay () {
        return sendWay;
    }

    public void setSendWay (Integer sendWay) {
        this.sendWay = sendWay;
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
}