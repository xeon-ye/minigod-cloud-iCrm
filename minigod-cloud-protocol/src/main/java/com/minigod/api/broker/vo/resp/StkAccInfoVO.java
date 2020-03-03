/**
 * @Title: StkAccInfo.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.broker.vo.resp;

import java.io.Serializable;

import com.minigod.api.ptf.vo.enums.EOrderExchMkt;

/**
 * @description 登录股东信息
 *
 * @author 余俊斌
 * @date 2015年6月29日 下午5:14:16
 * @version v1.0
 */

public class StkAccInfoVO implements Serializable {

	private static final long serialVersionUID = 1L;
	// 股东账号
	private String acc;
	// 市场代码
	private EOrderExchMkt mkt;

	public String getAcc() {
		return acc;
	}

	public void setAcc(String acc) {
		this.acc = acc;
	}

	public EOrderExchMkt getMkt() {
		return mkt;
	}

	public void setMkt(EOrderExchMkt mkt) {
		this.mkt = mkt;
	}

}
