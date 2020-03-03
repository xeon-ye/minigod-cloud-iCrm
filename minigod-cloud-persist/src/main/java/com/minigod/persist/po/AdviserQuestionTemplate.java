package com.minigod.persist.po;

import com.minigod.db4j.annotation.Entity;
import com.minigod.persist.tables.TAdviserQuestionTemplate;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TAdviserQuestionTemplate.class)
public class AdviserQuestionTemplate implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer questionTemplateId;//ID
	private Integer type;//类型
	private String content;//内容
	private Integer sort;
	private Date createTime;//创建时间
	private Date updateTime;//修改时间
	private Boolean isStatus;//状态

    public Integer getQuestionTemplateId () {
        return questionTemplateId;
    }

    public void setQuestionTemplateId (Integer questionTemplateId) {
        this.questionTemplateId = questionTemplateId;
    }

    public Integer getType () {
        return type;
    }

    public void setType (Integer type) {
        this.type = type;
    }

    public String getContent () {
        return content;
    }

    public void setContent (String content) {
        this.content = content;
    }

    public Integer getSort () {
        return sort;
    }

    public void setSort (Integer sort) {
        this.sort = sort;
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

    public Boolean getIsStatus () {
        return isStatus;
    }

    public void setIsStatus (Boolean isStatus) {
        this.isStatus = isStatus;
    }
}