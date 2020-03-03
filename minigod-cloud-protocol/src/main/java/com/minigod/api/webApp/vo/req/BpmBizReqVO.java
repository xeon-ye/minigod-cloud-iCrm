/**
 * @Title: UserCardReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.req;

import com.minigod.api.webApp.vo.req.JsonMainDataVO;

import java.io.Serializable;

/**
 * @description
 * 
 * @author huhu
 * @version v1.0
 */

public class BpmBizReqVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String userId;
	private String sessionId;
	private String bpm_fc;	//功能号
	private String client_id;	//客户号
	private String password; //交易密码
	private String open_flag;	//预约类型标识
	private String fund_account;	//资金账号
	private String develop_source;	//预约来源：0-网上营业厅,1-账户系统,2-BPM,3-PC客户端,4-手机客户端,5-微信,6-社区
	private JsonMainDataVO jsonMainData;	//业务数据，具体因业务不同而不同，即根据open_flag不同而不同
	private String begin_date;	//开始时间，格式YYYY-mm-DD
	private String end_date;	//结束时间，格式YYYY-mm-DD

	private Integer eventId;//事件ID，获取验证码成功后传给前端
	private String captcha;//验证码
	private String phoneNum; //手机号
	private Integer  id_kind;//证件类型
	private String id_no; //证件号码

	private Integer type; //类型

	private String openaccountaccept_id;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getBpm_fc() {
		return bpm_fc;
	}

	public void setBpm_fc(String bpm_fc) {
		this.bpm_fc = bpm_fc;
	}

	public String getClient_id() {
		return client_id;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOpen_flag() {
		return open_flag;
	}

	public void setOpen_flag(String open_flag) {
		this.open_flag = open_flag;
	}

	public String getFund_account() {
		return fund_account;
	}

	public void setFund_account(String fund_account) {
		this.fund_account = fund_account;
	}

	public String getDevelop_source() {
		return develop_source;
	}

	public void setDevelop_source(String develop_source) {
		this.develop_source = develop_source;
	}

	public JsonMainDataVO getJsonMainData() {
		return jsonMainData;
	}

	public void setJsonMainData(JsonMainDataVO jsonMainData) {
		this.jsonMainData = jsonMainData;
	}

	public String getBegin_date() {
		return begin_date;
	}

	public void setBegin_date(String begin_date) {
		this.begin_date = begin_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public Integer getId_kind() {
		return id_kind;
	}

	public void setId_kind(Integer id_kind) {
		this.id_kind = id_kind;
	}

	public String getId_no() {
		return id_no;
	}

	public void setId_no(String id_no) {
		this.id_no = id_no;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getOpenaccountaccept_id() {
		return openaccountaccept_id;
	}

	public void setOpenaccountaccept_id(String openaccountaccept_id) {
		this.openaccountaccept_id = openaccountaccept_id;
	}
}
