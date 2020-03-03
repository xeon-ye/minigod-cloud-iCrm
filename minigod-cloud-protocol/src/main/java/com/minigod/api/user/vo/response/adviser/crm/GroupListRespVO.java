package com.minigod.api.user.vo.response.adviser.crm;

import java.io.Serializable;
import java.util.List;

import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

@TransferBean
public class GroupListRespVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@TransferID
	private List<GroupListRespVO_data> datas;
	private Integer total;//全部好友数

	public List<GroupListRespVO_data> getDatas() {
		return datas;
	}

	public void setDatas(List<GroupListRespVO_data> datas) {
		this.datas = datas;
	}
	
	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	@TransferBean
	public static class GroupListRespVO_data implements Serializable {
		private static final long serialVersionUID = 1L;

		private Integer groupId;
		private String groupType;
		@Emoji
		private String name;
		private String icon;
		private Integer count;
		private Integer isEdit;//0不可编辑，1可编辑

		public Integer getGroupId() {
			return groupId;
		}

		public void setGroupId(Integer groupId) {
			this.groupId = groupId;
		}

		public String getGroupType() {
			return groupType;
		}

		public void setGroupType(String groupType) {
			this.groupType = groupType;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getIcon() {
			return icon;
		}

		public void setIcon(String icon) {
			this.icon = icon;
		}

		public Integer getCount() {
			return count;
		}

		public void setCount(Integer count) {
			this.count = count;
		}

		public Integer getIsEdit() {
			return isEdit;
		}

		public void setIsEdit(Integer isEdit) {
			this.isEdit = isEdit;
		}
		
	}
}
