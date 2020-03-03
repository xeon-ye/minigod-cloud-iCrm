package com.minigod.persist.po;
import com.minigod.persist.tables.TPublishContent;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 帮助中心目录配置表
 */
@Entity(table=TPublishContent.class)
public class PublishContent implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long id;//主键
	private String title;//标题
	private String content;//内容
	private Long resourceId;//对应目录ID
	private Integer isShare;//	是否可分享1:是 0:否
	private Integer isCommon;//	是否是常见问题 1:是 0：否
	private Date createTime;//创建时间
	private Date updateTime;//修改时间
	private Integer isUsed;
	private Integer sortId;//排序编号
	private Integer clicks = 0;

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
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

    public Long getResourceId () {
        return resourceId;
    }

    public void setResourceId (Long resourceId) {
        this.resourceId = resourceId;
    }

    public Integer getIsShare () {
        return isShare;
    }

    public void setIsShare (Integer isShare) {
        this.isShare = isShare;
    }

    public Integer getIsCommon () {
        return isCommon;
    }

    public void setIsCommon (Integer isCommon) {
        this.isCommon = isCommon;
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

    public Integer getIsUsed () {
        return isUsed;
    }

    public void setIsUsed (Integer isUsed) {
        this.isUsed = isUsed;
    }

    public Integer getSortId () {
        return sortId;
    }

    public void setSortId (Integer sortId) {
        this.sortId = sortId;
    }

    public Integer getClicks () {
        return clicks;
    }

    public void setClicks (Integer clicks) {
        this.clicks = clicks;
    }
}