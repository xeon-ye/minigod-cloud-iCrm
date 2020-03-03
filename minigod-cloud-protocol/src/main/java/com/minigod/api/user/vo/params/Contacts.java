package com.minigod.api.user.vo.params;

import java.io.Serializable;

import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;

/**
 * 上传好友通讯录
 */

@TransferBean
public class Contacts implements Serializable {

	private static final long serialVersionUID = -7247354621123843866L;
	private String[] ps;//通讯录电话号码集
	
	@Emoji
	private String n;//名字
	private Integer t;//0表示新增，1表示删除，2表示更新

	public String[] getPs() {
		return ps;
	}

	public void setPs(String[] ps) {
		this.ps = ps;
	}

	public String getN() {
		return n;
	}

	public void setN(String n) {
		this.n = n;
	}

	public Integer getT() {
		return t;
	}

	public void setT(Integer t) {
		this.t = t;
	}
}
