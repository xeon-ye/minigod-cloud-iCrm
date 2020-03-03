package com.minigod.api.discover.vo.resp;

import com.minigod.api.vo.BaseVO;

/**
 * <code>DiscAssetVO<code>
 * 
 * @author Jane
 * @since MiniGod v0.0.1 (2014-12-05)
 * 
 */
public class DiscAssetLVO extends BaseVO {

	private static final long serialVersionUID = 1L;

	private String name;// 股票名

	private String id;// 自定义的股票ID

	private Integer stkType; // 股票类型

	private Integer status;// 状态 0正常交易 1涨停 2跌停 3停牌，4 表示退市 5.未上市
	
	private String fav;//是否已关注

	private Integer lotSize;//每手股数

	private Integer secType;//证券类别

	private Integer secStype;//细分类别

	public Integer getStkType() {
		return stkType;
	}

	public void setStkType(Integer stkType) {
		this.stkType = stkType;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	public String getFav() {
		return fav;
	}

	public void setFav(String fav) {
		this.fav = fav;
	}

	public Integer getLotSize() {
		return lotSize;
	}

	public void setLotSize(Integer lotSize) {
		this.lotSize = lotSize;
	}

	public Integer getSecType() {
		return secType;
	}

	public void setSecType(Integer secType) {
		this.secType = secType;
	}

	public Integer getSecStype() {
		return secStype;
	}

	public void setSecStype(Integer secStype) {
		this.secStype = secStype;
	}
}
