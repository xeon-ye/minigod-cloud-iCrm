/**
 * @Title: SkipFollowRequestVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.req;

import java.io.Serializable;
import java.util.List;

import com.minigod.api.ptf.vo.resp.PtfFlagDetailsVO.SaleInfo;
import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.vo.BaseVO;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 *
 * @description 从券商端创建组合
 */
@TransferBean
public class CreatePtfFromBrokerRequestVO extends SNVersion {

	private static final long serialVersionUID = 1L;

	@TransferID
	@Emoji
	CreatePtfFromBrokerVO params;

	public CreatePtfFromBrokerVO getParams() {
		return params;
	}

	public void setParams(CreatePtfFromBrokerVO params) {
		this.params = params;
	}
	
	@TransferBean
	public static class CreatePtfFromBrokerVO extends BaseVO implements Serializable {

		private static final long serialVersionUID = 1L;

		private Integer brkId;    
		private String custId;
		@Emoji
		private String name;
		private List<String> assetIds;
		private Integer perm;
		private String desc;
		
		@TransferID
		private List<Long> uIds;
		
		private String authShare;	
		
		
		private SaleInfo saleInfo;
		
		
		
		
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
		public SaleInfo getSaleInfo() {
			return saleInfo;
		}
		public void setSaleInfo(SaleInfo saleInfo) {
			this.saleInfo = saleInfo;
		}
		public Integer getPerm() {
			return perm;
		}
		public void setPerm(Integer perm) {
			this.perm = perm;
		}
		public List<Long> getuIds() {
			return uIds;
		}
		public void setuIds(List<Long> uIds) {
			this.uIds = uIds;
		}
		public String getAuthShare() {
			return authShare;
		}
		public void setAuthShare(String authShare) {
			this.authShare = authShare;
		}
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
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public List<String> getAssetIds() {
			return assetIds;
		}
		public void setAssetIds(List<String> assetIds) {
			this.assetIds = assetIds;
		}
		
	}
}
