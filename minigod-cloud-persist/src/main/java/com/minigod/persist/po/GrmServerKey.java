package com.minigod.persist.po;
import com.minigod.persist.tables.TGrmServerKey;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TGrmServerKey.class)
public class GrmServerKey implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer id;
	private Integer serverId;
	private String aesKey;
	private Date authDate;
	private String authFunctions;
	private String remark;
	private String aesIv;

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public Integer getServerId () {
        return serverId;
    }

    public void setServerId (Integer serverId) {
        this.serverId = serverId;
    }

    public String getAesKey () {
        return aesKey;
    }

    public void setAesKey (String aesKey) {
        this.aesKey = aesKey;
    }

    public Date getAuthDate () {
        return authDate;
    }

    public void setAuthDate (Date authDate) {
        this.authDate = authDate;
    }

    public String getAuthFunctions () {
        return authFunctions;
    }

    public void setAuthFunctions (String authFunctions) {
        this.authFunctions = authFunctions;
    }

    public String getRemark () {
        return remark;
    }

    public void setRemark (String remark) {
        this.remark = remark;
    }

    public String getAesIv () {
        return aesIv;
    }

    public void setAesIv (String aesIv) {
        this.aesIv = aesIv;
    }
}