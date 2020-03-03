/**
 * @Title: IMGroupSettingVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.req;

import java.io.Serializable;

import com.minigod.api.im.vo.Announcement;
import com.minigod.api.vo.BaseVO;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;

/**
 * @description 
 * 
 * @author Jimmy
 * @date 2015-8-19 下午4:42:39
 * @version v1.0
 */
@TransferBean
public class IMGroupSettingVO extends BaseVO {
	/** */
	private static final long serialVersionUID = 1L;

	private String groupId; // 群组ID

	private Long flag;
	private String groupName;// 群名称
	@Emoji
	private String description;// 群描述
	private String icon;// 群头像
	private Integer max_users;// 最大人数
	private Charge charge;
	private String needVerify;// 是否需要验证, Y – 需要, N – 不需要
	@Emoji
	private Announcement announcement;

	public Long getFlag() {
		return flag;
	}

	public void setFlag(Long flag) {
		this.flag = flag;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getMax_users() {
		return max_users;
	}

	public void setMax_users(Integer max_users) {
		this.max_users = max_users;
	}

	public Charge getCharge() {
		return charge;
	}

	public void setCharge(Charge charge) {
		this.charge = charge;
	}

	public String getNeedVerify() {
		return needVerify;
	}

	public void setNeedVerify(String needVerify) {
		this.needVerify = needVerify;
	}

	public Announcement getAnnouncement() {
		return announcement;
	}

	public void setAnnouncement(Announcement announcement) {
		this.announcement = announcement;
	}

	public static class Charge implements Serializable {
		private static final long serialVersionUID = 1L;
		private String price; // 价格
		private String salesPrice; // 促销价格
		private String vipPrice;
		
		public String getVipPrice() {
			return vipPrice;
		}

		public void setVipPrice(String vipPrice) {
			this.vipPrice = vipPrice;
		}

		public String getPrice() {
			return price;
		}

		public void setPrice(String price) {
			this.price = price;
		}

		public String getSalesPrice() {
			return salesPrice;
		}

		public void setSalesPrice(String salesPrice) {
			this.salesPrice = salesPrice;
		}
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
}
