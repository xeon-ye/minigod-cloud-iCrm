package com.minigod.persist.po;
import com.minigod.persist.tables.TSmsTemplate;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TSmsTemplate.class)
public class SmsTemplate implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer templateId;//消息模板id
	private Integer code;//消息代码
	private String event;
	private Integer busType;//业务类型
	private String channel;
	private Integer createOpr;//创建人
	private Date createTime;//创建时间
	private Integer updateOpr;//修改人
	private Date updateTime;//修改时间
	private Boolean isStatus;//记录是否有效

    public Integer getTemplateId () {
        return templateId;
    }

    public void setTemplateId (Integer templateId) {
        this.templateId = templateId;
    }

    public Integer getCode () {
        return code;
    }

    public void setCode (Integer code) {
        this.code = code;
    }

    public String getEvent () {
        return event;
    }

    public void setEvent (String event) {
        this.event = event;
    }

    public Integer getBusType () {
        return busType;
    }

    public void setBusType (Integer busType) {
        this.busType = busType;
    }

    public String getChannel () {
        return channel;
    }

    public void setChannel (String channel) {
        this.channel = channel;
    }

    public Integer getCreateOpr () {
        return createOpr;
    }

    public void setCreateOpr (Integer createOpr) {
        this.createOpr = createOpr;
    }

    public Date getCreateTime () {
        return createTime;
    }

    public void setCreateTime (Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateOpr () {
        return updateOpr;
    }

    public void setUpdateOpr (Integer updateOpr) {
        this.updateOpr = updateOpr;
    }

    public Date getUpdateTime () {
        return updateTime;
    }

    public void setUpdateTime (Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getIsStatus () {
        return isStatus;
    }

    public void setIsStatus (Boolean isStatus) {
        this.isStatus = isStatus;
    }
}