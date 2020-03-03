package com.minigod.persist.po;
import com.minigod.persist.tables.TActivityTemplate;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 卡券活动模板表
 */
@Entity(table=TActivityTemplate.class)
public class ActivityTemplate implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer atId;
	private String msgContent;//推送消息内容
	private String templateTitle;//系统通知模板标题
	private String templateName;//系统通知模板名称
	private Date createTime;//创建时间
	private Date updateTime;//更新时间

    public Integer getAtId () {
        return atId;
    }

    public void setAtId (Integer atId) {
        this.atId = atId;
    }

    public String getMsgContent () {
        return msgContent;
    }

    public void setMsgContent (String msgContent) {
        this.msgContent = msgContent;
    }

    public String getTemplateTitle () {
        return templateTitle;
    }

    public void setTemplateTitle (String templateTitle) {
        this.templateTitle = templateTitle;
    }

    public String getTemplateName () {
        return templateName;
    }

    public void setTemplateName (String templateName) {
        this.templateName = templateName;
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