/**
 * @Title: OrderRequest.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.broker.vo.req;

import com.minigod.api.broker.vo.req.SNRequest;
import com.minigod.api.ptf.vo.enums.EOrderDirection;
import com.minigod.api.ptf.vo.enums.EOrderExchMkt;
import com.minigod.api.ptf.vo.enums.EOrderProperty;

/**
 * @description 下单请求
 * 
 * @author Jimmy
 * @date 2015-3-9 下午8:40:50
 * @version v1.0
 */

public class OrderRequest extends SNRequest {
	private static final long serialVersionUID = 1L;
	// 交易市场
	private EOrderExchMkt exchangeType;
	// 股东号
	private String stkAcc;
	// 密码
	private String password;
	// 股票代码
	private String stkCode;
	// 委托数量
	private Double ordQty;
	// 委托价格
	private Double ordPrice;
	// 委托方向
	private EOrderDirection ordBs;
	// 委托属性
	private EOrderProperty ordProp;
	// 回话号
	private String sessionId;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public EOrderExchMkt getExchangeType() {
		return exchangeType;
	}

	public void setExchangeType(EOrderExchMkt exchangeType) {
		this.exchangeType = exchangeType;
	}

	public String getStkAcc() {
		return stkAcc;
	}

	public void setStkAcc(String stkAcc) {
		this.stkAcc = stkAcc;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStkCode() {
		return stkCode;
	}

	public void setStkCode(String stkCode) {
		this.stkCode = stkCode;
	}

	public Double getOrdQty() {
		return ordQty;
	}

	public void setOrdQty(Double ordQty) {
		this.ordQty = ordQty;
	}

	public Double getOrdPrice() {
		return ordPrice;
	}

	public void setOrdPrice(Double ordPrice) {
		this.ordPrice = ordPrice;
	}

	public EOrderDirection getOrdBs() {
		return ordBs;
	}

	public void setOrdBs(EOrderDirection ordBs) {
		this.ordBs = ordBs;
	}

	public EOrderProperty getOrdProp() {
		return ordProp;
	}

	public void setOrdProp(EOrderProperty ordProp) {
		this.ordProp = ordProp;
	}

}
