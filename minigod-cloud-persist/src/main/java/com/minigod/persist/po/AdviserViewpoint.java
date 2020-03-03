package com.minigod.persist.po;
import com.minigod.persist.tables.TAdviserViewpoint;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TAdviserViewpoint.class)
public class AdviserViewpoint implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long viewpointId;//观点id
	private String clientReqId;//客户端防重发唯一编码
	private Integer userId;//用户id
	private String viewpointType;//观点类型(P-观点)
	private String busContent;//业务信息
	private Integer readNum;//阅读数初始为0
	private Integer realReadNum = 0;
	private Boolean isStatus;//观点状态(0-无效，1-有效)
	private Date createTime;//创建时间
	private Date updateTime;//修改时间

    public Long getViewpointId () {
        return viewpointId;
    }

    public void setViewpointId (Long viewpointId) {
        this.viewpointId = viewpointId;
    }

    public String getClientReqId () {
        return clientReqId;
    }

    public void setClientReqId (String clientReqId) {
        this.clientReqId = clientReqId;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public String getViewpointType () {
        return viewpointType;
    }

    public void setViewpointType (String viewpointType) {
        this.viewpointType = viewpointType;
    }

    public String getBusContent () {
        return busContent;
    }

    public void setBusContent (String busContent) {
        this.busContent = busContent;
    }

    public Integer getReadNum () {
        return readNum;
    }

    public void setReadNum (Integer readNum) {
        this.readNum = readNum;
    }

    public Integer getRealReadNum () {
        return realReadNum;
    }

    public void setRealReadNum (Integer realReadNum) {
        this.realReadNum = realReadNum;
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