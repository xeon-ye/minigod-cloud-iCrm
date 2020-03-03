package com.minigod.persist.po;
import com.minigod.persist.tables.TSmsCaptcha;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TSmsCaptcha.class)
public class SmsCaptcha implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer captchaId;//验证码id
	private String mobile;//手机号码
	private String captcha;//验证码，6位
	private Date expiresTime;//短信失效时间
	private Date createTime;//信息发送时间
	private Date updateTime;//信息修改时间
	private Boolean isChecked = false;//是否验证过
	private Boolean isUsed = false;//是否使用过
	private Integer validateCount = 0;//验证错误次数

    public Integer getCaptchaId () {
        return captchaId;
    }

    public void setCaptchaId (Integer captchaId) {
        this.captchaId = captchaId;
    }

    public String getMobile () {
        return mobile;
    }

    public void setMobile (String mobile) {
        this.mobile = mobile;
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