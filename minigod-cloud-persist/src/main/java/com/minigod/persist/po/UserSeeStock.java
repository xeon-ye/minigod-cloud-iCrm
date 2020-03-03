package com.minigod.persist.po;
import com.minigod.persist.tables.TUserSeeStock;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 正在看此个股的人
 */
@Entity(table=TUserSeeStock.class)
public class UserSeeStock implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer id;
	private String assetId;
	private Integer userId;
	private Date createTime;
	private Date updateTime;
	private Date expTime;

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public String getAssetId () {
        return assetId;
    }

    public void setAssetId (String assetId) {
        this.assetId = assetId;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
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

    public Date getExpTime () {
        return expTime;
    }

    public void setExpTime (Date expTime) {
        this.expTime = expTime;
    }
}