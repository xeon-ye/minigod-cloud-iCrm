package com.minigod.persist.po;
import com.minigod.persist.tables.TReleaseDevice;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TReleaseDevice.class)
public class ReleaseDevice implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer id;
	private String deviceCode;
	private Boolean isStatus = true;//0-无效，1-有效
	private Date createTime;

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public String getDeviceCode () {
        return deviceCode;
    }

    public void setDeviceCode (String deviceCode) {
        this.deviceCode = deviceCode;
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
}