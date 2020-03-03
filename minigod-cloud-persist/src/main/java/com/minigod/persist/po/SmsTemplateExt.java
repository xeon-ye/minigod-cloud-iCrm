package com.minigod.persist.po;
import com.minigod.persist.tables.TSmsTemplateExt;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 消息模板扩展表
 */
@Entity(table=TSmsTemplateExt.class)
public class SmsTemplateExt implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer templateExtId;//消息模板扩展表id
	private Integer code;//消息代码
	private String keyName;
	private String keyValue;
	private String remark;
	private Date createTime;//创建时间
	private Integer createOpr;//创建人
	private Date updateTime;//修改时间
	private Integer updateOpr;//修改人
	private Boolean isStatus;//有效标志

    public Integer getTemplateExtId () {
        return templateExtId;
    }

    public void setTemplateExtId (Integer templateExtId) {
        this.templateExtId = templateExtId;
    }

    public Integer getCode () {
        return code;
    }

    public void setCode (Integer code) {
        this.code = code;
    }

    public String getKeyName () {
        return keyName;
    }

    public void setKeyName (String keyName) {
        this.keyName = keyName;
    }

    public String getKeyValue () {
        return keyValue;
    }

    public void setKeyValue (String keyValue) {
        this.keyValue = keyValue;
    }

    public String getRemark () {
        return remark;
    }

    public void setRemark (String remark) {
        this.remark = remark;
    }

    public Date getCreateTime () {
        return createTime;
    }

    public void setCreateTime (Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateOpr () {
        return createOpr;
    }

    public void setCreateOpr (Integer createOpr) {
        this.createOpr = createOpr;
    }

    public Date getUpdateTime () {
        return updateTime;
    }

    public void setUpdateTime (Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdateOpr () {
        return updateOpr;
    }

    public void setUpdateOpr (Integer updateOpr) {
        this.updateOpr = updateOpr;
    }

    public Boolean getIsStatus () {
        return isStatus;
    }

    public void setIsStatus (Boolean isStatus) {
        this.isStatus = isStatus;
    }
}