package com.minigod.api.ptf.vo.req;

import java.io.Serializable;

import com.minigod.api.ptf.vo.enums.EOrderExchMkt;
import com.minigod.api.ptf.vo.enums.EOrderProperty;
import com.minigod.api.ptf.vo.enums.simu_stk_ord.ESimuBusType;

public class SimuStockOrderVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/** 股票代码 */
	private String stkCode;
	
	/** 委托数量 */
	private Double ordQty;
	
	/** 委托价格 */
	private Double ordPrc;
	
	/** 委托方向 */
	private ESimuBusType ordBS;
	
	/** 委托属性 */
	private EOrderProperty ordProp;
	
	/** 交易市场 */
	private EOrderExchMkt exchType;

	public String getStkCode() {
		return stkCode;
	}

	public void setStkCode(String stkCode) {
		this.stkCode = stkCode;
	}

	public Double getOrdQty() {
		return ordQty;
	}

	public void setOrdQty(Double ordAmt) {
		this.ordQty = ordAmt;
	}

	public Double getOrdPrc() {
		return ordPrc;
	}

	public void setOrdPrc(Double ordPrc) {
		this.ordPrc = ordPrc;
	}

	public ESimuBusType getOrdBS() {
		return ordBS;
	}

	public void setOrdBS(ESimuBusType ordBS) {
		this.ordBS = ordBS;
	}

	public EOrderProperty getOrdProp() {
		return ordProp;
	}

	public void setOrdProp(EOrderProperty ordProp) {
		this.ordProp = ordProp;
	}

	public EOrderExchMkt getExchType() {
		return exchType;
	}

	public void setExchType(EOrderExchMkt exchType) {
		this.exchType = exchType;
	}
	
}