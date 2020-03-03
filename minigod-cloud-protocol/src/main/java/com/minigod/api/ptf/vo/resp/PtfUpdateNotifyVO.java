package com.minigod.api.ptf.vo.resp;

import java.io.Serializable;

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
public class PtfUpdateNotifyVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@TransferID
	private Long ptfId; // 组合id
	
	private Integer brkId;
	
	private String custId;

	@Emoji
	private String ptfName; // 组合名称
	
	@TransferID
	private Long uID; // 组合创建者ID

	@Emoji
	private String uName; // 组合创建者名
	
	private Integer uType; // 用户类型

	private Long updTs; // 更新时间

	private String uImg; // 用户头像地址

	private String stat; // 组合状态 U表示组合有更新需要更新。I表示更新中

	private Integer ptfVer; // 组合版本号
	
	public Integer getBrkId() {
		return brkId;
	}

	public void setBrkId(Integer brkId) {
		this.brkId = brkId;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public Long getPtfId() {
		return ptfId;
	}

	public void setPtfId(Long ptfId) {
		this.ptfId = ptfId;
	}

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
	
	public Integer getuType() {
		return uType;
	}

	public void setuType(Integer uType) {
		this.uType = uType;
	}

	public Long getUpdTs() {
		return updTs;
	}

	public void setUpdTs(Long updTs) {
		this.updTs = updTs;
	}

	public String getuImg() {
		return uImg;
	}

	public void setuImg(String uImg) {
		this.uImg = uImg;
	}

	public String getStat() {
		return stat;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}

	public Integer getPtfVer() {
		return ptfVer;
	}

	public void setPtfVer(Integer ptfVer) {
		this.ptfVer = ptfVer;
	}
}