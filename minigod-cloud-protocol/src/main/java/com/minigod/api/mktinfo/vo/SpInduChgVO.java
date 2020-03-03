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
public class SpInduChgVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String induCode;// 行业编码
	private String induName;// 行业名称
	private Double induChgPct;// 行业涨跌幅
	private StkBaseInfo stk;// 领涨股信息
	private int downNums;// 上涨个数
	private int upNums;// 下跃个数
	private boolean isStatus = true;// 是否可见
	private List<String> assetIds;// 成分股列表

	public String getInduCode() {
		return induCode;
	}

	public void setInduCode(String induCode) {
		this.induCode = induCode;
	}

	public String getInduName() {
		return induName;
	}

	public void setInduName(String induName) {
		this.induName = induName;
	}

	public Double getInduChgPct() {
		return induChgPct;
	}

	public void setInduChgPct(Double induChgPct) {
		this.induChgPct = induChgPct;
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

	public boolean isStatus() {
		return isStatus;
	}

	public void setStatus(boolean isStatus) {
		this.isStatus = isStatus;
	}

	public List<String> getAssetIds() {
		return assetIds;
	}

	public void setAssetIds(List<String> assetIds) {
		this.assetIds = assetIds;
	}

}
