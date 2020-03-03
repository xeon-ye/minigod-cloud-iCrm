package com.minigod.persist.po;
import com.minigod.persist.tables.TAdviserRecommend;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 牛人推荐信息表
 */
@Entity(table=TAdviserRecommend.class)
public class AdviserRecommend implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer arId;//主键
	private Integer userId;//投顾用户id
	private Integer grade;//排列顺序，数字越小越靠前显示，最小为1
	private String recommendDesc;//推荐简短介绍
	private Boolean isStatus;//状态	0-无效， 1-有效 
	private Date createTime;//创建时间
	private Date updateTime;//修改时间

    public Integer getArId () {
        return arId;
    }

    public void setArId (Integer arId) {
        this.arId = arId;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public Integer getGrade () {
        return grade;
    }

    public void setGrade (Integer grade) {
        this.grade = grade;
    }

    public String getRecommendDesc () {
        return recommendDesc;
    }

    public void setRecommendDesc (String recommendDesc) {
        this.recommendDesc = recommendDesc;
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

    public Date getUpdateTime () {
        return updateTime;
    }

    public void setUpdateTime (Date updateTime) {
        this.updateTime = updateTime;
    }
}