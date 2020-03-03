package com.minigod.api.ptf.vo.req;

import com.minigod.api.vo.BaseVO;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;


/**
 * 
 * @description 组合新增股票预检
 *
 * @author MiniGod
 * @date 2015-3-30 上午11:14:22
 * @version v1.0
 */
@TransferBean
public class CheckAddStksVO extends BaseVO {

	private static final long serialVersionUID = 1L;
	
	@TransferID
	private Long ptfId; // 组合编号
	
	private Integer brkId; // 券商ID
	private String custId; // 券商用户ID
	private String[] assetIds; // 资产ID集
	public Long getPtfId() {
		return ptfId;
	}
	public void setPtfId(Long ptfId) {
		this.ptfId = ptfId;
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
	public String[] getAssetIds() {
		return assetIds;
	}
	public void setAssetIds(String[] assetIds) {
		this.assetIds = assetIds;
	}
}
