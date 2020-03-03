/**
 * @Title: LoginInVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.broker.vo.resp;

import java.io.Serializable;
import java.util.List;

/**
 * @description登录响应
 *
 * @author 周永昌
 * @date 2015年4月20日 上午11:20:24
 * @version v1.0
 */

public class LoginResponseVO implements Serializable {
	private static final long serialVersionUID = 1L;
	// 资金账号
	private String dpsAcc;
	// 客户号
	private String cid;
	// 客户名称
	private String cnm;
	// 股东账号信息
	private List<StkAccInfoVO> inf;

	public String getDpsAcc() {
		return dpsAcc;
	}

	public void setDpsAcc(String dpsAcc) {
		this.dpsAcc = dpsAcc;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCnm() {
		return cnm;
	}

	public void setCnm(String cnm) {
		this.cnm = cnm;
	}

	public List<StkAccInfoVO> getInf() {
		return inf;
	}

	public void setInf(List<StkAccInfoVO> inf) {
		this.inf = inf;
	}

}
