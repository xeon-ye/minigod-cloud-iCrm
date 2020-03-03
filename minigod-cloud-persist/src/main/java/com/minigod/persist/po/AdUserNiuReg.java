package com.minigod.persist.po;
import com.minigod.persist.tables.TAdUserNiuReg;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TAdUserNiuReg.class)
public class AdUserNiuReg implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer id;
	private Integer adId;//广告id
	private Integer userId;//用户id
	private String type;//R-抽到红包，G-抽到金币，E-兑换奖品
	private Integer targetId;//目标id(牛人活动中为牛人用户id,默认为0)
	private Date createTime;

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public Integer getAdId () {
        return adId;
    }

    public void setAdId (Integer adId) {
        this.adId = adId;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public String getType () {
        return type;
    }

    public void setType (String type) {
        this.type = type;
    }

    public Integer getTargetId () {
        return targetId;
    }

    public void setTargetId (Integer targetId) {
        this.targetId = targetId;
    }

    public Date getCreateTime () {
        return createTime;
    }

    public void setCreateTime (Date createTime) {
        this.createTime = createTime;
    }
}