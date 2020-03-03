package com.minigod.persist.po;
import com.minigod.persist.tables.TUserReq;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户申请内测资格的记录
 */
@Entity(table=TUserReq.class)
public class UserReq implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer reqId;//申请ID
	private Integer certType;//凭证类型2-微信unionid
	private String certCode;
	private String mobile;
	private Integer dealStatus;//处理结果
	private Boolean isStatus;//记录状态
	private Date createTime;//创建时间
	private Date updateTime;//最后修改时间

    public Integer getReqId () {
        return reqId;
    }

    public void setReqId (Integer reqId) {
        this.reqId = reqId;
    }

    public Integer getCertType () {
        return certType;
    }

    public void setCertType (Integer certType) {
        this.certType = certType;
    }

    public String getCertCode () {
        return certCode;
    }

    public void setCertCode (String certCode) {
        this.certCode = certCode;
    }

    public String getMobile () {
        return mobile;
    }

    public void setMobile (String mobile) {
        this.mobile = mobile;
    }

    public Integer getDealStatus () {
        return dealStatus;
    }

    public void setDealStatus (Integer dealStatus) {
        this.dealStatus = dealStatus;
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