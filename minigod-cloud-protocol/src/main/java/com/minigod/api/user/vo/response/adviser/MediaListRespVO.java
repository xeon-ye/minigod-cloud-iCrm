package com.minigod.api.user.vo.response.adviser;

import java.io.Serializable;
import java.util.List;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

@TransferBean
public class MediaListRespVO extends SNVersion {
	private static final long serialVersionUID = 1L;
	
	private String url = "";
	@TransferID
	private List<MediaListRespVO_data> data;
	
	public List<MediaListRespVO_data> getData() {
		return data;
	}
	public void setData(List<MediaListRespVO_data> data) {
		this.data = data;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	@TransferBean
	public static class MediaListRespVO_data implements Serializable{
		private static final long serialVersionUID = 1L;
		
		@TransferID
		private Long uId = 0L;
		private String uImg = "";
		private String uName = "";
		private String orgName = "";
		private String description = "";
		private Integer mId = 0;
		private String isAttentioned = "";
		private Integer AttentionedCount = 0;
		private String encUid = "";
		private String presentation = "";
		
		public Long getuId() {
			return uId;
		}
		public void setuId(Long uId) {
			this.uId = uId;
		}
		public String getuImg() {
			return uImg;
		}
		public void setuImg(String uImg) {
			this.uImg = uImg;
		}
		public String getuName() {
			return uName;
		}
		public void setuName(String uName) {
			this.uName = uName;
		}
		public String getOrgName() {
			return orgName;
		}
		public void setOrgName(String orgName) {
			this.orgName = orgName;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public Integer getmId() {
			return mId;
		}
		public void setmId(Integer mId) {
			this.mId = mId;
		}
		public String getIsAttentioned() {
			return isAttentioned;
		}
		public void setIsAttentioned(String isAttentioned) {
			this.isAttentioned = isAttentioned;
		}
		public Integer getAttentionedCount() {
			return AttentionedCount;
		}
		public void setAttentionedCount(Integer attentionedCount) {
			AttentionedCount = attentionedCount;
		}
		public String getEncUid() {
			return encUid;
		}
		public void setEncUid(String encUid) {
			this.encUid = encUid;
		}
		public String getPresentation() {
			return presentation;
		}
		public void setPresentation(String presentation) {
			this.presentation = presentation;
		}
		
	}
}
