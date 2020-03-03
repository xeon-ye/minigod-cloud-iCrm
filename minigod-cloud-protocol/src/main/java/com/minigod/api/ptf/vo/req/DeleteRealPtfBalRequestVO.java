package com.minigod.api.ptf.vo.req;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.vo.BaseVO;
import com.minigod.common.anno.TransferBean;


@TransferBean
public class DeleteRealPtfBalRequestVO extends SNVersion {
	
	private static final long serialVersionUID = 1L;
	
	private DeleteRealPtfBalVO params;

	public DeleteRealPtfBalVO getParams() {
		return params;
	}

	public void setParams(DeleteRealPtfBalVO params) {
		this.params = params;
	}
	
	public class DeleteRealPtfBalVO extends BaseVO {

		private static final long serialVersionUID = 1;
		
		private Integer brkId;
		
		private String custId;
		
		private Integer ptfBalId;

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

		public Integer getPtfBalId() {
			return ptfBalId;
		}

		public void setPtfBalId(Integer ptfBalId) {
			this.ptfBalId = ptfBalId;
		}
	}


}
