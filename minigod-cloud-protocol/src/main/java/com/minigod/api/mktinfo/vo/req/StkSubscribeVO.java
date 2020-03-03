/**
 * @Title: StkSubscribeVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.vo.BaseVO;

import java.util.List;

/**
 * <code>StkSubscribeVO</code>
 * 
 * @author Jimmy
 * @date 2015-7-1 下午2:14:40
 * @version v1.0
 */
public class StkSubscribeVO extends BaseVO {
	private static final long serialVersionUID = 1L;
	/** 通道ID */
	private String chnId;
	/** 功能号 */
	private String funIds;
	/** 订阅功能对应的内容 */
	private List<String> assetIds;
	/** 请求编号 */
	private Long reqNo;

	/** 资金账号 */
	private String fundAccount;
	
	public String getChnId() {
		return chnId;
	}

	public void setChnId(String chnId) {
		this.chnId = chnId;
	}

	public List<String> getAssetIds() {
		return assetIds;
	}

	public void setAssetIds(List<String> assetIds) {
		this.assetIds = assetIds;
	}

	public String getFunIds() {
		return funIds;
	}

	public void setFunIds(String funIds) {
		this.funIds = funIds;
	}

	public Long getReqNo() {
		return reqNo;
	}

	public void setReqNo(Long reqNo) {
		this.reqNo = reqNo;
	}

	public String getFundAccount() {
		return fundAccount;
	}

	public void setFundAccount(String fundAccount) {
		this.fundAccount = fundAccount;
	}
}
