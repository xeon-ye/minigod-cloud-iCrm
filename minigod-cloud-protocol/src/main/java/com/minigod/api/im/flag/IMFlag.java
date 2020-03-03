package com.minigod.api.im.flag;

public enum IMFlag {
	GROUPID(1 << 0), // 群ID String
	GROUPNAME(1 << 1), // 群名称 String
	DESCRIPTION(1 << 2), // 群描述 String
	ICON(1 << 3), // 群头像 String
	MAXUSERS(1 << 4), // 最大人数 Integer
	CHARGE(1 << 5), // 费用
	NEEDVERIFY(1 << 6), // 是否需要验证 String Y – 需要, N – 不需要
	ANNOUNCEMENT(1 << 7); // 群公告类型 Integer

	// 属性的顺序,从0开始
	private long index;

	// 构造参数
	private IMFlag(long index) {
		this.index = index;
	}

	// 判断当前属性字段位移后是否为真
	public boolean isFlag(Long flag) {
		return (flag & this.getIndex()) != 0;
	}

	// 获取当前顺序
	private long getIndex() {
		return index;
	}
}