package com.minigod.api.user.flag;

public enum UserSummaryFlag {
	nickname(1 << 0), vTitle(1 << 1), userIcon(1 << 2), vType(1 << 3),uType(1 << 4);

	//属性的顺序,从0开始
	private long index;

	//构造参数
	private UserSummaryFlag(long index) {
		this.index = index;
	}

	//判断当前属性字段位移后是否为真
	public boolean isFlag(Long flag) {
		return (flag & this.getIndex()) != 0;
	}

	//获取当前顺序
	private long getIndex() {
		return index;
	}
}
