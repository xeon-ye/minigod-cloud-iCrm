/**
 *@Title:NewsContentByTime.java
 *@Copyright:©2015 minigod
 *@Company:minigod
 */

package com.minigod.api.discover.vo.resp;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description
 * 
 * @author 谢尚河
 * @date 2015-7-16 下午3:06:45
 * @Version v1.0
 */
@Deprecated
public class DistAssetByNews implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date newsPublishTime;// 新闻发布时间
	private String secID;// 证券内部编码(通联自编)
	private String exchangeCD;// 证券交易所代码
	private String ticker;// 证券交易代码
	private Long newsID;// 新闻ID
	private String newsTitle;// 新闻标题
	private String secShortName;// 证券简称
	private String exchangeName;// 证券交易所
	private Float relatedScore;// 证券所属公司与新闻关联度，取值范围[0，1]，数值越大、关联度越高，分数>0.2319表示关联显著
	private Integer sentiment;// 证券所属公司新闻情感，新闻针对特定证券所属公司的情感分类，1为正面、0为中性、-1为负面
	private Float sentimentScore;// 证券所属公司新闻情感分数，取值范围[-1,1]，绝对值越高、正面(负面)的情感越强烈
	private String newsPublishSite;// 新闻发布来源，即新闻的实际最终来源
	private Date newsInsertTime;// 新闻入库时间

	public Date getNewsPublishTime() {
		return newsPublishTime;
	}

	public void setNewsPublishTime(Date newsPublishTime) {
		this.newsPublishTime = newsPublishTime;
	}

	public String getSecID() {
		return secID;
	}

	public void setSecID(String secID) {
		this.secID = secID;
	}

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

	public Long getNewsID() {
		return newsID;
	}

	public void setNewsID(Long newsID) {
		this.newsID = newsID;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getSecShortName() {
		return secShortName;
	}

	public void setSecShortName(String secShortName) {
		this.secShortName = secShortName;
	}

	public String getExchangeName() {
		return exchangeName;
	}

	public void setExchangeName(String exchangeName) {
		this.exchangeName = exchangeName;
	}

	public Float getRelatedScore() {
		return relatedScore;
	}

	public void setRelatedScore(Float relatedScore) {
		this.relatedScore = relatedScore;
	}

	public Integer getSentiment() {
		return sentiment;
	}

	public void setSentiment(Integer sentiment) {
		this.sentiment = sentiment;
	}

	public Float getSentimentScore() {
		return sentimentScore;
	}

	public void setSentimentScore(Float sentimentScore) {
		this.sentimentScore = sentimentScore;
	}

	public String getNewsPublishSite() {
		return newsPublishSite;
	}

	public void setNewsPublishSite(String newsPublishSite) {
		this.newsPublishSite = newsPublishSite;
	}

	public Date getNewsInsertTime() {
		return newsInsertTime;
	}

	public void setNewsInsertTime(Date newsInsertTime) {
		this.newsInsertTime = newsInsertTime;
	}

}
