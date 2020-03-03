package com.minigod.api.adviser.vo.params;

import java.math.BigDecimal;

import com.minigod.api.adviser.vo.QNAdviserBase;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
@TransferBean
public class QaAsk extends QNAdviserBase  {

	private static final long serialVersionUID = -6148586421924205449L;
	
	private Integer qType ; //问题类型 1股票，2大盘，3其它
	@Emoji
	private String content ; //问题内容
	
	private String assetId ; //资产id
	
	private BigDecimal price ; //成本价
	
	private String position ; //仓位

	public Integer getqType() {
		return qType;
	}

	public void setqType(Integer qType) {
		this.qType = qType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
}
