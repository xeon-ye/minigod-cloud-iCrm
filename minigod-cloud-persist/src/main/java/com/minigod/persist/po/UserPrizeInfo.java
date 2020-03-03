package com.minigod.persist.po;
import com.minigod.persist.tables.TUserPrizeInfo;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TUserPrizeInfo.class)
public class UserPrizeInfo implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer id;
	private Integer userId;//用户ID
	private String wxId;//用户微信ID
	private Integer prizeNum = 0;//奖品类别，0默认没有
	private String prizeName = "";//奖品名称
	private Date createTime = new Date();//创建时间
	private String address = "";//用户地址
	private Integer isCheck = 0;//是否抽奖
	private Integer status = 0;//默认状态：0：有效，1无效

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

    public String getWxId () {
        return wxId;
    }

    public void setWxId (String wxId) {
        this.wxId = wxId;
    }

    public Integer getPrizeNum () {
        return prizeNum;
    }

    public void setPrizeNum (Integer prizeNum) {
        this.prizeNum = prizeNum;
    }

    public String getPrizeName () {
        return prizeName;
    }

    public void setPrizeName (String prizeName) {
        this.prizeName = prizeName;
    }

    public Date getCreateTime () {
        return createTime;
    }

    public void setCreateTime (Date createTime) {
        this.createTime = createTime;
    }

    public String getAddress () {
        return address;
    }

    public void setAddress (String address) {
        this.address = address;
    }

    public Integer getIsCheck () {
        return isCheck;
    }

    public void setIsCheck (Integer isCheck) {
        this.isCheck = isCheck;
    }

    public Integer getStatus () {
        return status;
    }

    public void setStatus (Integer status) {
        this.status = status;
    }
}