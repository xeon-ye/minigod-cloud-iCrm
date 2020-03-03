package com.minigod.persist.po;
import com.minigod.persist.tables.TUserQrCode;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TUserQrCode.class)
public class UserQrCode implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer id;
	private Integer userId;
	private String channelId;
	private String qrCode;
	private Integer type = 1;//1:用户渠道二维码 
	private Date createTime;

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public String getChannelId () {
        return channelId;
    }

    public void setChannelId (String channelId) {
        this.channelId = channelId;
    }

    public String getQrCode () {
        return qrCode;
    }

    public void setQrCode (String qrCode) {
        this.qrCode = qrCode;
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
}