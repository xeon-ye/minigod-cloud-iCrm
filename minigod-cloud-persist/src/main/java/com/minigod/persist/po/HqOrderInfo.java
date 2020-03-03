package com.minigod.persist.po;
import com.minigod.persist.tables.THqOrderInfo;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=THqOrderInfo.class)
public class HqOrderInfo implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long orderId;
	private Integer orderNum = 1;//下单数
	private Long packageId;//套餐ID
	private Long userId;//用户ID
	private String orderWay;//1，自购 2，赠送
	private Date createTime;//创建时间
	private Boolean isStatus = true;//0-无效，1-有效
	private Double orderAmount = 0.0000d;//应付金额
	private Double realAmount = 0.0000d;//实付金额
	private String remark;

    public Long getOrderId () {
        return orderId;
    }

    public void setOrderId (Long orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderNum () {
        return orderNum;
    }

    public void setOrderNum (Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Long getPackageId () {
        return packageId;
    }

    public void setPackageId (Long packageId) {
        this.packageId = packageId;
    }

    public Long getUserId () {
        return userId;
    }

    public void setUserId (Long userId) {
        this.userId = userId;
    }

    public String getOrderWay () {
        return orderWay;
    }

    public void setOrderWay (String orderWay) {
        this.orderWay = orderWay;
    }

    public Date getCreateTime () {
        return createTime;
    }

    public void setCreateTime (Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getIsStatus () {
        return isStatus;
    }

    public void setIsStatus (Boolean isStatus) {
        this.isStatus = isStatus;
    }

    public Double getOrderAmount () {
        return orderAmount;
    }

    public void setOrderAmount (Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Double getRealAmount () {
        return realAmount;
    }

    public void setRealAmount (Double realAmount) {
        this.realAmount = realAmount;
    }

    public String getRemark () {
        return remark;
    }

    public void setRemark (String remark) {
        this.remark = remark;
    }
}