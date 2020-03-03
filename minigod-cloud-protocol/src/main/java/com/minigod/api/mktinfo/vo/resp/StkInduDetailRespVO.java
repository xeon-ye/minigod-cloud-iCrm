/**
 * @Title: StkLabelDetailRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.resp;

import java.io.Serializable;

/**
 * @description 行业详情返回对象
 *
 * @author 余俊斌
 * @date 2015年8月19日 下午9:29:38
 * @version v1.0
 */

public class StkInduDetailRespVO implements Serializable {

	private static final long serialVersionUID = -8632142344659195231L;

	private String induName;
	private Double induChgPct;
	private Integer upNums;
	private Integer downNums;
	private MktinfoInnerStockVO stk;
	private MktinfoInnerNewsVO news;

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

	public Integer getUpNums() {
		return upNums;
	}

	public void setUpNums(Integer upNums) {
		this.upNums = upNums;
	}

	public Integer getDownNums() {
		return downNums;
	}

	public void setDownNums(Integer downNums) {
		this.downNums = downNums;
	}

	public MktinfoInnerStockVO getStk() {
		return stk;
	}

	public void setStk(MktinfoInnerStockVO stk) {
		this.stk = stk;
	}

	public MktinfoInnerNewsVO getNews() {
		return news;
	}

	public void setNews(MktinfoInnerNewsVO news) {
		this.news = news;
	}

}
