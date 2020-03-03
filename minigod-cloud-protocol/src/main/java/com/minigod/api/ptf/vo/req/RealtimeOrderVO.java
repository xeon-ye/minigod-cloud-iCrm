/**
 * @Title: BrokerLoginInfoVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.req;

import java.io.Serializable;
import java.util.List;

import com.minigod.api.vo.BaseVO;

/**
 * @description 组合委托请求值对象
 *
 * @author minigod
 * @date 2015-3-17 下午20:19:34
 * @version v1.0
 */

public class RealtimeOrderVO extends BaseVO {

	private static final long serialVersionUID = 1L;
	
	private Integer ptfTransId; // 组合交易id
	
	private List<RealtimeOrder> ords;//委托股票列表
	
	public Integer getPtfTransId() {
		return ptfTransId;
	}

	public void setPtfTransId(Integer ptfTransId) {
		this.ptfTransId = ptfTransId;
	}

	public List<RealtimeOrder> getOrds() {
		return ords;
	}

	public void setOrds(List<RealtimeOrder> ords) {
		this.ords = ords;
	}

	public static class RealtimeOrder implements Serializable {
		
		private static final long serialVersionUID = 1L;

		private String stkCode; // 股票代码
		
		private String stat; // 请求状态
		
		private Long reqTime; // 委托时间
		
		private String exchType; // 交易市场
		
		private String brkRetCode; // 返回码
		
		private String brkRetMsg; // 返回信息
		
		private String ctcId; // 合同序号
		
		private String ordSeq; // 委托编号

		public String getStkCode() {
			return stkCode;
		}

		public void setStkCode(String stkCode) {
			this.stkCode = stkCode;
		}

		public String getStat() {
			return stat;
		}

		public void setStat(String stat) {
			this.stat = stat;
		}

		public Long getReqTime() {
			return reqTime;
		}

		public void setReqTime(Long reqTime) {
			this.reqTime = reqTime;
		}

		public String getExchType() {
			return exchType;
		}

		public void setExchType(String exchType) {
			this.exchType = exchType;
		}

		public String getBrkRetCode() {
			return brkRetCode;
		}

		public void setBrkRetCode(String brkRetCode) {
			this.brkRetCode = brkRetCode;
		}

		public String getBrkRetMsg() {
			return brkRetMsg;
		}

		public void setBrkRetMsg(String brkRetMsg) {
			this.brkRetMsg = brkRetMsg;
		}

		public String getOrdSeq() {
			return ordSeq;
		}

		public void setOrdSeq(String ordSeq) {
			this.ordSeq = ordSeq;
		}
		
		public String getCtcId() {
			return ctcId;
		}

		public void setCtcId(String ctcId) {
			this.ctcId = ctcId;
		}
		
	}
	
}
