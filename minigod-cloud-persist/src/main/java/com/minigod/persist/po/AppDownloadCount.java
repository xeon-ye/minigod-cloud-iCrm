package com.minigod.persist.po;
import com.minigod.persist.tables.TAppDownloadCount;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * app下载次数统计
 */
@Entity(table=TAppDownloadCount.class)
public class AppDownloadCount implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private String channelId;//渠道ID
	private Integer downloadCount;//下载次数统计
	private Date createTime;//创建时间
	private Date updatedTime;//修改时间

    public String getChannelId () {
        return channelId;
    }

    public void setChannelId (String channelId) {
        this.channelId = channelId;
    }

    public Integer getDownloadCount () {
        return downloadCount;
    }

    public void setDownloadCount (Integer downloadCount) {
        this.downloadCount = downloadCount;
    }

    public Date getCreateTime () {
        return createTime;
    }

    public void setCreateTime (Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdatedTime () {
        return updatedTime;
    }

    public void setUpdatedTime (Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}