package com.minigod.persist.po;
import com.minigod.persist.tables.TDistributeSaveTmp;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TDistributeSaveTmp.class)
public class DistributeSaveTmp implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long id;//主键
	private Integer userId;//用户ID
	private String info;//字符串信息
	private Integer step;//步骤
	private Integer type;//功能标识
	private String name;//功能名称
	private Date createdTime;//创建时间
	private Date updatedTime;//修改时间

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

    public Integer getStep () {
        return step;
    }

    public void setStep (Integer step) {
        this.step = step;
    }

    public Integer getType () {
        return type;
    }

    public void setType (Integer type) {
        this.type = type;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public Date getCreatedTime () {
        return createdTime;
    }

    public void setCreatedTime (Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime () {
        return updatedTime;
    }

    public void setUpdatedTime (Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}