package com.minigod.api.user.vo;

import java.io.Serializable;

public class QNUpdateVersion implements Serializable {

	private static final long serialVersionUID = -2329478400681602110L;

	private String note;//版本升级更新的内容Release note,服务器在每一条更新后加上/n换行符，便于客户端进行显示。
	private String lastVer;//最新版本号

	//1.iOS用户可配置AppStore下载地址（推荐）或者其他地址
	//2.Android用户配置app相应市场的下载地址
	private String url;//下载地址	
	private String size;//本次更新包大小,单位是KB

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getLastVer() {
		return lastVer;
	}

	public void setLastVer(String lastVer) {
		this.lastVer = lastVer;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
}
