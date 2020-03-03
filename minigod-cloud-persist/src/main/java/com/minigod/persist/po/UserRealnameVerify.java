package com.minigod.persist.po;
import com.minigod.persist.tables.TUserRealnameVerify;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户实名认证表
 */
@Entity(table=TUserRealnameVerify.class)
public class UserRealnameVerify implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer userId;//用户ID
	private String realName;//真实姓名
	private String identityCardNo;//身份证号码
	private Integer sequence = 0;//绑定序号 0表示当前使用记录(有效状态) 其余数字为历史记录
	private Integer verifieErrCount = 0;//实名失败认证次数
	private Date createTime;//记录创建时间
	private Date updateTime;//记录修改时间
	private Integer lockVersion;//乐观锁版本号

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public String getRealName () {
        return realName;
    }

    public void setRealName (String realName) {
        this.realName = realName;
    }

    public String getIdentityCardNo () {
        return identityCardNo;
    }

    public void setIdentityCardNo (String identityCardNo) {
        this.identityCardNo = identityCardNo;
    }

    public Integer getSequence () {
        return sequence;
    }

    public void setSequence (Integer sequence) {
        this.sequence = sequence;
    }

    public Integer getVerifieErrCount () {
        return verifieErrCount;
    }

    public void setVerifieErrCount (Integer verifieErrCount) {
        this.verifieErrCount = verifieErrCount;
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

    public Integer getLockVersion () {
        return lockVersion;
    }

    public void setLockVersion (Integer lockVersion) {
        this.lockVersion = lockVersion;
    }
}