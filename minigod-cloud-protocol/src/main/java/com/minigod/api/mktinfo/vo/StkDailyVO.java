package com.minigod.api.mktinfo.vo;

/**
 * 
 * <code>StockDataVO<code>[股票日数据对象]
 * 
 * @author Colin
 * @since MiniGod v0.0.1(2014-10-27)
 * 
 */
/*
 * Modify By 余俊斌 at 2015-07-20：构建历史行情对象继承结构
 */
public class StkDailyVO extends HistQuotVO {

	private static final long serialVersionUID = -7241233393189248303L;

	private Double adjFactor; // 复权调整因子
	private Double kValAdj; // 复权K值,用于计算复权KDJ指标
	private Double dValAdj; // 复权D值,用于计算复权KDJ指标
	private Double jValAdj; // 复权J值,用于计算复权KDJ指标
	private Double ema1Bkw; // 后复权ema1，前复权可通过最新复权因子计算得出,用于计算复权MACD指标
	private Double ema2Bkw; // 后复权ema2，前复权可通过最新复权因子计算得出,用于计算复权MACD指标
	private Double deaBkw; // 后复权dea，前复权可通过最新复权因子计算得出,用于计算复权MACD指标
	private Double upSeq1Bkw;// 6日涨序列值（后复权），前复权可通过最新复权因子计算得出,用于计算复权RSI指标
	private Double downSeq1Bkw;// 6日跌序列值（后复权），前复权可通过最新复权因子计算得出,用于计算复权RSI指标
	private Double upSeq2Bkw;// 12日涨序列值（后复权），前复权可通过最新复权因子计算得出,用于计算复权RSI指标
	private Double downSeq2Bkw;// 12日跌序列值（后复权），前复权可通过最新复权因子计算得出,用于计算复权RSI指标
	private Double upSeq3Bkw;// 24日涨序列值（后复权），前复权可通过最新复权因子计算得出,用于计算复权RSI指标
	private Double downSeq3Bkw;// 24日跌序列值（后复权），前复权可通过最新复权因子计算得出,用于计算复权RSI指标


	public Double getAdjFactor() {
		return adjFactor;
	}

	public void setAdjFactor(Double adjFactor) {
		this.adjFactor = adjFactor;
	}

	public Double getkValAdj() {
		return kValAdj;
	}

	public void setkValAdj(Double kValAdj) {
		this.kValAdj = kValAdj;
	}

	public Double getdValAdj() {
		return dValAdj;
	}

	public void setdValAdj(Double dValAdj) {
		this.dValAdj = dValAdj;
	}

	public Double getjValAdj() {
		return jValAdj;
	}

	public void setjValAdj(Double jValAdj) {
		this.jValAdj = jValAdj;
	}

	public Double getEma1Bkw() {
		return ema1Bkw;
	}

	public void setEma1Bkw(Double ema1Bkw) {
		this.ema1Bkw = ema1Bkw;
	}

	public Double getEma2Bkw() {
		return ema2Bkw;
	}

	public void setEma2Bkw(Double ema2Bkw) {
		this.ema2Bkw = ema2Bkw;
	}

	public Double getDeaBkw() {
		return deaBkw;
	}

	public void setDeaBkw(Double deaBkw) {
		this.deaBkw = deaBkw;
	}

	public Double getUpSeq1Bkw() {
		return upSeq1Bkw;
	}

	public void setUpSeq1Bkw(Double upSeq1Bkw) {
		this.upSeq1Bkw = upSeq1Bkw;
	}

	public Double getDownSeq1Bkw() {
		return downSeq1Bkw;
	}

	public void setDownSeq1Bkw(Double downSeq1Bkw) {
		this.downSeq1Bkw = downSeq1Bkw;
	}

	public Double getUpSeq2Bkw() {
		return upSeq2Bkw;
	}

	public void setUpSeq2Bkw(Double upSeq2Bkw) {
		this.upSeq2Bkw = upSeq2Bkw;
	}

	public Double getDownSeq2Bkw() {
		return downSeq2Bkw;
	}

	public void setDownSeq2Bkw(Double downSeq2Bkw) {
		this.downSeq2Bkw = downSeq2Bkw;
	}

	public Double getUpSeq3Bkw() {
		return upSeq3Bkw;
	}

	public void setUpSeq3Bkw(Double upSeq3Bkw) {
		this.upSeq3Bkw = upSeq3Bkw;
	}

	public Double getDownSeq3Bkw() {
		return downSeq3Bkw;
	}

	public void setDownSeq3Bkw(Double downSeq3Bkw) {
		this.downSeq3Bkw = downSeq3Bkw;
	}

}
