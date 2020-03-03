package com.minigod.api.ptf.vo.resp;

import java.io.Serializable;
import java.util.List;

import com.minigod.api.ptf.vo.resp.PtfUpdateDetailVO;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @Title: PtfUpdateNotifyVO.java
 * @Description: 跟单组合通知返回VO类
 * @Copyright: © 2014 minigod
 * @Company: minigod
 *
 * @author panlz
 * @date 2015-03-16 上午11:33:48
 * @version v1.0
 */
@TransferBean
public class PtfUpdateDetailResponseVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Emoji
	private String  ptfName;//组合名
	
	@TransferID
	private Long  uID;//组合创建者ID
	@Emoji
	private String  uName; //组合创建者名
	private String  uImg; //用户头像
	private Integer uType; // 用户类型
	
	private List<PtfUpdateDetailVO>  rcds;//rcds对象集合
	
	public String getPtfName() {
		return ptfName;
	}

	public void setPtfName(String ptfName) {
		this.ptfName = ptfName;
	}

	public Long getuID() {
		return uID;
	}

	public void setuID(Long uID) {
		this.uID = uID;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuImg() {
		return uImg;
	}

	public void setuImg(String uImg) {
		this.uImg = uImg;
	}
	
	public Integer getuType() {
		return uType;
	}

	public void setuType(Integer uType) {
		this.uType = uType;
	}

	public List<PtfUpdateDetailVO> getRcds() {
		return rcds;
	}

	public void setRcds(List<PtfUpdateDetailVO> rcds) {
		this.rcds = rcds;
	}

}
