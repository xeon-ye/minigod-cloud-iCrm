package com.minigod.api.ptf.vo.flag;

/**
 * @Title: PtfInfoFlag.java
 * @Description: 组合信息标志位枚举对象
 * @Copyright: © 2014 minigod
 * @Company: minigod
 * 
 * @author minigod
 * @date 2014-11-11 下午2:38:14
 * @version v1.0
 */

public enum PtfInfoFlag {

	// 字段枚举，对应的接口：get_ptf_info
	imgUrl(1L << 0), // 组合图片的url地址
	name(1L << 1), // 组合名称
	ptfId(1L << 2), // 组合id
	ptfIdx(1L << 3), // 组合最新指数
	tdYield(1L << 4), // 日收益率
	mYield(1L << 5), // 月收益率
	yYield(1L << 6), // 年收益率
	tYield(1L << 7), // 创建以来的收益率
	runTime(1L << 8), // 组合创建以来运行的时间，单位：天
	desc(1L << 9), // 组合描述
	perm(1L << 10), // 组合可见权限
	idxTs(1L << 11), // 净值日期
	bchType(1L << 12), // 业绩基准
	bchId(1L << 13), // 业绩基准id
	mktStatus(1L << 14), // 市场状态
	fowCnt(1L << 15), // 跟单人数
	notes(1L << 16), // 笔记条数
	owner(1L << 17), // 组合所有者
	volatility(1L << 18), // 波动率
	uId(1L << 19), // 组合创建的用户id
	uName(1L << 20), // 组合创建者的用户名
	uImg(1L << 21), // 组合创建的用户图像
	stocks(1L << 22), // 资产详情
	createTime(1L << 23), // 组合的创建时间
	isReal(1L << 24), // 是否实盘
	pe(1L << 25), // 市盈率
	like(1L << 26), // 是否已赞
	stkCate(1L << 27), // 股票大类
	favCnt(1L << 28), // 关注人数
	fav(1L << 29), // 关注者
	fow(1L << 30), // 跟单者
	likeCnt(1L << 31), // 点赞个数
	isTransing(1L << 32), // 创建人是否存在在途交易
	authShare(1L << 33), // 允许他人分享
	favPers(1L << 34), // 关注者集合
	fowPers(1L << 35), // 购买者集合
	brkId(1L << 36), // 组合实盘券商ID
	uType(1L << 37), // 创建者用户类型
	ptfWinRate(1L << 38), // 组合选股胜率
	ptfMaxRetrace(1L << 39), // 组合最大回测
	saleInfo(1L << 40), // 收费订阅信息
	buyInfo(1L << 41), // 订阅信息
	rebalance(1L << 42), // 最近一次调仓
	ptfDetailForm(1L << 43), // 组合详情展示形式
	stkWeight(1L << 44), // 组合详情展示形式
	saleCount(1L << 45),//组合售出份数
	avgMonthYield(1L << 46),//月均收益 只有在拉取组合列表且拉取组合的类型为 G,H,I时有效
	needToBuildRelation(1L << 47);//访问者与组合创建者的关系
	
	
	// 属性的顺序，从0开始
	private long index;

	// 构造函数
	private PtfInfoFlag(long index) {
		this.index = index;
	}

	// 判断当前属性字段位与后是否为真，如果为真说明该字段需要传值给前端
	public boolean isFlag(Long flag) {
		return (flag & this.getIndex()) != 0;
	}

	// 获取当前枚举值的顺序
	public long getIndex() {
		return index;
	}

}
