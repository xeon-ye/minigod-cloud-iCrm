/**
 * @Title: DistNewsHeatIndexVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.discover.vo.resp;

import java.io.Serializable;
import java.util.Date;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2015-8-15 下午1:29:39
 * @version v1.0
 */
@Deprecated
public class DistNewsHeatIndexVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String exchangeCD;// 证券交易所代码(通联自编)
	private String ticker;// 证券交易代码
	private Date newsPublishDate;// 新闻发布日期
	private Double heatIndex;// 新闻热度指数，证券当天关联新闻数量占当天关联新闻总量的百分比(%）
	private Date insertTime;// 入库时间
	private Date updateTime;// 更新时间

	public String getExchangeCD() {
		return exchangeCD;
	}

	public void setExchangeCD(String exchangeCD) {
		this.exchangeCD = exchangeCD;
	}

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public Date getNewsPublishDate() {
		return newsPublishDate;
	}

	public void setNewsPublishDate(Date newsPublishDate) {
		this.newsPublishDate = newsPublishDate;
	}

	public Double getHeatIndex() {
		return heatIndex;
	}

	public void setHeatIndex(Double heatIndex) {
		this.heatIndex = heatIndex;
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
