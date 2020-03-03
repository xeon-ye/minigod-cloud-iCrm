package com.minigod.persist.po;
import com.minigod.persist.tables.TOpenUserDev;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TOpenUserDev.class)
public class OpenUserDev implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long id;//自增主键
	private Integer userId;//用户id
	private Date createTime;//时间戳
	private String idcard;//身份证
	private String rname;//实名
	private String bankcard;//银行卡
	private String bankcode;//银行代码
	private Date riskStartTime;//风批开始时间
	private Date riskEndTime;//风批结束时间
	private String phoneInfo;//手机信息
	private String UIP;

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime () {
        return createTime;
    }

    public void setCreateTime (Date createTime) {
        this.createTime = createTime;
    }

    public String getIdcard () {
        return idcard;
    }

    public void setIdcard (String idcard) {
        this.idcard = idcard;
    }

    public String getRname () {
        return rname;
    }

    public void setRname (String rname) {
        this.rname = rname;
    }

    public String getBankcard () {
        return bankcard;
    }

    public void setBankcard (String bankcard) {
        this.bankcard = bankcard;
    }

    public String getBankcode () {
        return bankcode;
    }

    public void setBankcode (String bankcode) {
        this.bankcode = bankcode;
    }

    public Date getRiskStartTime () {
        return riskStartTime;
    }

    public void setRiskStartTime (Date riskStartTime) {
        this.riskStartTime = riskStartTime;
    }

    public Date getRiskEndTime () {
        return riskEndTime;
    }

    public void setRiskEndTime (Date riskEndTime) {
        this.riskEndTime = riskEndTime;
    }

    public String getPhoneInfo () {
        return phoneInfo;
    }

    public void setPhoneInfo (String phoneInfo) {
        this.phoneInfo = phoneInfo;
    }

    public String getUIP () {
        return UIP;
    }

    public void setUIP (String UIP) {
        this.UIP = UIP;
    }
}