/**
 * @Title: FetchUserFriendRestVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.user.vo.response.adviser.crm;

import java.io.Serializable;
import java.util.List;

import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-9-2 上午11:28:45
 * @version v1.0
 */

@TransferBean
public class FetchUserFriendRespVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@TransferID
	private List<FetchUserFriendRespVO_data> datas;
	private Integer friendCount;
	private Integer readVersion;
	
	public List<FetchUserFriendRespVO_data> getDatas() {
		return datas;
	}
	public void setDatas(List<FetchUserFriendRespVO_data> datas) {
		this.datas = datas;
	}
	public Integer getFriendCount() {
		return friendCount;
	}
	public void setFriendCount(Integer friendCount) {
		this.friendCount = friendCount;
	}

	public Integer getReadVersion() {
		return readVersion;
	}
	public void setReadVersion(Integer readVersion) {
		this.readVersion = readVersion;
	}

	@TransferBean
	public static class FetchUserFriendRespVO_data implements Serializable{
		private static final long serialVersionUID = 1L;
		
		@TransferID
		private Long uId;
		@Emoji
		private String uName;
		private String uIcon;
		private String imId;
		private Integer inGroup;
		private Integer gender;
		public Integer getGender() {
			return gender;
		}
		public void setGender(Integer gender) {
			this.gender = gender;
		}
		public Long getuId() {
			return uId;
		}
		public void setuId(Long uId) {
			this.uId = uId;
		}
		public String getuName() {
			return uName;
		}
		public void setuName(String uName) {
			this.uName = uName;
		}
		public String getuIcon() {
			return uIcon;
		}
		public void setuIcon(String uIcon) {
			this.uIcon = uIcon;
		}
		public String getImId() {
			return imId;
		}
		public void setImId(String imId) {
			this.imId = imId;
		}
		public Integer getInGroup() {
			return inGroup;
		}
		public void setInGroup(Integer inGroup) {
			this.inGroup = inGroup;
		}
	}
}
