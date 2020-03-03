package com.minigod.api.mktserver;

import java.io.Serializable;

public class KeyItem implements Serializable {

	/** [这里描述变量的作用] */
	private static final long serialVersionUID = -4296831537859013563L;

	private String item;

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}
}
