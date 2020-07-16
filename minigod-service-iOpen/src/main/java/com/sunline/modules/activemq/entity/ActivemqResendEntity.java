package com.sunline.modules.activemq.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * activemq消息推送失败列表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2019-07-08 09:12:37
 */
public class ActivemqResendEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//自增id
	private Integer id;
	//业务名
	private String bizCode;
	//1-queue 2-topic
	private Integer publishtype;
	//消息内容
	private String message;
	//1-成功 2-失败
	private Integer status;
	//创建时间
	private Date createTime;
	//更新时间
	private Date updateTime;

	/**
	 * 设置：自增id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：自增id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：业务名
	 */
	public void setBizCode(String bizCode) {
		this.bizCode = bizCode;
	}
	/**
	 * 获取：业务名
	 */
	public String getBizCode() {
		return bizCode;
	}
	/**
	 * 设置：1-queue 2-topic
	 */
	public void setPublishtype(Integer publishtype) {
		this.publishtype = publishtype;
	}
	/**
	 * 获取：1-queue 2-topic
	 */
	public Integer getPublishtype() {
		return publishtype;
	}
	/**
	 * 设置：消息内容
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * 获取：消息内容
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * 设置：1-成功 2-失败
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：1-成功 2-失败
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
}
