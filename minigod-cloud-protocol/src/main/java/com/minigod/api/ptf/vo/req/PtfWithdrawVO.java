/**
 * @Title: PtfWithdrawVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */
package com.minigod.api.ptf.vo.req;

import java.io.Serializable;
import java.util.List;

import com.minigod.api.ptf.vo.enums.EOrderExchMkt;
import com.minigod.api.vo.BaseVO;

/**
 * @description 组合委托撤单请求值对象
 *
 * @author minigod
 * @date 2015-3-31 下午2:22:49
 * @version v1.0
 */

public class PtfWithdrawVO extends BaseVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer brkId; // 券商id
	
	private String custId; // 券商端客户编号
	
	private Integer ptfTransId; // 交易id
	
	private List<WithdrawOrds> ords; // 撤单明细

	public Integer getBrkId() {
		return brkId;
	}

	public void setBrkId(Integer brkId) {
		this.brkId = brkId;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public Integer getPtfTransId() {
		return ptfTransId;
	}

	public void setPtfTransId(Integer ptfTransId) {
		this.ptfTransId = ptfTransId;
	}
	
	public List<WithdrawOrds> getOrds() {
		return ords;
	}

	public void setOrds(List<WithdrawOrds> ords) {
		this.ords = ords;
	}
	
	/**
	 * @description 撤单委托明细
	 *
	 * @author minigod
	 * @date 2015-3-31 下午4:32:12
	 * @version v1.0
	 */
	public static class WithdrawOrds implements Serializable {
		
		private static final long serialVersionUID = 1L;
		
		private String stkCode;
		
		private String stkAcc;
		
		private EOrderExchMkt exchType;
		
		private String ordSeq;

		public String getStkCode() {
			return stkCode;
		}

		public void setStkCode(String stkCode) {
			this.stkCode = stkCode;
		}

		public String getOrdSeq() {
			return ordSeq;
		}

		public void setOrdSeq(String ordSeq) {
			this.ordSeq = ordSeq;
		}

		public String getStkAcc() {
			return stkAcc;
		}

		public void setStkAcc(String stkAcc) {
			this.stkAcc = stkAcc;
		}

		public EOrderExchMkt getExchType() {
			return exchType;
		}

		public void setExchType(EOrderExchMkt exchType) {
			this.exchType = exchType;
		}

	}
	
}
