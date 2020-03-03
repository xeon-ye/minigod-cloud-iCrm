/**
 * @Title: UserPtfListRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.resp;

import java.io.Serializable;
import java.util.List;

import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-7-29 上午11:00:35
 * @version v1.0
 */

@TransferBean
public class UserPtfListRespVO implements Serializable{
	private static final long serialVersionUID = 1L;

	@TransferID
	private List<UserPtfListRespVO_datas> datas;
	
	public List<UserPtfListRespVO_datas> getDatas() {
		return datas;
	}
	public void setDatas(List<UserPtfListRespVO_datas> datas) {
		this.datas = datas;
	}

	@TransferBean
	public static class UserPtfListRespVO_datas implements Serializable{
		private static final long serialVersionUID = 1L;
		
		@TransferID
		private String ptfId;
		private String ptfName;
		public String getPtfId() {
			return ptfId;
		}
		public void setPtfId(String ptfId) {
			this.ptfId = ptfId;
		}
		public String getPtfName() {
			return ptfName;
		}
		public void setPtfName(String ptfName) {
			this.ptfName = ptfName;
		}
	}
}
