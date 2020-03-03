package com.minigod.persist.po;
import com.minigod.persist.tables.TPtfNote;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 组合投资日历表
 */
@Entity(table=TPtfNote.class)
public class PtfNote implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer ptfNoteId;//日历ID
	private String cNoteId;
	private Integer ptfId;//组合ID
	private Integer userId;//用户ID
	private Integer ptfCreatorId;//组合创建人Id
	private String noteType;//日历类型
	private String busContent;
	private Boolean isReal;//是否实盘
	private Boolean isStatus;//记录状态
	private Date createTime;//创建时间
	private Date updateTime;//更新时间
	private Integer ptfTransId;

    public Integer getPtfNoteId () {
        return ptfNoteId;
    }

    public void setPtfNoteId (Integer ptfNoteId) {
        this.ptfNoteId = ptfNoteId;
    }

    public String getCNoteId () {
        return cNoteId;
    }

    public void setCNoteId (String cNoteId) {
        this.cNoteId = cNoteId;
    }

    public Integer getPtfId () {
        return ptfId;
    }

    public void setPtfId (Integer ptfId) {
        this.ptfId = ptfId;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public Integer getPtfCreatorId () {
        return ptfCreatorId;
    }

    public void setPtfCreatorId (Integer ptfCreatorId) {
        this.ptfCreatorId = ptfCreatorId;
    }

    public String getNoteType () {
        return noteType;
    }

    public void setNoteType (String noteType) {
        this.noteType = noteType;
    }

    public String getBusContent () {
        return busContent;
    }

    public void setBusContent (String busContent) {
        this.busContent = busContent;
    }

    public Boolean getIsReal () {
        return isReal;
    }

    public void setIsReal (Boolean isReal) {
        this.isReal = isReal;
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

    public Integer getPtfTransId () {
        return ptfTransId;
    }

    public void setPtfTransId (Integer ptfTransId) {
        this.ptfTransId = ptfTransId;
    }
}