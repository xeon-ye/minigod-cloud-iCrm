package com.minigod.api.discover.vo.resp;

import java.io.Serializable;

/**
 * <code>DiscAssetRespVO<code>
 * 
 * @author Jane
 * @since MiniGod v0.0.1 (2014-12-04)
 * 
 */
public class DiscAssetRespVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;// 股票ID
	private String name;// 股票名
	private Double pe;// 市盈率
	private Double pb;// 市净率
	private String price;// 股票价格
	private Double changePct;// 涨跌幅
	private Integer corr;// 相关度
	private Double mktV;// 市值
	private Integer status;// 状态 
	private Integer stkType;
	
	public Integer getStkType() {
		return stkType;
	}

	public void setStkType(Integer stkType) {
		this.stkType = stkType;
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
	 * @return the pe
	 */
	public Double getPe() {
		return pe;
	}

	/**
	 * @param pe
	 *            the pe to set
	 */
	public void setPe(Double pe) {
		this.pe = pe;
	}

	/**
	 * @return the pb
	 */
	public Double getPb() {
		return pb;
	}

	/**
	 * @param pb
	 *            the pb to set
	 */
	public void setPb(Double pb) {
		this.pb = pb;
	}

	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}



	public Double getChangePct() {
		return changePct;
	}

	public void setChangePct(Double changePct) {
		this.changePct = changePct;
	}

	/**
	 * @return the corr
	 */
	public Integer getCorr() {
		return corr;
	}

	/**
	 * @param corr
	 *            the corr to set
	 */
	public void setCorr(Integer corr) {
		this.corr = corr;
	}

	/**
	 * @return the mktV
	 */
	public Double getMktV() {
		return mktV;
	}

	/**
	 * @param mktV
	 *            the mktV to set
	 */
	public void setMktV(Double mktV) {
		this.mktV = mktV;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
