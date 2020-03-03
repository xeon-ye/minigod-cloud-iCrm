/**
 * @Title: NiuUserInfo.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.user.vo.response;

import java.io.Serializable;
import java.util.List;

import com.minigod.security.SecurityKey;
import com.minigod.security.util.IDTransUtil;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-6-15 下午7:18:36
 * @version v1.0
 */

public class NiuFriendNumRespVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<NiuFriendNumRespVO_datas> datas;
	
	
	public List<NiuFriendNumRespVO_datas> getDatas() {
		return datas;
	}

	public void setDatas(List<NiuFriendNumRespVO_datas> datas) {
		this.datas = datas;
	}

	public static class NiuFriendNumRespVO_datas implements Serializable{
		private static final long serialVersionUID = 1L;
		
		private String userId;
		private Integer friNum;
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = IDTransUtil.encodeId(Long.valueOf(userId), SecurityKey.ID_KEY).toString();
		}
		public Integer getFriNum() {
			return friNum;
		}
		public void setFriNum(Integer friNum) {
			this.friNum = friNum;
		}
	}
}
