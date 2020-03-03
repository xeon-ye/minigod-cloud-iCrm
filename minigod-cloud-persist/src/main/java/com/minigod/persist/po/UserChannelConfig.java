package com.minigod.persist.po;
import com.minigod.persist.tables.TUserChannelConfig;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TUserChannelConfig.class)
public class UserChannelConfig implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer id;
	private String channelId;
	private String url;
	private Boolean isStatus = true;
	private String logo;
	private Date createTime;
	private Integer type = 1;//1:普通 2：定制

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public String getChannelId () {
        return channelId;
    }

    public void setChannelId (String channelId) {
        this.channelId = channelId;
    }

    public String getUrl () {
        return url;
    }

    public void setUrl (String url) {
        this.url = url;
    }

    public Boolean getIsStatus () {
        return isStatus;
    }

    public void setIsStatus (Boolean isStatus) {
        this.isStatus = isStatus;
    }

    public String getLogo () {
        return logo;
    }

    public void setLogo (String logo) {
        this.logo = logo;
    }

    public Date getCreateTime () {
        return createTime;
    }

    public void setCreateTime (Date createTime) {
        this.createTime = createTime;
    }

    public Integer getType () {
        return type;
    }

    public void setType (Integer type) {
        this.type = type;
    }
}