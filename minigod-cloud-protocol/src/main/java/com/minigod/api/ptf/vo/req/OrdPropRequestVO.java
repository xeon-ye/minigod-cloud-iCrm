/**
 * @Title: SkipFollowRequestVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.req;

import java.io.Serializable;
import java.util.List;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.vo.BaseVO;
import com.minigod.common.anno.TransferBean;

/**
 *
 * @description 组合委托属性预检
 */
@TransferBean
public class OrdPropRequestVO extends SNVersion {

	private static final long serialVersionUID = 1L;

	private OrdPropVOWraper params;
	
	public OrdPropVOWraper getParams() {
		return params;
	}

	public void setParams(OrdPropVOWraper params) {
		this.params = params;
	}

	public static class OrdPropVOWraper extends BaseVO implements Serializable{
		private static final long serialVersionUID = 1L;
		
		private List<OrdPropVO> stks;

		public List<OrdPropVO> getStks() {
			return stks;
		}

		public void setStks(List<OrdPropVO> stks) {
			this.stks = stks;
		}
	}


	public static class OrdPropVO implements Serializable {
		private static final long serialVersionUID = 1L;

		// 股票代码
		private String stkCode;
		
		// 交易市场
		private String exchType;
		
		public String getStkCode() {
			return stkCode;
		}
		
		public void setStkCode(String stkCode) {
			this.stkCode = stkCode;
		}
		
		
		public String getExchType() {
			return exchType;
		}
		
		public void setExchType(String exchType) {
			this.exchType = exchType;
		}
		
	}

	
	
}
