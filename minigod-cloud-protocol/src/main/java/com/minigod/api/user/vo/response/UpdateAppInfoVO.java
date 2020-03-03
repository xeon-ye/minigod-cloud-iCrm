package com.minigod.api.user.vo.response;

import java.io.Serializable;

/**
 * APP升级信息
 */

public class UpdateAppInfoVO implements Serializable {

	private static final long serialVersionUID = 1L;

	// 0为已是最新版本无须升级
	// 1为有新版本，无须升级
	// 2为有新版本，建议升级
	// 3为有新版本，必须升级方可使用
	private Integer checkCode;

	// 0当已为最新版本，无须升级时，返回 客户端已是最新版本，无须升级
	// 1当有新版本时，但无须升级时，返回 有新版本x.x.xxx,无须升级仍可正常使用
	// 2当有新版本，建议升级时，返回 有新版本x.x.xxx， 建议升级
	// 3当有新版本，必须升级时，返回 当前版本太久，必须升级方可继续使用
	private String checkMsg;

	private String note;// 版本升级更新的内容
	private String lastVer;// 最新版本号
	private String url; // 下载地址
	private String size; // 软件包的大小
	private String md5;

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public Integer getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(Integer checkCode) {
		this.checkCode = checkCode;
	}

	public String getCheckMsg() {
		return checkMsg;
	}

	public void setCheckMsg(String checkMsg) {
		this.checkMsg = checkMsg;
	}

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
