package com.minigod.api.gateway.vo;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-3-10 下午3:02:43
 * @version v1.0
 */
public class ReqType {
	public static final int BINDACC = 1; // 账号绑定
	public static final int UNBINDACC = 2; // 账号解绑
	public static final int LOGIN = 3; // 登录
	public static final int ORDER = 4; // 下单
	public static final int MODIFYPWD = 5; // 修改密码
	public static final int WITHDRAW = 6; // 撤单
	public static final int DEPOSIT = 7; // 资金查询
	public static final int POSITION = 8; // 当前持仓查询
	public static final int TODAYCMF = 9; // 当日成交查询
	public static final int HISCFM = 10; // 历史成交查询
	public static final int TODAYORDER = 11; // 当日委托查询
	public static final int HISORDER = 12; // 历史委托 查询
	public static final int DELIVERQRY = 13; // 交割单查询
	public static final int DEPOSITVCH = 14; // 资金流水查询
	public static final int STKACC = 15; // 股东号查询
	public static final int CUSTTINFO = 16; // 客户资料查询
	public static final int MULTIORDER = 17; // 批量下单
	public static final int MULTIWITHDRAW = 18; // 批量撤单

}