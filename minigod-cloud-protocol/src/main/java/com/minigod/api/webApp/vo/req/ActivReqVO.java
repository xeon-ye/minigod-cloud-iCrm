/**
 * @Title: UserCardReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.req;

import java.io.Serializable;
import java.util.List;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2015-12-9 下午4:52:47
 * @version v1.0
 */

public class ActivReqVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String sessionId;
	private String activCfgItemId;//奖励项目Id
	private String rwdRecordId;//奖励记录Id
	private List<Long> rwdRecordIdList;//奖励id列表
	private String fundAccount;//资金账号
	private String cashApply;//测试上线许去除
	
	private String requestSrc;//请求来源：ios，Android，H5
	
	public String getRequestSrc() {
		return requestSrc;
	}
	public void setRequestSrc(String requestSrc) {
		this.requestSrc = requestSrc;
	}
	public String getCashApplyTest() {
		return cashApply;
	}
	public void setCashApplyTest(String cashApplyTest) {
		this.cashApply = cashApplyTest;
	}
	public String getFundAccount() {
		return fundAccount;
	}
	public void setFundAccount(String fundAccount) {
		this.fundAccount = fundAccount;
	}
	public List<Long> getRwdRecordIdList() {
		return rwdRecordIdList;
	}
	public void setRwdRecordIdList(List<Long> rwdRecordIdList) {
		this.rwdRecordIdList = rwdRecordIdList;
	}
	
	public String getActivCfgItemId() {
		return activCfgItemId;
	}

	public void setActivCfgItemId(String activCfgItemId) {
		this.activCfgItemId = activCfgItemId;
	}

	public String getRwdRecordId() {
		return rwdRecordId;
	}

	public void setRwdRecordId(String rwdRecordId) {
		this.rwdRecordId = rwdRecordId;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
}
