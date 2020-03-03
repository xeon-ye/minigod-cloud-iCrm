package com.minigod.api.user.vo.params;

import com.minigod.api.user.vo.SNUserBase;
import com.minigod.common.anno.TransferBean;
@TransferBean
public class SearchUser extends SNUserBase {

	private static final long serialVersionUID = -8641794288586523978L;

	private String condition;//查找用户的条件

	private int count=50;

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
