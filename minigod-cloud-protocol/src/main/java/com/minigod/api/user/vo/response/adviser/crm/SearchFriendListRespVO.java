package com.minigod.api.user.vo.response.adviser.crm;

import java.io.Serializable;
import java.util.List;

import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

@TransferBean
public class SearchFriendListRespVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@TransferID
	private List<SearchFriendListRespVO_data> datas;

	public List<SearchFriendListRespVO_data> getDatas() {
		return datas;
	}

	public void setDatas(List<SearchFriendListRespVO_data> datas) {
		this.datas = datas;
	}

	@TransferBean
	public static class SearchFriendListRespVO_data implements Serializable {
		private static final long serialVersionUID = 1L;

		@TransferID
		private Long uId;
		@Emoji
		private String uName;
		private String uIcon;
		private String imId;
		private Integer inGroup;

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
