/**
 * @Title: LoginInRequest.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.broker.vo.req;

import com.minigod.api.broker.vo.enums.EBrkAccountType;

/**
 * @description
 *
 * @author 周永昌
 * @date 2015年4月18日 下午5:31:21
 * @version v1.0
 */

public class LoginRequest extends SNRequest {
	private static final long serialVersionUID = 1L;
	// 密码
	private String pwd;
	// 账户类型
	private EBrkAccountType accType;
	// 账号
	private String acc;
	// 操作站点
	private String opSta;
	// imei
	private String imei;
	// uuid
	private String uuid;

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public EBrkAccountType getAccType() {
		return accType;
	}

	public void setAccType(EBrkAccountType accType) {
		this.accType = accType;
	}

	public String getAcc() {
		return acc;
	}

	public void setAcc(String acc) {
		this.acc = acc;
	}

	public String getOpSta() {
		return opSta;
	}

	public void setOpSta(String opSta) {
		this.opSta = opSta;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

}
