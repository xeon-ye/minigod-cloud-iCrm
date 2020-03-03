package com.minigod.persist.po;
import com.minigod.persist.tables.TPtfNoteInteraction;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 组合投资日历互动表
 */
@Entity(table=TPtfNoteInteraction.class)
public class PtfNoteInteraction implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer interId;//互动ID
	private String clientReqId;
	private Integer ptfNoteId;//日历ID
	private String interType;//互动类型。R-回复（reply）；L-点赞（like）
	private Integer fromUser;//发表用户ID
	private Integer toUser;//回复对象ID
	private String content;
	private Boolean isStatus;//记录状态
	private Date createTime;//创建时间
	private Date updateTime;//修改时间
	private Integer noteUser;//主贴发表人ID

    public Integer getInterId () {
        return interId;
    }

    public void setInterId (Integer interId) {
        this.interId = interId;
    }

    public String getClientReqId () {
        return clientReqId;
    }

    public void setClientReqId (String clientReqId) {
        this.clientReqId = clientReqId;
    }

    public Integer getPtfNoteId () {
        return ptfNoteId;
    }

    public void setPtfNoteId (Integer ptfNoteId) {
        this.ptfNoteId = ptfNoteId;
    }

    public String getInterType () {
        return interType;
    }

    public void setInterType (String interType) {
        this.interType = interType;
    }

    public Integer getFromUser () {
        return fromUser;
    }

    public void setFromUser (Integer fromUser) {
        this.fromUser = fromUser;
    }

    public Integer getToUser () {
        return toUser;
    }

    public void setToUser (Integer toUser) {
        this.toUser = toUser;
    }

    public String getContent () {
        return content;
    }

    public void setContent (String content) {
        this.content = content;
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

    public Integer getNoteUser () {
        return noteUser;
    }

    public void setNoteUser (Integer noteUser) {
        this.noteUser = noteUser;
    }
}