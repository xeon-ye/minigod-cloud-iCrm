/**
 * @Title: UserRegInfo.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.user.vo.params;

import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @description 用户渠道对象
 * 
 * @author minigod
 * @date 2015-4-22 下午4:40:20
 * @version v1.0
 */

@TransferBean
public class UserChannelDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;//记录ID
	private String channelId;//渠道ID
	private String channelName;//渠道名称
	private String companyName;//公司名称
	private String accessPoint;//预计接入点(1:首批)
	private String diversMode;//导流方式（1:线上，2:线下）
	private Integer regisUserSize;//注册用户规模
	private String rmk;//备注
	private String createBy;//创建人
	private String updateBy;//修改人
	private Date createTime;//创建日期
	private Date updateTime;//修改日期

	public Integer getId () {
		return id;
	}

	public void setId (Integer id) {
		this.id = id;
	}

	public String getChannelId () {
		return channelId;
	}

	public void setChannelId (String channelId) {
		this.channelId = channelId;
	}

	public String getChannelName () {
		return channelName;
	}

	public void setChannelName (String channelName) {
		this.channelName = channelName;
	}

	public String getCompanyName () {
		return companyName;
	}

	public void setCompanyName (String companyName) {
		this.companyName = companyName;
	}

	public String getAccessPoint () {
		return accessPoint;
	}

	public void setAccessPoint (String accessPoint) {
		this.accessPoint = accessPoint;
	}

	public String getDiversMode () {
		return diversMode;
	}

	public void setDiversMode (String diversMode) {
		this.diversMode = diversMode;
	}

	public Integer getRegisUserSize () {
		return regisUserSize;
	}

	public void setRegisUserSize (Integer regisUserSize) {
		this.regisUserSize = regisUserSize;
	}

	public String getRmk () {
		return rmk;
	}

	public void setRmk (String rmk) {
		this.rmk = rmk;
	}

	public String getCreateBy () {
		return createBy;
	}

	public void setCreateBy (String createBy) {
		this.createBy = createBy;
	}

	public String getUpdateBy () {
		return updateBy;
	}

	public void setUpdateBy (String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getCreateTime () {
		return createTime;
	}

	public void setCreateTime (Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime () {
		return updateTime;
	}

	public void setUpdateTime (Date updateTime) {
		this.updateTime = updateTime;
	}
}
