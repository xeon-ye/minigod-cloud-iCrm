/**
 * @Title: StkNewsDetailRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.resp;

import com.minigod.api.mktinfo.vo.resp.StkBaseInfo;
import com.minigod.api.mktinfo.vo.resp.StkInduListMoreRespVO;
import com.minigod.api.mktinfo.vo.resp.StkLabListMoreRespVO;

import java.io.Serializable;
import java.util.List;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2015-7-20 上午11:33:56
 * @version v1.0
 */

public class StkNewsDetailRespVO extends StkNewsUserRespVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private String media;
	private String date;
	private String content;
	private String contentText;
	private String url;
	private Integer newsId;
	private Long size;// 文件大小
	private String imgUrl;//列表图片
	private String pdfUrl;
	private String summary;
	private String authorName;
	private String authorImg;
	
	private List<StkInduListMoreRespVO> indus;
	private List<StkLabListMoreRespVO> labs;
	private List<StkBaseInfo> stks;
	
	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorImg() {
		return authorImg;
	}

	public void setAuthorImg(String authorImg) {
		this.authorImg = authorImg;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getNewsId() {
		return newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public List<StkInduListMoreRespVO> getIndus() {
		return indus;
	}

	public void setIndus(List<StkInduListMoreRespVO> indus) {
		this.indus = indus;
	}

	public List<StkLabListMoreRespVO> getLabs() {
		return labs;
	}

	public void setLabs(List<StkLabListMoreRespVO> labs) {
		this.labs = labs;
	}

	public List<StkBaseInfo> getStks() {
		return stks;
	}

	public void setStks(List<StkBaseInfo> stks) {
		this.stks = stks;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getContentText() {
		return contentText;
	}

	public void setContentText(String contentText) {
		this.contentText = contentText;
	}

	public String getPdfUrl() {
		return pdfUrl;
	}

	public void setPdfUrl(String pdfUrl) {
		this.pdfUrl = pdfUrl;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
}
