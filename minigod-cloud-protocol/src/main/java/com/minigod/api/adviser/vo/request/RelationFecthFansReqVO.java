/**
 * @Title: RelationDelClientReqVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.adviser.vo.request;

import com.minigod.api.adviser.vo.QNAdviserBase;
import com.minigod.api.user.vo.SNVersion;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2015-11-16 上午10:27:37
 * @version v1.0
 */
@TransferBean
public class RelationFecthFansReqVO extends SNVersion {
	private static final long serialVersionUID = 1L;
	@TransferID
	private RelationFecthFansVO params;

	public RelationFecthFansVO getParams() {
		return params;
	}

	public void setParams(RelationFecthFansVO params) {
		this.params = params;
	}

	@TransferBean
	public static class RelationFecthFansVO extends QNAdviserBase {

		private static final long serialVersionUID = 1L;
		private Integer count;//拉取的条数
		private String openAccType;//开户类型Y:开户 N：未开户 A：全部
		private String rewardType;//是否打赏
		private String sortType;//排序字段
//		private String sortDir;//排序方向:A:升序，D：降序
		@TransferID
		private Long userId;
		public String getOpenAccType() {
			return openAccType;
		}
		public void setOpenAccType(String openAccType) {
			this.openAccType = openAccType;
		}
		public String getSortType() {
			return sortType;
		}
		public void setSortType(String sortType) {
			this.sortType = sortType;
		}
//		public String getSortDir() {
//			return sortDir;
//		}
//		public void setSortDir(String sortDir) {
//			this.sortDir = sortDir;
//		}
		public Long getUserId() {
			return userId;
		}
		public void setUserId(Long userId) {
			this.userId = userId;
		}
		public Integer getCount() {
			return count;
		}
		public void setCount(Integer count) {
			this.count = count;
		}
		public String getRewardType() {
			return rewardType;
		}
		public void setRewardType(String rewardType) {
			this.rewardType = rewardType;
		}
		
	}
}
