package com.sunline.modules.notice.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: 消息发送中心
 * @author: Larry Lai
 * @date: 2018/9/29 15:17
 * @version: v1.0
 */

public class MessageSendInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Integer id;
	//消息类型[0-未知 1-邮件 2-短信 3-统一消息中心推送接口]
	private Integer messageType;
	//接收人
	private String recipients;
	//标题
	private String messageTitle;
	//内容
	private String messageContent;
	// 内容类型[0-text 1-html]
	private Integer contentType;
	//附件地址
	private String attachmentUris;
	//发送结果[0-未知 1-待处理 2-成功 3-失败 4-处理中 5-未处理]
	private Integer sendResult;
	//创建时间
	private Date createTime;
	//更新时间
	private Date updateTime;
	//备注
	private String comment;

	/**
	 * 设置：全局ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：全局ID
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：消息类型[enum MessageNoticeType]
	 */
	public void setMessageType(Integer messageType) {
		this.messageType = messageType;
	}
	/**
	 * 获取：消息类型[enum MessageNoticeType]
	 */
	public Integer getMessageType() {
		return messageType;
	}
	/**
	 * 设置：接收人
	 */
	public void setRecipients(String recipients) {
		this.recipients = recipients;
	}
	/**
	 * 获取：接收人
	 */
	public String getRecipients() {
		return recipients;
	}
	/**
	 * 设置：标题
	 */
	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}
	/**
	 * 获取：标题
	 */
	public String getMessageTitle() {
		return messageTitle;
	}
	/**
	 * 设置：内容
	 */
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	/**
	 * 获取：内容
	 */
	public String getMessageContent() {
		return messageContent;
	}
	/**
	 * 设置：附件地址
	 */
	public void setAttachmentUris(String attachmentUris) {
		this.attachmentUris = attachmentUris;
	}
	/**
	 * 获取：附件地址
	 */
	public String getAttachmentUris() {
		return attachmentUris;
	}
	/**
	 * 设置：发送结果[enum CommonProcessStatus]
	 */
	public void setSendResult(Integer sendResult) {
		this.sendResult = sendResult;
	}
	/**
	 * 获取：发送结果[enum CommonProcessStatus]
	 */
	public Integer getSendResult() {
		return sendResult;
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
	/**
	 * 设置：备注
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	/**
	 * 获取：备注
	 */
	public String getComment() {
		return comment;
	}

    public Integer getContentType() {
        return contentType;
    }

    public void setContentType(Integer contentType) {
        this.contentType = contentType;
    }
}
