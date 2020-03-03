package com.minigod.persist.po;
import com.minigod.persist.tables.TUserCertInvalid;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户登录凭证失效表
 */
@Entity(table=TUserCertInvalid.class)
public class UserCertInvalid implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer certId;//登录方式ID
	private Integer userId;//用户ID
	private Integer certType;//凭证类型(0-手机,1-邮箱,2-微信,3-微博,4-QQ,5-微信unionid,6-微信齐牛公众号 openid)
	private String certCode;
	private Boolean isValid = false;//是否已经验证(针对手机号和邮件，0未验证，1已验证)
	private Boolean isLogin = true;//能否用于登录(1-能，2-不能)
	private Boolean isStatus = true;//记录状态
	private Date createTime;//创建时间
	private Date updateTime;//最后修改时间(默认1有效，0无效)
	private Integer lockVersion;//乐观锁版本号

    public Integer getCertId () {
        return certId;
    }

    public void setCertId (Integer certId) {
        this.certId = certId;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
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

    public Boolean getIsValid () {
        return isValid;
    }

    public void setIsValid (Boolean isValid) {
        this.isValid = isValid;
    }

    public Boolean getIsLogin () {
        return isLogin;
    }

    public void setIsLogin (Boolean isLogin) {
        this.isLogin = isLogin;
    }

    public Boolean getIsStatus () {
        return isStatus;
    }

    public void setIsStatus (Boolean isStatus) {
        this.isStatus = isStatus;
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

    public Integer getLockVersion () {
        return lockVersion;
    }

    public void setLockVersion (Integer lockVersion) {
        this.lockVersion = lockVersion;
    }
}