package com.sunline.modules.customer.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 行情表
 *
 * @author lcs
 * @email 
 * @date 2018-11-14 16:47:30
 */
public class UserHqInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;
    /**
     *  id
     */
    private String  userStreamId ;
    /**
     * 行情ID
     */
	private String packageId;
    /**
     * 小神号
     */
	private Integer userId;
    /**
     * 服务开始时间
     */
	private String startTime;
    /**
     * 服务结束时间
     */
	private String endTime;
    /**
     * 创建时间
     */
	private String createTime;
    /**
     * 修改时间
     */
	private Date updateTime;
    /**
     *  '0-无效，1-有效',
     */
	private Integer isStatus;
    /**
     * '0过期,1正常',
     */
	private Integer isExpire;
    /**
     * '0-个人，1-共享',
     */
	private Integer isShare;

    /**
     *  港股/美股
     * @return
     */
    private Integer marketType;

    /**
     * 套餐名称
     */
    private String packageName;

    /**
     * 累计时长
     * @return
     */
    private String hqTotalTime;

    public String getUserStreamId() {
        return userStreamId;
    }

    public void setUserStreamId(String userStreamId) {
        this.userStreamId = userStreamId;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsStatus() {
        return isStatus;
    }

    public void setIsStatus(Integer isStatus) {
        this.isStatus = isStatus;
    }

    public Integer getIsExpire() {
        return isExpire;
    }

    public void setIsExpire(Integer isExpire) {
        this.isExpire = isExpire;
    }

    public Integer getIsShare() {
        return isShare;
    }

    public void setIsShare(Integer isShare) {
        this.isShare = isShare;
    }

    public Integer getMarketType() {
        return marketType;
    }

    public void setMarketType(Integer marketType) {
        this.marketType = marketType;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getHqTotalTime() {
        return hqTotalTime;
    }

    public void setHqTotalTime(String hqTotalTime) {
        this.hqTotalTime = hqTotalTime;
    }
}
