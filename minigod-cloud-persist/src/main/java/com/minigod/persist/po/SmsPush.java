package com.minigod.persist.po;
import com.minigod.persist.tables.TSmsPush;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TSmsPush.class)
public class SmsPush implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer smsPushId;//推送id，主键，发送一条记录一条
	private String clientid;
	private Integer pushType;//推送类型:0打开应用；1打开通知；2点击下载（暂不用）；3透传信息
	private String title;
	private String content;
	private Integer osType;//设备类型
	private Date createTime;//创建时间
	private Date updateTime;//更新时间
	private Boolean isStatus;//记录是否有效

    public Integer getSmsPushId () {
        return smsPushId;
    }

    public void setSmsPushId (Integer smsPushId) {
        this.smsPushId = smsPushId;
    }

    public String getClientid () {
        return clientid;
    }

    public void setClientid (String clientid) {
        this.clientid = clientid;
    }

    public Integer getPushType () {
        return pushType;
    }

    public void setPushType (Integer pushType) {
        this.pushType = pushType;
    }

    public String getTitle () {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public String getContent () {
        return content;
    }

    public void setContent (String content) {
        this.content = content;
    }

    public Integer getOsType () {
        return osType;
    }

    public void setOsType (Integer osType) {
        this.osType = osType;
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

    public Boolean getIsStatus () {
        return isStatus;
    }

    public void setIsStatus (Boolean isStatus) {
        this.isStatus = isStatus;
    }
}