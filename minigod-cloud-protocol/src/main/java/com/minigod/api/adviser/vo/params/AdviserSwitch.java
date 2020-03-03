package com.minigod.api.adviser.vo.params;

import com.minigod.api.adviser.vo.QNAdviserBase;
import com.minigod.common.anno.TransferBean;
@TransferBean
public class AdviserSwitch   extends QNAdviserBase  {

	private static final long serialVersionUID = -6148586421924205449L;

	private	String  value; //每一位都用Y/N表示是否开启

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
