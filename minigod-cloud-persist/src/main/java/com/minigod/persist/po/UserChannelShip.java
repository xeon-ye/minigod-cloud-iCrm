package com.minigod.persist.po;
import com.minigod.persist.tables.TUserChannelShip;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TUserChannelShip.class)
public class UserChannelShip implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer id;
	private String channelId;
	private Integer type = 1;//1:玖富犇犇，2:玖富股票
	private Date createTime;
	private Boolean isStatus = true;

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

    public Integer getType () {
        return type;
    }

    public void setType (Integer type) {
        this.type = type;
    }

    public Date getCreateTime () {
        return createTime;
    }

    public void setCreateTime (Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getIsStatus () {
        return isStatus;
    }

    public void setIsStatus (Boolean isStatus) {
        this.isStatus = isStatus;
    }
}