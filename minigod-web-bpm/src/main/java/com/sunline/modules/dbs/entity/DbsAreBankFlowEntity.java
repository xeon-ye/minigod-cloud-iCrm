package com.sunline.modules.dbs.entity;
import java.io.Serializable;
import java.util.Date;



/**
 * DBS银行手续费流水
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2020-05-18 13:25:16
 */
public class DbsAreBankFlowEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//自增ID
	private Long id;
	//请求流水号
	private String msgId;
	//来源交易流水
	private String sourceMsgId;
	//请求状态:0-系统异常；1-成功
	private String reqStatus;
	//响应状态:ACSP-查询成功；RJCT-查询失败；PART-查询成功记录超过1000
	private String enqStatus;
	//请求报文
	private String reqMessage;
	//请求时间
	private Date reqTime;
	//响应报文
	private String resMessage;
	//响应时间
	private Date resTime;
	//创建人
	private String createUser;
	//修改人
	private String updateUser;
	//创建时间
	private Date createTime;
	//更新时间
	private Date updateTime;

	/**
	 * 设置：自增ID
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：自增ID
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：请求流水号
	 */
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	/**
	 * 获取：请求流水号
	 */
	public String getMsgId() {
		return msgId;
	}
	/**
	 * 设置：来源交易流水
	 */
	public void setSourceMsgId(String sourceMsgId) {
		this.sourceMsgId = sourceMsgId;
	}
	/**
	 * 获取：来源交易流水
	 */
	public String getSourceMsgId() {
		return sourceMsgId;
	}
	/**
	 * 设置：请求状态:0-系统异常；1-成功
	 */
	public void setReqStatus(String reqStatus) {
		this.reqStatus = reqStatus;
	}
	/**
	 * 获取：请求状态:0-系统异常；1-成功
	 */
	public String getReqStatus() {
		return reqStatus;
	}
	/**
	 * 设置：响应状态:ACSP-查询成功；RJCT-查询失败；PART-查询成功记录超过1000
	 */
	public void setEnqStatus(String enqStatus) {
		this.enqStatus = enqStatus;
	}
	/**
	 * 获取：响应状态:ACSP-查询成功；RJCT-查询失败；PART-查询成功记录超过1000
	 */
	public String getEnqStatus() {
		return enqStatus;
	}
	/**
	 * 设置：请求报文
	 */
	public void setReqMessage(String reqMessage) {
		this.reqMessage = reqMessage;
	}
	/**
	 * 获取：请求报文
	 */
	public String getReqMessage() {
		return reqMessage;
	}
	/**
	 * 设置：请求时间
	 */
	public void setReqTime(Date reqTime) {
		this.reqTime = reqTime;
	}
	/**
	 * 获取：请求时间
	 */
	public Date getReqTime() {
		return reqTime;
	}
	/**
	 * 设置：响应报文
	 */
	public void setResMessage(String resMessage) {
		this.resMessage = resMessage;
	}
	/**
	 * 获取：响应报文
	 */
	public String getResMessage() {
		return resMessage;
	}
	/**
	 * 设置：响应时间
	 */
	public void setResTime(Date resTime) {
		this.resTime = resTime;
	}
	/**
	 * 获取：响应时间
	 */
	public Date getResTime() {
		return resTime;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取：创建人
	 */
	public String getCreateUser() {
		return createUser;
	}
	/**
	 * 设置：修改人
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	/**
	 * 获取：修改人
	 */
	public String getUpdateUser() {
		return updateUser;
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
