package com.minigod.persist.po;
import com.minigod.persist.tables.TPayWxAcc;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TPayWxAcc.class)
public class PayWxAcc implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer wxMatchId;//对应ID
	private Integer accountId;//账户表ID
	private String appid;//公众账号ID
	private String openid;//微信OpenId
	private String unionid;//微信UnionId
	private Date createTime;//记录创建时间
	private Date updateTime;//记录修改时间

    public Integer getWxMatchId () {
        return wxMatchId;
    }

    public void setWxMatchId (Integer wxMatchId) {
        this.wxMatchId = wxMatchId;
    }

    public Integer getAccountId () {
        return accountId;
    }

    public void setAccountId (Integer accountId) {
        this.accountId = accountId;
    }

    public String getAppid () {
        return appid;
    }

    public void setAppid (String appid) {
        this.appid = appid;
    }

    public String getOpenid () {
        return openid;
    }

    public void setOpenid (String openid) {
        this.openid = openid;
    }

    public String getUnionid () {
        return unionid;
    }

    public void setUnionid (String unionid) {
        this.unionid = unionid;
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