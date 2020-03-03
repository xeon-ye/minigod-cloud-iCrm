/**
 * @Title: LoginInRequest.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.broker.vo.req;

import com.minigod.api.broker.vo.req.SNRequest;

/**
 * @description
 *
 * @author 周永昌
 * @date 2015年4月18日 下午5:31:21
 * @version v1.0
 */

public class LoginInRequest extends SNRequest {
	private static final long serialVersionUID = 1L;
	// 密码
	private String pwd;
	// 账户类型
	private String accType;
	// 操作站点
	private String opSta;

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public String getOpSta() {
		return opSta;
	}

	public void setOpSta(String opSta) {
		this.opSta = opSta;
	}

}
