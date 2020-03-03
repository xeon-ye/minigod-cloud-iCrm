/**
 * @Title: DistNewVo.java
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
 * @date 2015-7-16 下午8:50:08
 * @version v1.0
 */
@Deprecated
public class DistNewVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date newsPublishTime;// 新闻发布时间
	private Long newsId;// 新闻ID
	private String newsTitle; // 新闻标题
	private String newsSummary; // 新闻摘要
	private String newsBody;// 新闻正文
	private String newsURL; // 新闻链接
	private String newsOriginSource; // 新闻初始来源，即新闻原始出处
	private String newsAuthor; // 新闻作者
	private String newsPublishSite; // 新闻发布来源，即新闻的实际最终来源
	private Date newsInsertTime; // 新闻入库时间

	public Date getNewsPublishTime() {
		return newsPublishTime;
	}

	public void setNewsPublishTime(Date newsPublishTime) {
		this.newsPublishTime = newsPublishTime;
	}

	public Long getNewsId() {
		return newsId;
	}

	public void setNewsId(Long newsId) {
		this.newsId = newsId;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getNewsSummary() {
		return newsSummary;
	}

	public void setNewsSummary(String newsSummary) {
		this.newsSummary = newsSummary;
	}

	public String getNewsBody() {
		return newsBody;
	}

	public void setNewsBody(String newsBody) {
		this.newsBody = newsBody;
	}

	public String getNewsURL() {
		return newsURL;
	}

	public void setNewsURL(String newsURL) {
		this.newsURL = newsURL;
	}

	public String getNewsOriginSource() {
		return newsOriginSource;
	}

	public void setNewsOriginSource(String newsOriginSource) {
		this.newsOriginSource = newsOriginSource;
	}

	public String getNewsAuthor() {
		return newsAuthor;
	}

	public void setNewsAuthor(String newsAuthor) {
		this.newsAuthor = newsAuthor;
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
