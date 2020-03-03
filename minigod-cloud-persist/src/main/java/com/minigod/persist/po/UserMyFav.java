package com.minigod.persist.po;
import com.minigod.persist.tables.TUserMyFav;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 我的收藏
 */
@Entity(table=TUserMyFav.class)
public class UserMyFav implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer userMyFavId;//主键ID
	private Integer userId;//用户ID
	private String title;//标题
	private String busiTabName;//收藏对象对应的表名
	private String busiPkId;//收藏对象对应的表主键
	private String url;//url
	private Date createTime;//创建时间
	private Date updateTime;//更新时间
	private Boolean isStatus;//记录是否有效，1有效，0无效

    public Integer getUserMyFavId () {
        return userMyFavId;
    }

    public void setUserMyFavId (Integer userMyFavId) {
        this.userMyFavId = userMyFavId;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public String getTitle () {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public String getBusiTabName () {
        return busiTabName;
    }

    public void setBusiTabName (String busiTabName) {
        this.busiTabName = busiTabName;
    }

    public String getBusiPkId () {
        return busiPkId;
    }

    public void setBusiPkId (String busiPkId) {
        this.busiPkId = busiPkId;
    }

    public String getUrl () {
        return url;
    }

    public void setUrl (String url) {
        this.url = url;
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