package com.minigod.api.mktmgr.vo.req;

import java.io.Serializable;

import com.minigod.api.vo.BaseVO;
import com.minigod.common.anno.TransferBean;

/** 
 * 注册、登录对象 
 */

@TransferBean
public class ReqPcUserInfo extends BaseVO implements Serializable {

	private static final long serialVersionUID = -1163833696907526399L;

	private Integer certType;//凭证类型(0-手机,1-邮箱,2-微信,3-微博,4-QQ)
	private String certCode;//凭证内容(手机号、邮箱、QQ号，微博号、微信号、minigod用户名、OpenID等)

	private String pwd;
	private Integer eventId;

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public Integer getCertType() {
		return certType;
	}

	public void setCertType(Integer certType) {
		this.certType = certType;
	}

	public String getCertCode() {
		return certCode;
	}

	public void setCertCode(String certCode) {
		this.certCode = certCode;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
