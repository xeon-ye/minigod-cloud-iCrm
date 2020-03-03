package com.minigod.persist.po;
import com.minigod.persist.tables.TGameUserInfo;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TGameUserInfo.class)
public class GameUserInfo implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer gameUserId;
	private Integer certType;//凭证类型(6-微信齐牛公众号openid)
	private String certCode;//凭证内容(微信openid等)
	private String nickName;//昵称
	private String userIcon;//头像
	private String unionId;//微信union_id
	private Boolean isSubscribe;//是否关注公众号
	private Integer successNum = 0;//推荐成功次数(每次荐股盈亏为正加一)
	private Double totalYield = 0.0000d;//累计收益率
	private Date createTime;//创建时间
	private Date updateTime;//更新时间

    public Integer getGameUserId () {
        return gameUserId;
    }

    public void setGameUserId (Integer gameUserId) {
        this.gameUserId = gameUserId;
    }

    public Integer getCertType () {
        return certType;
    }

    public void setCertType (Integer certType) {
        this.certType = certType;
    }

    public String getCertCode () {
        return certCode;
    }

    public void setCertCode (String certCode) {
        this.certCode = certCode;
    }

    public String getNickName () {
        return nickName;
    }

    public void setNickName (String nickName) {
        this.nickName = nickName;
    }

    public String getUserIcon () {
        return userIcon;
    }

    public void setUserIcon (String userIcon) {
        this.userIcon = userIcon;
    }

    public String getUnionId () {
        return unionId;
    }

    public void setUnionId (String unionId) {
        this.unionId = unionId;
    }

    public Boolean getIsSubscribe () {
        return isSubscribe;
    }

    public void setIsSubscribe (Boolean isSubscribe) {
        this.isSubscribe = isSubscribe;
    }

    public Integer getSuccessNum () {
        return successNum;
    }

    public void setSuccessNum (Integer successNum) {
        this.successNum = successNum;
    }

    public Double getTotalYield () {
        return totalYield;
    }

    public void setTotalYield (Double totalYield) {
        this.totalYield = totalYield;
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