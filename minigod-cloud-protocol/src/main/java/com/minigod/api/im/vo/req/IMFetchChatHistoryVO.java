/**
 * @Title: IMFetchChatHistoryVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.req;

import com.minigod.api.vo.BaseVO;

/**
 * @description 
 *
 * @author Jimmy
 * @date 2015-10-21 上午11:14:31
 * @version v1.0
 */

public class IMFetchChatHistoryVO extends BaseVO {
	private static final long serialVersionUID = 1L;
	
	private String chatType;//聊天的类型 : G – 群聊, C – 单聊
	private String imId; // 环信ID 当chatType为G时, 代表是群组的ID. 为C时代表个人的环信ID
	private String msgId;	// 消息的ID 分页用, 为空时返回最新的count条记录. 不为空时, 返回msgId之前的count条数据
	private Integer count = 15;	// 默认是15条
	
	public String getChatType() {
		return chatType;
	}
	public void setChatType(String chatType) {
		this.chatType = chatType;
	}
	public String getImId() {
		return imId;
	}
	public void setImId(String imId) {
		this.imId = imId;
	}
	public String getMsgId() {
		return msgId;
	}
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
}
