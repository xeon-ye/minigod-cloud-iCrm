package com.minigod.common.config.supers;

import java.io.Serializable;

/**
 * @Title: SuperInfo.java
 * @Description: 
 * @Copyright:  2016 minigod
 * @Company: minigod
 *
 * @author
 * @date 2015-3-27 下午5:19:54
 * @version v1.0
 */

public class SuperInfo implements Serializable {

	private static final long serialVersionUID = 1743315456046278894L;

	private String key;
	private String md5;
	private boolean encryption = false;

	private String note;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public boolean isEncryption() {
		return encryption;
	}

	public void setEncryption(boolean encryption) {
		this.encryption = encryption;
	}

	public SuperInfo() {
		super();
	}

	public SuperInfo(String key, String md5, String note, boolean encryption) {
		super();
		this.key = key;
		this.md5 = md5;
		this.note = note;
		this.encryption = encryption;
	}
}
