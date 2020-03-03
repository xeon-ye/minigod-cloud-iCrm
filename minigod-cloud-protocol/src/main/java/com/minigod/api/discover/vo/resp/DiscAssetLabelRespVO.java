package com.minigod.api.discover.vo.resp;

import com.minigod.api.discover.vo.resp.DiscAssetLVO;
import com.minigod.api.discover.vo.resp.DiscLabelVO;

import java.io.Serializable;
import java.util.List;

/**
 * <code>DiscAssetLabelRespVO<code>
 *
 * @author Jane
 * @since MiniGod v0.0.1 (2014-12-05)
 *
 */
public class DiscAssetLabelRespVO implements Serializable {

	private static final long serialVersionUID = 1L;

	// 概念集
	private List<DiscLabelVO> labelList;
	// 股票集
	private List<DiscAssetLVO> assetList;

	/**
	 * @return the labelList
	 */
	public List<DiscLabelVO> getLabelList() {
		return labelList;
	}

	/**
	 * @param labelList
	 *            the labelList to set
	 */
	public void setLabelList(List<DiscLabelVO> labelList) {
		this.labelList = labelList;
	}

	/**
	 * @return the assetList
	 */
	public List<DiscAssetLVO> getAssetList() {
		return assetList;
	}

	/**
	 * @param assetList
	 *            the assetList to set
	 */
	public void setAssetList(List<DiscAssetLVO> assetList) {
		this.assetList = assetList;
	}

}
