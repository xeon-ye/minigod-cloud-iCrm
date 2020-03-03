package com.minigod.persist.po;
import com.minigod.persist.tables.TAdviserNote;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TAdviserNote.class)
public class AdviserNote implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer adviserNoteId;
	private Long viewpointId;//观点id
	private Integer grade;//精选观点等级(0-默认排序，数字越高等级越高）
	private Integer createOpr;//创建人id
	private Integer updateOpr;//更新人id
	private Boolean isStatus;//是否发布（0-未发布,1-发布)
	private Date updateTime;//更新时间
	private Date createTime;//创建时间

    public Integer getAdviserNoteId () {
        return adviserNoteId;
    }

    public void setAdviserNoteId (Integer adviserNoteId) {
        this.adviserNoteId = adviserNoteId;
    }

    public Long getViewpointId () {
        return viewpointId;
    }

    public void setViewpointId (Long viewpointId) {
        this.viewpointId = viewpointId;
    }

    public Integer getGrade () {
        return grade;
    }

    public void setGrade (Integer grade) {
        this.grade = grade;
    }

    public Integer getCreateOpr () {
        return createOpr;
    }

    public void setCreateOpr (Integer createOpr) {
        this.createOpr = createOpr;
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

    public Date getUpdateTime () {
        return updateTime;
    }

    public void setUpdateTime (Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime () {
        return createTime;
    }

    public void setCreateTime (Date createTime) {
        this.createTime = createTime;
    }
}