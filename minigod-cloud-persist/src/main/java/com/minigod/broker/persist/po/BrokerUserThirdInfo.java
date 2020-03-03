package com.minigod.broker.persist.po;
import com.minigod.broker.persist.tables.TBrokerUserThirdInfo;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TBrokerUserThirdInfo.class)
public class BrokerUserThirdInfo implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long id;
	private String bandingId;//第三方授权绑定ID
	private Integer bandingType = 2;//2:微信openid
	private String nickName;
	private String headImgUrl;
	private Integer sex;
	private String address;
	private Date createTime;
	private Date updateTime;

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getBandingId () {
        return bandingId;
    }

    public void setBandingId (String bandingId) {
        this.bandingId = bandingId;
    }

    public Integer getBandingType () {
        return bandingType;
    }

    public void setBandingType (Integer bandingType) {
        this.bandingType = bandingType;
    }

    public String getNickName () {
        return nickName;
    }

    public void setNickName (String nickName) {
        this.nickName = nickName;
    }

    public String getHeadImgUrl () {
        return headImgUrl;
    }

    public void setHeadImgUrl (String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public Integer getSex () {
        return sex;
    }

    public void setSex (Integer sex) {
        this.sex = sex;
    }

    public String getAddress () {
        return address;
    }

    public void setAddress (String address) {
        this.address = address;
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