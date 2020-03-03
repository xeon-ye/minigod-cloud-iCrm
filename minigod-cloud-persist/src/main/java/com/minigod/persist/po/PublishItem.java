package com.minigod.persist.po;
import com.minigod.persist.tables.TPublishItem;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 帮助中心内容发布信息
 */
@Entity(table=TPublishItem.class)
public class PublishItem implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long id;//主键
	private String name;//目录名称
	private Long parentId;//父目录ID
	private Integer isLeaf;//	是否为叶子节点 1:是 0:否
	private String picon;//图标
	private String message;//目录描述
	private Integer isShare = 1;//是否可分享1:是 0:否
	private Integer isUsed = 1;//	是否有效1:有效 0:失效
	private Date createTime;//创建时间
	private Date updateTime;//修改时间
	private Integer sortId;//排序

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public Long getParentId () {
        return parentId;
    }

    public void setParentId (Long parentId) {
        this.parentId = parentId;
    }

    public Integer getIsLeaf () {
        return isLeaf;
    }

    public void setIsLeaf (Integer isLeaf) {
        this.isLeaf = isLeaf;
    }

    public String getPicon () {
        return picon;
    }

    public void setPicon (String picon) {
        this.picon = picon;
    }

    public String getMessage () {
        return message;
    }

    public void setMessage (String message) {
        this.message = message;
    }

    public Integer getIsShare () {
        return isShare;
    }

    public void setIsShare (Integer isShare) {
        this.isShare = isShare;
    }

    public Integer getIsUsed () {
        return isUsed;
    }

    public void setIsUsed (Integer isUsed) {
        this.isUsed = isUsed;
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

    public Integer getSortId () {
        return sortId;
    }

    public void setSortId (Integer sortId) {
        this.sortId = sortId;
    }
}