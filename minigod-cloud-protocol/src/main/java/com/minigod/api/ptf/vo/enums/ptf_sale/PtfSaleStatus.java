package com.minigod.api.ptf.vo.enums.ptf_sale;

public enum PtfSaleStatus {
	/**
	 * 客户待付款
	 */
	A,
	/**
	 * 未付款已关闭
	 */
	B,
	/**
	 * 服务中，任务未达成
	 */
	C,
	/**
	 * 服务中，任务已达成
	 */
	D,
	/**
	 * 服务结束，任务已达成
	 */
	E,
	/**
	 * 服务结束，任务未达成
	 */
	F;
}
