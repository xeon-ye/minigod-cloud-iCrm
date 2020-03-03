package com.minigod.persist.po;
import com.minigod.persist.tables.TUserAdReg;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TUserAdReg.class)
public class UserAdReg implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer adRegId;//广告登记ID
	private Integer userId;//用户ID
	private Integer adId;//广告id
	private Integer openCount = 0;//打开次数
	private Boolean isClose = true;//显示状态(0-关闭，1-展示)
	private Date createTime;//创建时间
	private Date updateTime;//修改时间

    public Integer getAdRegId () {
        return adRegId;
    }

    public void setAdRegId (Integer adRegId) {
        this.adRegId = adRegId;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public Integer getAdId () {
        return adId;
    }

    public void setAdId (Integer adId) {
        this.adId = adId;
    }

    public Integer getOpenCount () {
        return openCount;
    }

    public void setOpenCount (Integer openCount) {
        this.openCount = openCount;
    }

    public Boolean getIsClose () {
        return isClose;
    }

    public void setIsClose (Boolean isClose) {
        this.isClose = isClose;
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