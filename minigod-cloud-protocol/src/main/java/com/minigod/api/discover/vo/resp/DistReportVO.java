/**
 * @Title: DistReport.java
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
 * @date 2015-7-16 下午3:06:45
 * @version v1.0
 */
@Deprecated
public class DistReportVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long reportID;// 公告代码
	private Date publishDate;// 公告发布时间
	private String tiker;// 证券交易代码
	private String title;// 公告标题
	private Integer year;// 公告年份
	private String site;// 证券交易场所，包括"SH"、"SZ"。"SH"指上海证券交易所、"SZ"指深圳证券交易所
	private String reportType;// 证券交易所对公告的原始分类
	private String txtContent;// 公告内容
	private String URL;// 下载URL
	private Date insertTime;// 自动分类数据入库时间

	public Long getReportID() {
		return reportID;
	}

	public void setReportID(Long reportID) {
		this.reportID = reportID;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public String getTiker() {
		return tiker;
	}

	public void setTiker(String tiker) {
		this.tiker = tiker;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public String getTxtContent() {
		return txtContent;
	}

	public void setTxtContent(String txtContent) {
		this.txtContent = txtContent;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

}
