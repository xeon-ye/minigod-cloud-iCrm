package com.minigod.api.ptf.vo.req;

import java.io.Serializable;
import java.util.List;

import com.minigod.api.ptf.vo.resp.PtfFlagDetailsVO.SaleInfo;
import com.minigod.api.vo.BaseVO;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @Title: PtfUpdateVO.java
 * @Description: 组合数据更新
 * @Copyright: © 2014 minigod
 * @Company: minigod
 *
 * @author minigod
 * @date 2014-10-29 下午5:05:48
 * @version v1.0
 */
@TransferBean
public class PtfUpdateVO extends BaseVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@TransferID
	private Long ptfId; // 组合id
	
	@Emoji
	private String name; // 组合名称
	@Emoji
	private String desc; // 组合描述
	
	private Integer perm; // 组合查看权限
	
	private String imgUrl; // 组合LOGO的URL
	
	@TransferID
	private List<Long> uIds; // 新增的可见的好友列表
	
	private String authShare; // 组合分享权限
	

	private SaleInfo saleInfo;
	
	

	public SaleInfo getSaleInfo() {
		return saleInfo;
	}

	public void setSaleInfo(SaleInfo saleInfo) {
		this.saleInfo = saleInfo;
	}

	public Long getPtfId() {
		return ptfId;
	}

	public void setPtfId(Long ptfId) {
		this.ptfId = ptfId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Integer getPerm() {
		return perm;
	}

	public void setPerm(Integer perm) {
		this.perm = perm;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getAuthShare() {
		return authShare;
	}

	public void setAuthShare(String authShare) {
		this.authShare = authShare;
	}

	public List<Long> getuIds() {
		return uIds;
	}

	public void setuIds(List<Long> uIds) {
		this.uIds = uIds;
	}
	
	
}
