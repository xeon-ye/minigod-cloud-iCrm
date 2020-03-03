/**
 * @Title: GXDepositRequest.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.gateway.vo.req.guoxin;

import com.minigod.api.gateway.vo.req.guoxin.GXRequest;

/**
 * @description 资金查询
 * 
 * @author Jimmy
 * @date 2015-3-12 上午9:54:00
 * @version v1.0
 */

public class GXDepositRequest extends GXRequest {
	private static final long serialVersionUID = 1L;
	// 货币
	private String moneytype;
	// 资金密码
	private String fundpwd;
	// 扩展信息 : 0 - 计算股票市值; 1 - 不算股票市值
	private String ext;

	public String getMoneytype() {
		return moneytype;
	}

	public void setMoneytype(String moneytype) {
		this.moneytype = moneytype;
	}

	public String getFundpwd() {
		return fundpwd;
	}

	public void setFundpwd(String fundpwd) {
		this.fundpwd = fundpwd;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

}
