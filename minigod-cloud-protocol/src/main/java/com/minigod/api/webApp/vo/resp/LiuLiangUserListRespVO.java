/**
 * @Title: LiuLiangUserListRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.resp;

import java.io.Serializable;
import java.util.List;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-11-17 上午10:38:02
 * @version v1.0
 */

public class LiuLiangUserListRespVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private List<LiuLiangUserListRespVO_data> list;

	public List<LiuLiangUserListRespVO_data> getList() {
		return list;
	}
	public void setList(List<LiuLiangUserListRespVO_data> list) {
		this.list = list;
	}

	public static class LiuLiangUserListRespVO_data implements Serializable{
		private static final long serialVersionUID = 1L;
		
		private Long time;
		private String phoneNum;
		private String postPackage;
		public Long getTime() {
			return time;
		}
		public void setTime(Long time) {
			this.time = time;
		}
		public String getPhoneNum() {
			return phoneNum;
		}
		public void setPhoneNum(String phoneNum) {
			this.phoneNum = phoneNum;
		}
		public String getPostPackage() {
			return postPackage;
		}
		public void setPostPackage(String postPackage) {
			this.postPackage = postPackage;
		}
	}
}
