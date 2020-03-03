/**
 * @Title: FetchCouponRespVO.java
 * @Copyright: © 2016 minigod
 * @Company: minigod
 */

package com.minigod.api.coupon.vo.resp;

import java.io.Serializable;
import java.util.List;

import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description 获取我的卡券响应类
 * 
 * @author Jimmy
 * @date 2016-1-14 上午9:11:06
 * @version v1.0
 */
@TransferBean
public class FetchCouponRespVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@TransferID
	private List<FetchCouponRVO> coupons;

	private Tips tips;

	public Tips getTips() {
		return tips;
	}

	public void setTips(Tips tips) {
		this.tips = tips;
	}

	public List<FetchCouponRVO> getCoupons() {
		return coupons;
	}

	public void setCoupons(List<FetchCouponRVO> coupons) {
		this.coupons = coupons;
	}

	public static class Tips implements Serializable {
		private static final long serialVersionUID = 2026909898506782517L;
		private String title;
		private String content;

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

	}

	@TransferBean
	public static class FetchCouponRVO implements Serializable {
		private static final long serialVersionUID = -3274855616312673544L;
		@TransferID
		private Long couponId; // 卡券的ID
		private Integer type; // 卡券的类型
		private String title; // 卡券的标题
		private String rule; // 使用规则
		private String source; // 获得来源
		private Long expireTime; // 使用期限
		private String value; // 卡券的数值
		private String unit; // 面值的单位
		private String status; // 状态
		private Long time; // 时间戳
		private String color; // 颜色RGB

		public Long getCouponId() {
			return couponId;
		}

		public void setCouponId(Long couponId) {
			this.couponId = couponId;
		}

		public Integer getType() {
			return type;
		}

		public void setType(Integer type) {
			this.type = type;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getRule() {
			return rule;
		}

		public void setRule(String rule) {
			this.rule = rule;
		}

		public String getSource() {
			return source;
		}

		public void setSource(String source) {
			this.source = source;
		}

		public Long getExpireTime() {
			return expireTime;
		}

		public void setExpireTime(Long expireTime) {
			this.expireTime = expireTime;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getUnit() {
			return unit;
		}

		public void setUnit(String unit) {
			this.unit = unit;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public Long getTime() {
			return time;
		}

		public void setTime(Long time) {
			this.time = time;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}
	}
}
