/**
 * @Title: MktinfoInnerStockVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.resp;

import java.io.Serializable;

/**
 * @description 事件新闻对象
 * @author 余俊斌
 * @date 2015年8月19日 下午9:43:15
 * @version v1.0
 */
public class MktinfoInnerNewsVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2164229392092781796L;
	private Integer newsId; // 新闻id
	private String title; // 新闻标题
	private String media; // 新闻来源
	private Long date; // 新闻发布时间

	public Integer getNewsId() {
		return newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getDate() {
		return date;
	}

	public void setDate(Long date) {
		this.date = date;
	}

	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}
}