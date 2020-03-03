/**
 * @Title: GXRequest.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.gateway.vo.req.guoxin;

import java.io.Serializable;

/**
 * @description 国信交易请求基类
 * 
 * @author Jimmy
 * @date 2015-3-10 下午2:56:16
 * @version v1.0
 */

public class GXRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	// minigodopenId , 国信支持的最长为64
	private String openid;
	// 登录类型
	private String inputtype;
	// 登录标识
	private String inputid;
	// 机构代码
	private String orgid;
	// 客户机构代码
	private String custorgid;
	// 交易节点
	private String tradenode;
	// 资金账号
	private String fundid;
	//
	private String ext1;
	// 用户信息
	private String userinfo;
	// 回话ID
	private String authid;
	// 请求行数
	private Integer count;
	// 定位串
	private String poststr;
	// 股东代码
	private String secuid;
	// 来源
	private String source;
	//
	private String operway;
	// 电话号码
	private String netaddr;

	public String getNetaddr() {
		return netaddr;
	}

	public void setNetaddr(String netaddr) {
		this.netaddr = netaddr;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSecuid() {
		return secuid;
	}

	public void setSecuid(String secuid) {
		this.secuid = secuid;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getPoststr() {
		return poststr;
	}

	public void setPoststr(String poststr) {
		this.poststr = poststr;
	}

	public String getAuthid() {
		return authid;
	}

	public void setAuthid(String authid) {
		this.authid = authid;
	}

	public String getOrgid() {
		return orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public String getTradenode() {
		return tradenode;
	}

	public void setTradenode(String tradenode) {
		this.tradenode = tradenode;
	}

	public String getExt1() {
		return ext1;
	}

	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}

	public String getInputtype() {
		return inputtype;
	}

	public void setInputtype(String inputtype) {
		this.inputtype = inputtype;
	}

	public String getInputid() {
		return inputid;
	}

	public String getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(String userinfo) {
		this.userinfo = userinfo;
	}

	public void setInputid(String inputid) {
		this.inputid = inputid;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String qnopenid) {
		this.openid = qnopenid;
	}

	public String getCustorgid() {
		return custorgid;
	}

	public void setCustorgid(String custorgid) {
		this.custorgid = custorgid;
	}

	public String getFundid() {
		return fundid;
	}

	public void setFundid(String fundid) {
		this.fundid = fundid;
	}

	public String getOperway() {
		return operway;
	}

	public void setOperway(String operway) {
		this.operway = operway;
	}

}
