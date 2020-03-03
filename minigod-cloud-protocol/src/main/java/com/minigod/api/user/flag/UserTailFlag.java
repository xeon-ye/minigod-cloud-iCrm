package com.minigod.api.user.flag;

public enum UserTailFlag {
	nickname(1L << 0), //
	vTitle(1L << 1), //
	userIcon(1L << 2), //
	vType(1L << 3), //
	gender(1L << 4), //
	phoneNum(1L << 5), //
	profile(1L << 6), //
	signature(1L << 7), //
	bigUserIcon(1L << 8), //
	status(1L << 9), //
	cmnt(1L << 10), //
	uType(1L << 11), //
	adviser(1L << 12), //
	imId(1L << 13), //
	imPwd(1L << 14), //
	userId(1L << 15), //
	ptfCnt(1L << 16), //
	maxPer(1L << 17), //
	canOpen(1L << 18), //
	openFunc(1L << 19), //
	optStkCnt(1L << 20), //自选股数量
	investMsgCnt(1L << 21), //投资圈数量
	adviserCnt(1L << 22), //投顾数量
	myAdvisers(1L << 23), //我的投顾列表(个人主页使用)
	customerInfo(1L << 24), //客户匹配问题列表
	customerCnt(1L << 25), //粉丝数量
	specialFields(1L << 26), //擅长领域
	investAbility(1L << 27), //投资能力
	qaAllCnt(1L << 28), //问答记录数
	latestViewpoint(1L << 29), //最新的观点
	knowDay(1L << 30), //认识天数
	relation(1L << 31), //用户关系
	adviserCusRelation(1L << 32),//投顾-客户关系属性
	friendCnt(1L << 33),//客户中好友人数
	friendDesc(1L << 34),//好友描述信息
	qaUnreadCnt(1L << 35),//未读观点记录数
	myAdviserExts(1L << 36);//我的投顾列表(服务空间使用)

	// 属性的顺序,从0开始
	private long index;

	// 构造参数
	private UserTailFlag(long index) {
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