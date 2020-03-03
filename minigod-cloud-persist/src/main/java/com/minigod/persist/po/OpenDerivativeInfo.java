package com.minigod.persist.po;
import com.minigod.persist.tables.TOpenDerivativeInfo;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 衍生品申请信息表
 */
@Entity(table=TOpenDerivativeInfo.class)
public class OpenDerivativeInfo implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long id;//主键
	private Integer userId;//用户ID
	private String info;//申请信息
	private Date createTime;//创建时间
	private Date updateTime;//更新时间

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

    public String getInfo () {
        return info;
    }

    public void setInfo (String info) {
        this.info = info;
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