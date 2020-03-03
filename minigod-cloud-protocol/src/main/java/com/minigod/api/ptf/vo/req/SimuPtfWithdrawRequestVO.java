/**
 * @Title: PtfWithdrawRequestVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.req;

import java.io.Serializable;
import java.util.List;

import com.minigod.api.ptf.vo.enums.EOrderExchMkt;
import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.vo.BaseVO;

/**
 * @description 模拟组合撤单请求值对象
 *
 * @author minigod
 * @date 2015-3-31 下午2:14:06
 * @version v1.0
 */

public class SimuPtfWithdrawRequestVO extends SNVersion {

	private static final long serialVersionUID = 1L;
	
	private SimuPtfWithdrawVO params;

	public SimuPtfWithdrawVO getParams() {
		return params;
	}

	public void setParams(SimuPtfWithdrawVO params) {
		this.params = params;
	}
	
	public class SimuPtfWithdrawVO extends BaseVO implements Serializable {

		private static final long serialVersionUID = 1L;

		private Integer ptfTransId; // 交易id
		
		private List<SimuWithdrawOrds> ords; // 撤单明细


		public Integer getPtfTransId() {
			return ptfTransId;
		}

		public void setPtfTransId(Integer ptfTransId) {
			this.ptfTransId = ptfTransId;
		}
		
		public List<SimuWithdrawOrds> getOrds() {
			return ords;
		}

		public void setOrds(List<SimuWithdrawOrds> ords) {
			this.ords = ords;
		}
		
	}
	
	
	/**
	 * @description 撤单委托明细
	 *
	 * @author minigod
	 * @date 2015-3-31 下午4:32:12
	 * @version v1.0
	 */
	public static class SimuWithdrawOrds implements Serializable {
		
		private static final long serialVersionUID = 1L;
		
		private String stkCode;
		
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

		public EOrderExchMkt getExchType() {
			return exchType;
		}

		public void setExchType(EOrderExchMkt exchType) {
			this.exchType = exchType;
		}

	}
	
	
	
	
}
