package com.minigod.persist.tables;
import com.minigod.db4j.table.AllField;
import com.minigod.db4j.table.AbstractTable;
import com.minigod.db4j.table.TableField;
import com.minigod.db4j.table.TableFieldImpl;
import java.util.HashMap;
import java.util.Map;
import java.math.BigDecimal;
import java.util.Date;
import com.minigod.db4j.table.DateTableField;
import com.minigod.db4j.table.DateTableFieldImpl;

public class TFprdCurrencyBuy extends AbstractTable {

	static {
		init();
	}

	private TFprdCurrencyBuy(){
		super.tableName = "fprd_currency_buy";
	}

	private TFprdCurrencyBuy(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TFprdCurrencyBuy getInstance() {
		return new TFprdCurrencyBuy();
	}

	public static final TFprdCurrencyBuy getInstance(String aliasName) {
		return new TFprdCurrencyBuy(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("currencyBuyId", "currency_buy_id");
		allFieldMap.put("userId", "user_id");
		allFieldMap.put("amount", "amount");
		allFieldMap.put("orderLifeCycle", "order_life_cycle");
		allFieldMap.put("buyStatus", "buy_status");
		allFieldMap.put("buyFailedMsg", "buy_failed_msg");
		allFieldMap.put("xfPayLocalId", "xf_pay_local_id");
		allFieldMap.put("xfPayRemoteId", "xf_pay_remote_id");
		allFieldMap.put("xfPayStatus", "xf_pay_status");
		allFieldMap.put("hdLocalId", "hd_local_id");
		allFieldMap.put("hdRemoteId", "hd_remote_id");
		allFieldMap.put("hdSendStatus", "hd_send_status");
		allFieldMap.put("hdErrorMsg", "hd_error_msg");
		allFieldMap.put("hdLocalOrderStatus", "hd_local_order_status");
		allFieldMap.put("hdRemoteOrderStatus", "hd_remote_order_status");
		allFieldMap.put("hdSucceedAmount", "hd_succeed_amount");
		allFieldMap.put("syncTime", "sync_time");
		allFieldMap.put("syncIntervel", "sync_intervel");
		allFieldMap.put("syncNextTime", "sync_next_time");
		allFieldMap.put("xfRefundLocalId", "xf_refund_local_id");
		allFieldMap.put("xfRefundRemoteId", "xf_refund_remote_id");
		allFieldMap.put("xfRefundSendStatus", "xf_refund_send_status");
		allFieldMap.put("xfRefundError", "xf_refund_error");
		allFieldMap.put("xfRefundOrderStatus", "xf_refund_order_status");
		allFieldMap.put("createTime", "create_time");
		allFieldMap.put("updateTime", "update_time");
		allFieldMap.put("lockVersion", "lock_version");
	}

	public String getFieldName(String javaFieldName) {
		return allFieldMap.get(javaFieldName);
	}

	public final TableField<Integer> all = new AllField<Integer>(this,  "*",null);

	public TableField<?> allField() {
		return all;
	}

	/**
	 * 订单ID 自增长字段，主键 | int(11)
	 */
	public final TableField<Integer>  pk = new TableFieldImpl<Integer>(this,"currency_buy_id","currencyBuyId","订单ID 自增长字段，主键");

	/**
	 * 乐观锁字段
	 */
	public final TableField<Integer>  lock = new TableFieldImpl<Integer>(this,"lock_version","lockVersion","订单ID 自增长字段，主键");

	public final TableField<Integer> currencyBuyId = new TableFieldImpl<Integer>(this,"currency_buy_id","currencyBuyId","订单ID 自增长字段，主键");

	/**
	 * 订单委托用户ID | int(11)
	 */
	public final TableField<Integer> userId = new TableFieldImpl<Integer>(this,"user_id","userId","订单委托用户ID");

	/**
	 * 订单金额 | decimal(16,2)
	 */
	public final TableField<BigDecimal> amount = new TableFieldImpl<BigDecimal>(this,"amount","amount","订单金额");

	/**
	 * 订单生命周期 | char(1)
	 */
	public final TableField<String> orderLifeCycle = new TableFieldImpl<String>(this,"order_life_cycle","orderLifeCycle","订单生命周期");

	/**
	 * 申购结果 I:申购中S:申购成功F:申购失败P:部分申购成功 | char(1)
	 */
	public final TableField<String> buyStatus = new TableFieldImpl<String>(this,"buy_status","buyStatus","申购结果 I:申购中S:申购成功F:申购失败P:部分申购成功");

	/**
	 * 申购失败信息 | varchar(128)
	 */
	public final TableField<String> buyFailedMsg = new TableFieldImpl<String>(this,"buy_failed_msg","buyFailedMsg","申购失败信息");

	/**
	 * 支付请求ID,与先锋支付模块对接的字段,本字段创建记录时创建，并不再变更 | varchar(23)
	 */
	public final TableField<String> xfPayLocalId = new TableFieldImpl<String>(this,"xf_pay_local_id","xfPayLocalId","支付请求ID,与先锋支付模块对接的字段,本字段创建记录时创建，并不再变更");

	/**
	 * 先锋交易订单ID | varchar(32)
	 */
	public final TableField<String> xfPayRemoteId = new TableFieldImpl<String>(this,"xf_pay_remote_id","xfPayRemoteId","先锋交易订单ID");

	/**
	 * 付款状态,Y/N,默认为N,付款回调后改为Y,红豆接口调用（红豆代扣及购买） | char(1)
	 */
	public final TableField<String> xfPayStatus = new TableFieldImpl<String>(this,"xf_pay_status","xfPayStatus","付款状态,Y/N,默认为N,付款回调后改为Y,红豆接口调用（红豆代扣及购买）");

	/**
	 * 红豆本地请求ID,本字段由付款后填入,本字段有值表示客户已经付款了,本字段一旦生成，不能再变更 | varchar(23)
	 */
	public final TableField<String> hdLocalId = new TableFieldImpl<String>(this,"hd_local_id","hdLocalId","红豆本地请求ID,本字段由付款后填入,本字段有值表示客户已经付款了,本字段一旦生成，不能再变更");

	/**
	 * 红豆交易ID,由红豆返回。 | varchar(32)
	 */
	public final TableField<String> hdRemoteId = new TableFieldImpl<String>(this,"hd_remote_id","hdRemoteId","红豆交易ID,由红豆返回。");

	/**
	 * 订单发送状态,W:等待发送,E:发生了明确错误,U:未知状态（无回应或者发生了异常）,S:成功 | char(1)
	 */
	public final TableField<String> hdSendStatus = new TableFieldImpl<String>(this,"hd_send_status","hdSendStatus","订单发送状态,W:等待发送,E:发生了明确错误,U:未知状态（无回应或者发生了异常）,S:成功");

	/**
	 * 调用返回的错误描述 | varchar(256)
	 */
	public final TableField<String> hdErrorMsg = new TableFieldImpl<String>(this,"hd_error_msg","hdErrorMsg","调用返回的错误描述");

	/**
	 * 本地订单状态,1订单成功,2订单操作中,3订单部分成功,4订单失败,将存在后台进程扫描订单状态为null或者2的订单。扫描时间需要根据2秒为基数翻倍，5分钟封顶。 | int(11)
	 */
	public final TableField<Integer> hdLocalOrderStatus = new TableFieldImpl<Integer>(this,"hd_local_order_status","hdLocalOrderStatus","本地订单状态,1订单成功,2订单操作中,3订单部分成功,4订单失败,将存在后台进程扫描订单状态为null或者2的订单。扫描时间需要根据2秒为基数翻倍，5分钟封顶。");

	/**
	 * 远程订单状态 | varchar(10)
	 */
	public final TableField<String> hdRemoteOrderStatus = new TableFieldImpl<String>(this,"hd_remote_order_status","hdRemoteOrderStatus","远程订单状态");

	/**
	 * 订单成功金额,红豆理财订单不一定成功，或者会部分成功，剩余部分需要退款。 | decimal(16,2)
	 */
	public final TableField<BigDecimal> hdSucceedAmount = new TableFieldImpl<BigDecimal>(this,"hd_succeed_amount","hdSucceedAmount","订单成功金额,红豆理财订单不一定成功，或者会部分成功，剩余部分需要退款。");

	/**
	 * 数据同步时间 | datetime
	 */
	public final DateTableField<Date> syncTime = new DateTableFieldImpl<Date>(this,"sync_time","syncTime","数据同步时间");

	/**
	 * 下次数据同步的时间间隔（秒） | int(11)
	 */
	public final TableField<Integer> syncIntervel = new TableFieldImpl<Integer>(this,"sync_intervel","syncIntervel","下次数据同步的时间间隔（秒）");

	/**
	 * 下次开始同步的时间 | datetime
	 */
	public final DateTableField<Date> syncNextTime = new DateTableFieldImpl<Date>(this,"sync_next_time","syncNextTime","下次开始同步的时间");

	/**
	 * 退款请求ID,与先锋支付模块对接的字段,当本字段有值时表示需要退款,本字段有值表示需要退款,本字段一旦生成，不能再变更 | varchar(23)
	 */
	public final TableField<String> xfRefundLocalId = new TableFieldImpl<String>(this,"xf_refund_local_id","xfRefundLocalId","退款请求ID,与先锋支付模块对接的字段,当本字段有值时表示需要退款,本字段有值表示需要退款,本字段一旦生成，不能再变更");

	/**
	 * 先锋退款远程ID | varchar(32)
	 */
	public final TableField<String> xfRefundRemoteId = new TableFieldImpl<String>(this,"xf_refund_remote_id","xfRefundRemoteId","先锋退款远程ID");

	/**
	 * 退款请求发送状态,W:等待发送,E:发生了明确错误,U:未知状态（无回应或者发生了异常）,S:成功 | char(1)
	 */
	public final TableField<String> xfRefundSendStatus = new TableFieldImpl<String>(this,"xf_refund_send_status","xfRefundSendStatus","退款请求发送状态,W:等待发送,E:发生了明确错误,U:未知状态（无回应或者发生了异常）,S:成功");

	/**
	 * 退款失败的错误信息 | varchar(256)
	 */
	public final TableField<String> xfRefundError = new TableFieldImpl<String>(this,"xf_refund_error","xfRefundError","退款失败的错误信息");

	/**
	 * 退款状态 成功S，失败F，处理中I | char(1)
	 */
	public final TableField<String> xfRefundOrderStatus = new TableFieldImpl<String>(this,"xf_refund_order_status","xfRefundOrderStatus","退款状态 成功S，失败F，处理中I");

	/**
	 * 创建时间 | datetime
	 */
	public final DateTableField<Date> createTime = new DateTableFieldImpl<Date>(this,"create_time","createTime","创建时间");

	/**
	 * 修改时间 | datetime
	 */
	public final DateTableField<Date> updateTime = new DateTableFieldImpl<Date>(this,"update_time","updateTime","修改时间");

	/**
	 * 乐观锁版本号 | int(11)
	 */
	public final TableField<Integer> lockVersion = new TableFieldImpl<Integer>(this,"lock_version","lockVersion","乐观锁版本号");

	private final TableField<?>[] allFields = new TableField<?>[] {currencyBuyId,userId,amount,orderLifeCycle,buyStatus,buyFailedMsg,xfPayLocalId,xfPayRemoteId,xfPayStatus,hdLocalId,hdRemoteId,hdSendStatus,hdErrorMsg,hdLocalOrderStatus,hdRemoteOrderStatus,hdSucceedAmount,syncTime,syncIntervel,syncNextTime,xfRefundLocalId,xfRefundRemoteId,xfRefundSendStatus,xfRefundError,xfRefundOrderStatus,createTime,updateTime,lockVersion};

	public TableField<?>[] getAllFields() {
		return allFields;
	}

	@SuppressWarnings("unchecked")
	public TableField<?> getPK() {
		return pk;
	}

	@SuppressWarnings("unchecked")
	public TableField<?> getLockVersion() {
		return lock;
	}

	public final boolean isAutoGeneratedPK() {
		return true;
	}

	public final boolean isLockVersion() {
		return true;
	}

	public String toString() {
		return "TFprdCurrencyBuy[table=fprd_currency_buy]";
	}
}
