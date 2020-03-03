package com.minigod.api.user.vo.response.adviser.crm;

import java.io.Serializable;
import java.util.List;

import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

@TransferBean
public class GroupFriendListRespVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@TransferID
	private List<GroupFriendListRespVO_data> datas;
	private Integer readVersion;

	public Integer getReadVersion() {
		return readVersion;
	}

	public void setReadVersion(Integer readVersion) {
		this.readVersion = readVersion;
	}

	public List<GroupFriendListRespVO_data> getDatas() {
		return datas;
	}

	public void setDatas(List<GroupFriendListRespVO_data> datas) {
		this.datas = datas;
	}

	@TransferBean
	public static class GroupFriendListRespVO_data implements Serializable {
		private static final long serialVersionUID = 1L;

		@TransferID
		private Long uId;
		@Emoji
		private String uName;
		private String uIcon;
		private String imId;
		private Integer inGroup;//0:不属于该群,1:属于该群聊

		public Integer getInGroup() {
			return inGroup;
		}

		public void setInGroup(Integer inGroup) {
			this.inGroup = inGroup;
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
	}
}
