package com.minigod.persist.po;
import com.minigod.persist.tables.TFileDownload;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TFileDownload.class)
public class FileDownload implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long id;//主键
	private String fileName;//文件名称
	private String downloadUrl;//文件路径
	private Integer busyType;//业务类型
	private Date createTime;
	private Date updateTime;

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getFileName () {
        return fileName;
    }

    public void setFileName (String fileName) {
        this.fileName = fileName;
    }

    public String getDownloadUrl () {
        return downloadUrl;
    }

    public void setDownloadUrl (String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public Integer getBusyType () {
        return busyType;
    }

    public void setBusyType (Integer busyType) {
        this.busyType = busyType;
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