/**
 * @Title: UserCardReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.resp;

import java.io.Serializable;

/**
 * @description
 * 
 * @author huhu
 * @version v1.0
 */

public class BpmBizResponseVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String userId;
	private String clientId;	//客户号
	private String openFlag;	//预约类型标识
	private String fundAccount;	//资金账号
	private String developSource;	//预约来源：0-网上营业厅,1-账户系统,2-BPM,3-PC客户端,4-手机客户端,5-微信,6-社区
	private String jsonMainData;	//业务数据，具体因业务不同而不同，即根据open_flag不同而不同
	private String beginDate;	//开始时间，格式YYYY-mm-DD
	private String endDate;	//结束时间，格式YYYY-mm-DD

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getOpenFlag() {
		return openFlag;
	}

	public void setOpenFlag(String openFlag) {
		this.openFlag = openFlag;
	}

	public String getFundAccount() {
		return fundAccount;
	}

	public void setFundAccount(String fundAccount) {
		this.fundAccount = fundAccount;
	}

	public String getDevelopSource() {
		return developSource;
	}

	public void setDevelopSource(String developSource) {
		this.developSource = developSource;
	}

	public String getJsonMainData() {
		return jsonMainData;
	}

	public void setJsonMainData(String jsonMainData) {
		this.jsonMainData = jsonMainData;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}
