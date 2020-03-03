package com.minigod.persist.po;
import com.minigod.persist.tables.TUserThirdpartyInfo;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TUserThirdpartyInfo.class)
public class UserThirdpartyInfo implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer id;
	private String nickName;
	private String headImgUrl;
	private Integer sex;
	private String address;
	private Date createTime;
	private String accountNo;
	private Date updateTime;

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
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

    public String getAccountNo () {
        return accountNo;
    }

    public void setAccountNo (String accountNo) {
        this.accountNo = accountNo;
    }

    public Date getUpdateTime () {
        return updateTime;
    }

    public void setUpdateTime (Date updateTime) {
        this.updateTime = updateTime;
    }
}