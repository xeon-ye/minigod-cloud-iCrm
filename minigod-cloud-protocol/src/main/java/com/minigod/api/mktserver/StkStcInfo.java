package com.minigod.api.mktserver;

import java.io.Serializable;

public class StkStcInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1700343573208814084L;
	// 资产ID
	private String id;
	// 股票代码
	private String c;
	// 股票代码
	private String zh;
	// 市场代码
	private int mid;
	// 索引
	private String kws;
	// 是否可投资 标记
	private int i;
	// 是否过期
	private int e;
	// 是否上市
	private int l;
	// 上市时间
	private long lts;
	// 是否停牌
	private int s;
	// 证券类型
	private int t;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getZh() {
		return zh;
	}
	public void setZh(String zh) {
		this.zh = zh;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getKws() {
		return kws;
	}
	public void setKws(String kws) {
		this.kws = kws;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public int getE() {
		return e;
	}
	public void setE(int e) {
		this.e = e;
	}
	public int getS() {
		return s;
	}
	public int getL() {
		return l;
	}
	public void setL(int l) {
		this.l = l;
	}
	public long getLts() {
		return lts;
	}
	public void setLts(long lts) {
		this.lts = lts;
	}
	public void setS(int s) {
		this.s = s;
	}
	public String getC() {
		return c;
	}
	public void setC(String c) {
		this.c = c;
	}
	public int getT() {
		return t;
	}
	public void setT(int t) {
		this.t = t;
	}
}
