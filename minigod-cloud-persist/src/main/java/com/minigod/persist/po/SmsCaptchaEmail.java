package com.minigod.persist.po;
import com.minigod.persist.tables.TSmsCaptchaEmail;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TSmsCaptchaEmail.class)
public class SmsCaptchaEmail implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer captchaId;//验证码id
	private String email;//邮箱地址
	private Integer userid = 0;//用户id
	private String captcha;//验证码，16位
	private Date expiresTime;//验证码失效时间
	private Date createTime;//验证码发送时间
	private Date updateTime;//验证码修改时间
	private Boolean isChecked = false;//是否验证过
	private Boolean isUsed = false;//是否使用过
	private Integer validateCount = 0;//验证错误次数

    public Integer getCaptchaId () {
        return captchaId;
    }

    public void setCaptchaId (Integer captchaId) {
        this.captchaId = captchaId;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public Integer getUserid () {
        return userid;
    }

    public void setUserid (Integer userid) {
        this.userid = userid;
    }

    public String getCaptcha () {
        return captcha;
    }

    public void setCaptcha (String captcha) {
        this.captcha = captcha;
    }

    public Date getExpiresTime () {
        return expiresTime;
    }

    public void setExpiresTime (Date expiresTime) {
        this.expiresTime = expiresTime;
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

    public Boolean getIsChecked () {
        return isChecked;
    }

    public void setIsChecked (Boolean isChecked) {
        this.isChecked = isChecked;
    }

    public Boolean getIsUsed () {
        return isUsed;
    }

    public void setIsUsed (Boolean isUsed) {
        this.isUsed = isUsed;
    }

    public Integer getValidateCount () {
        return validateCount;
    }

    public void setValidateCount (Integer validateCount) {
        this.validateCount = validateCount;
    }
}