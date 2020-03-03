/**
 * @Title: MarketIndexVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.mktinfo.vo.BaseAppVO;
import com.minigod.api.vo.BaseVO;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2015-8-27 下午9:21:16
 * @version v1.0
 */

public class NewsIndexVO extends BaseAppVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer type;
	private Integer count;
	private Integer newsId;
	private String newsDate;
	private Integer isfavor;
	
	public Integer getIsfavor() {
		return isfavor;
	}

	public void setIsfavor(Integer isfavor) {
		this.isfavor = isfavor;
	}

	public String getNewsDate() {
		return newsDate;
	}

	public void setNewsDate(String newsDate) {
		this.newsDate = newsDate;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getNewsId() {
		return newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

}
