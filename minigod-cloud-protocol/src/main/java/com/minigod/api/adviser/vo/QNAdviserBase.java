package com.minigod.api.adviser.vo;

import java.io.Serializable;

import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

@TransferBean
public class QNAdviserBase implements Serializable {
	private static final long serialVersionUID = 6494832075593991752L;

	@TransferID
	private Long userId; //用户ID

	private String sessionId; //会话标示
	private Integer sessionUserId; //通过会话找到的用户ID

	@TransferID
	private Long tarUserId;//目标用户ID
	
	private Integer flag;//显示的字段位移
	
	private	Integer  qId; //问题id
	
	private	Integer  aId; //答案id
	
	private	Integer  moreQId; //加载更多 问题id
	
	private	Integer  count; //数量


	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Integer getSessionUserId() {
		return sessionUserId;
	}

	public void setSessionUserId(Integer sessionUserId) {
		this.sessionUserId = sessionUserId;
	}

	public Long getTarUserId() {
		return tarUserId;
	}

	public void setTarUserId(Long tarUserId) {
		this.tarUserId = tarUserId;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public Integer getqId() {
		return qId;
	}

	public void setqId(Integer qId) {
		this.qId = qId;
	}

	public Integer getaId() {
		return aId;
	}

	public void setaId(Integer aId) {
		this.aId = aId;
	}

	public Integer getMoreQId() {
		return moreQId;
	}

	public void setMoreQId(Integer moreQId) {
		this.moreQId = moreQId;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
	
}
