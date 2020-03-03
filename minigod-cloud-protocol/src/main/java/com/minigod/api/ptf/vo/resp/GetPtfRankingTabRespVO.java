/*******************************************************************************
 * Copyright (c) 2016 minigod minigod.Co.Ltd. All rights reserved.
 ******************************************************************************/

package com.minigod.api.ptf.vo.resp;

import java.io.Serializable;
import java.util.List;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-6-30 下午12:34:08
 * @version v1.0
 */

public class GetPtfRankingTabRespVO implements Serializable  {


	private static final long serialVersionUID = 1L;
	
	private List<RankingTab> rankingTabs;

	public List<RankingTab> getRankingTabs() {
		return rankingTabs;
	}

	public void setRankingTabs(List<RankingTab> rankingTabs) {
		this.rankingTabs = rankingTabs;
	}

	public static class RankingTab{
		private String type;
		private String title;
		private String desc;
		private String value;
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		
		
	}
	
}
