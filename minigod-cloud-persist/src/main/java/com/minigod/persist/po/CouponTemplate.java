package com.minigod.persist.po;
import com.minigod.persist.tables.TCouponTemplate;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 卡券模板表
 */
@Entity(table=TCouponTemplate.class)
public class CouponTemplate implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer templateId;//主键
	private String title;//卡券标题
	private String description;//卡券描述
	private Integer type;//卡券类型，1:加息券
	private String unit;//卡券单位，如 加息券 在界面上要显示 “2%”那么这里就配置 “%”，代金券要显示“5元“那么这里就配置”元
	private BigDecimal denomination;//卡券面值，与卡券类型一一对应，如果是加息券，不超过1.0000
	private Integer interestAddDay;//有效天数：与加息券相关，可以用于加息的天数
	private Date createTime;//创建时间
	private Date updateTime;//更新时间
	private Integer lockVersion = 0;//乐观锁版本号

    public Integer getTemplateId () {
        return templateId;
    }

    public void setTemplateId (Integer templateId) {
        this.templateId = templateId;
    }

    public String getTitle () {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription (String description) {
        this.description = description;
    }

    public Integer getType () {
        return type;
    }

    public void setType (Integer type) {
        this.type = type;
    }

    public String getUnit () {
        return unit;
    }

    public void setUnit (String unit) {
        this.unit = unit;
    }

    public BigDecimal getDenomination () {
        return denomination;
    }

    public void setDenomination (BigDecimal denomination) {
        this.denomination = denomination;
    }

    public Integer getInterestAddDay () {
        return interestAddDay;
    }

    public void setInterestAddDay (Integer interestAddDay) {
        this.interestAddDay = interestAddDay;
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