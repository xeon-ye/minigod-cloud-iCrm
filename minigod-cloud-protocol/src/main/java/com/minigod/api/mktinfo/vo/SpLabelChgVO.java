/**
 * @Title: SpLabelChgExt.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo;

import java.io.Serializable;
import java.util.List;

import com.minigod.api.mktinfo.vo.resp.StkBaseInfo;

/**
 * @description 存放到redis中使用
 * 
 * @author 谢尚河
 * @date 2015-8-18 下午9:30:20
 * @version v1.0
 */
public class SpLabelChgVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer labId;// 概念ID
	private String labName;
	private Double labChgPct;
	private StkBaseInfo stk;
	private int downNums;// 上涨个数
	private int upNums;// 下跃个数
	private boolean isStatus = true;// 是否可见
	private List<String> assetIds;// 成分股列表

	public boolean isStatus() {
		return isStatus;
	}

	public void setStatus(boolean isStatus) {
		this.isStatus = isStatus;
	}

	public Integer getLabId() {
		return labId;
	}

	public void setLabId(Integer labId) {
		this.labId = labId;
	}

	public String getLabName() {
		return labName;
	}

	public void setLabName(String labName) {
		this.labName = labName;
	}

	public Double getLabChgPct() {
		return labChgPct;
	}

	public void setLabChgPct(Double labChgPct) {
		this.labChgPct = labChgPct;
	}

	public StkBaseInfo getStk() {
		return stk;
	}

	public void setStk(StkBaseInfo stk) {
		this.stk = stk;
	}

	public int getDownNums() {
		return downNums;
	}

	public void setDownNums(int downNums) {
		this.downNums = downNums;
	}

	public int getUpNums() {
		return upNums;
	}

	public void setUpNums(int upNums) {
		this.upNums = upNums;
	}

	public List<String> getAssetIds() {
		return assetIds;
	}

	public void setAssetIds(List<String> assetIds) {
		this.assetIds = assetIds;
	}
	

}
