package com.minigod.persist.po;
import com.minigod.persist.tables.TSecAccImg;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 存取资金图片表
 */
@Entity(table=TSecAccImg.class)
public class SecAccImg implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long accImgId;//图片的id
	private String accImgPath;//存入的路径
	private Date createTime;//创建时间
	private String imageLocationType;//图片类型
	private Integer userId;//用户ID
	private Integer errorStatus;//错误图片状态
	private Integer isFind = 1;//是否全部加载 0 否 1 是
	private Integer serviceType;//图片业务类型 1表示存入资金 2转入股票
	private Long transactId;//图片对应交易流水号

    public Long getAccImgId () {
        return accImgId;
    }

    public void setAccImgId (Long accImgId) {
        this.accImgId = accImgId;
    }

    public String getAccImgPath () {
        return accImgPath;
    }

    public void setAccImgPath (String accImgPath) {
        this.accImgPath = accImgPath;
    }

    public Date getCreateTime () {
        return createTime;
    }

    public void setCreateTime (Date createTime) {
        this.createTime = createTime;
    }

    public String getImageLocationType () {
        return imageLocationType;
    }

    public void setImageLocationType (String imageLocationType) {
        this.imageLocationType = imageLocationType;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public Integer getErrorStatus () {
        return errorStatus;
    }

    public void setErrorStatus (Integer errorStatus) {
        this.errorStatus = errorStatus;
    }

    public Integer getIsFind () {
        return isFind;
    }

    public void setIsFind (Integer isFind) {
        this.isFind = isFind;
    }

    public Integer getServiceType () {
        return serviceType;
    }

    public void setServiceType (Integer serviceType) {
        this.serviceType = serviceType;
    }

    public Long getTransactId () {
        return transactId;
    }

    public void setTransactId (Long transactId) {
        this.transactId = transactId;
    }
}