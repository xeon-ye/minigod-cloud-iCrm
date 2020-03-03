/**
 * @Title: FetchCouponReq.java
 * @Copyright: © 2016 minigod
 * @Company: minigod
 */

package com.minigod.api.coupon.vo.req;

import com.minigod.api.coupon.enums.ECouponStatus;
import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.vo.BaseVO;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description 获取我的卡券请求类
 * 
 * @author Jimmy
 * @date 2016-1-12 下午1:34:45
 * @version v1.0
 */
@TransferBean
public class FetchCouponReqVO extends SNVersion {
	private static final long serialVersionUID = -6214294393914524695L;
	@TransferID
	private FetchCouponVO params;

	public FetchCouponVO getParams() {
		return params;
	}

	public void setParams(FetchCouponVO params) {
		this.params = params;
	}
	
	@TransferBean
	public static class FetchCouponVO extends BaseVO {
		private static final long serialVersionUID = 1902409363626684240L;
		/**
		 * 卡券的状态 String 作为过滤条件 , N – 未使用（正常） A - 所有的(默认), U – 已使用,E – 已过期
		 * (包括已回收)
		 */
		private ECouponStatus status = ECouponStatus.A;
		/** 拉取的条数 Int32 默认为20条 */
		private Integer count = 20;
		/** 卡券的ID Int64 用于分页，定位卡券 , 为空时， 返回最新的count条 */
		@TransferID
		private Long couponId ;
		/** 1 : 加息券 */
		private Integer type;

		public Integer getType() {
			return type;
		}

		public void setType(Integer type) {
			this.type = type;
		}

		public ECouponStatus getStatus() {
			return status;
		}

		public void setStatus(ECouponStatus status) {
			this.status = status;
		}

		public Integer getCount() {
			return count;
		}

		public void setCount(Integer count) {
			this.count = count;
		}

		public Long getCouponId() {
			return couponId;
		}

		public void setCouponId(Long couponId) {
			this.couponId = couponId;
		}
	}
}
