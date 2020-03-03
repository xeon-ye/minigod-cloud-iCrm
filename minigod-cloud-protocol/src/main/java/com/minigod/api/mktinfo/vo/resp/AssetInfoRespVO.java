/*
 * FileName: AssetInfoRespVO.java
 * Copyright: Copyright 2014-11-26 MiniGod Tech. Co. Ltd.All right reserved.
 * Description: 
 *
 */
package com.minigod.api.mktinfo.vo.resp;

import java.io.Serializable;

/**
 * <code>AssetInfoRespVO<code> 这里的字段之所以用缩写 ， 主要减少数据量
 *
 * @author Jimmy
 * @since  MiniGod v0.0.1 (2014-11-26)
 *
 */
public class AssetInfoRespVO implements Serializable{
	/**  */
	private static final long serialVersionUID = 1L;
	private String id; // 资产ID
	private String code; // 股票代码
	private String zh; // 中文
	private String kws; // 拼音#缩写
	private Integer mkt_id; // 市场
	private Integer invest; // 是否可以交易
	private String com;
	private Integer expired;
	
	public Integer getExpired() {
		return expired;
	}
	public void setExpired(Integer expired) {
		this.expired = expired;
	}
	public String getCom() {
		return com;
	}
	public void setCom(String com) {
		this.com = com;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getZh() {
		return zh;
	}
	public Integer getMkt_id() {
		return mkt_id;
	}
	public void setMkt_id(Integer mkt_id) {
		this.mkt_id = mkt_id;
	}
	public void setZh(String zh) {
		this.zh = zh;
	}
	public Integer getInvest() {
		return invest;
	}
	public void setInvest(Integer invest) {
		this.invest = invest;
	}
	public String getKws() {
		return kws;
	}
	public void setKws(String kws) {
		this.kws = kws;
	}
}
