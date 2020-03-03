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

public class TFprdCurrencyRedeem extends AbstractTable {

	static {
		init();
	}

	private TFprdCurrencyRedeem(){
		super.tableName = "fprd_currency_redeem";
	}

	private TFprdCurrencyRedeem(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TFprdCurrencyRedeem getInstance() {
		return new TFprdCurrencyRedeem();
	}

	public static final TFprdCurrencyRedeem getInstance(String aliasName) {
		return new TFprdCurrencyRedeem(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("currencyRedeemId", "currency_redeem_id");
		allFieldMap.put("userId", "user_id");
		allFieldMap.put("clientReqId", "client_req_id");
		allFieldMap.put("md5", "md5");
		allFieldMap.put("amount", "amount");
		allFieldMap.put("free", "free");
		allFieldMap.put("redeemFee", "redeem_fee");
		allFieldMap.put("orderLifeCycle", "order_life_cycle");
		allFieldMap.put("redeemStatus", "redeem_status");
		allFieldMap.put("redeemFailedMsg", "redeem_failed_msg");
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
		allFieldMap.put("xfWithdrawId", "xf_withdraw_id");
		allFieldMap.put("xfSendStatus", "xf_send_status");
		allFieldMap.put("xfSendError", "xf_send_error");
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
	 * 订单ID	自增长字段，主键 | int(11)
	 */
	public final TableField<Integer>  pk = new TableFieldImpl<Integer>(this,"currency_redeem_id","currencyRedeemId","订单ID	自增长字段，主键");

	/**
	 * 乐观锁字段
	 */
	public final TableField<Integer>  lock = new TableFieldImpl<Integer>(this,"lock_version","lockVersion","订单ID	自增长字段，主键");

	public final TableField<Integer> currencyRedeemId = new TableFieldImpl<Integer>(this,"currency_redeem_id","currencyRedeemId","订单ID	自增长字段，主键");

	/**
	 * 订单委托用户ID	 | int(11)
	 */
	public final TableField<Integer> userId = new TableFieldImpl<Integer>(this,"user_id","userId","订单委托用户ID	");

	/**
	 * 客户端请求ID | varchar(50)
	 */
	public final TableField<String> clientReqId = new TableFieldImpl<String>(this,"client_req_id","clientReqId","客户端请求ID");

	/**
	 * 请求数据摘要 | char(32)
	 */
	public final TableField<String> md5 = new TableFieldImpl<String>(this,"md5","md5","请求数据摘要");

	/**
	 * 申请赎回金额	 | decimal(16,2)
	 */
	public final TableField<BigDecimal> amount = new TableFieldImpl<BigDecimal>(this,"amount","amount","申请赎回金额	");

	/**
	 * 占用免费提现机会,Y/N | char(1)
	 */
	public final TableField<String> free = new TableFieldImpl<String>(this,"free","free","占用免费提现机会,Y/N");

	/**
	 * 提现手续费	 | decimal(16,2)
	 */
	public final TableField<BigDecimal> redeemFee = new TableFieldImpl<BigDecimal>(this,"redeem_fee","redeemFee","提现手续费	");

	/**
	 * 订单生命周期,A等待调用红豆接口B红豆接口调用完毕，轮询红豆订单处理状态C红豆订单处理完毕，等待调用先锋代发接口D调用先锋代发接口完毕，等待所有的先锋回调告知最终处理结果F （获得最终处理结果）订单结束 | char(1)
	 */
	public final TableField<String> orderLifeCycle = new TableFieldImpl<String>(this,"order_life_cycle","orderLifeCycle","订单生命周期,A等待调用红豆接口B红豆接口调用完毕，轮询红豆订单处理状态C红豆订单处理完毕，等待调用先锋代发接口D调用先锋代发接口完毕，等待所有的先锋回调告知最终处理结果F （获得最终处理结果）订单结束");

	/**
	 * 赎回状态,I:赎回中S:赎回成功F:赎回失败P:部分赎回成功 | char(1)
	 */
	public final TableField<String> redeemStatus = new TableFieldImpl<String>(this,"redeem_status","redeemStatus","赎回状态,I:赎回中S:赎回成功F:赎回失败P:部分赎回成功");

	/**
	 * 赎回失败信息 | varchar(128)
	 */
	public final TableField<String> redeemFailedMsg = new TableFieldImpl<String>(this,"redeem_failed_msg","redeemFailedMsg","赎回失败信息");

	/**
	 * 红豆本地请求ID,创建订单后马上生成 | varchar(23)
	 */
	public final TableField<String> hdLocalId = new TableFieldImpl<String>(this,"hd_local_id","hdLocalId","红豆本地请求ID,创建订单后马上生成");

	/**
	 * 红豆交易ID,由红豆返回。 | varchar(32)
	 */
	public final TableField<String> hdRemoteId = new TableFieldImpl<String>(this,"hd_remote_id","hdRemoteId","红豆交易ID,由红豆返回。");

	/**
	 * 订单发送状态,W:等待发送E:发生了明确错误U:未知状态（无回应或者发生了异常）S:成功 | char(1)
	 */
	public final TableField<String> hdSendStatus = new TableFieldImpl<String>(this,"hd_send_status","hdSendStatus","订单发送状态,W:等待发送E:发生了明确错误U:未知状态（无回应或者发生了异常）S:成功");

	/**
	 * 调用返回的错误描述	 | varchar(256)
	 */
	public final TableField<String> hdErrorMsg = new TableFieldImpl<String>(this,"hd_error_msg","hdErrorMsg","调用返回的错误描述	");

	/**
	 * 本地订单状态1 订单成功（钱已到 先锋齐牛商户号）2 订单操作中 3订单部分成功4订单失败 | int(1)
	 */
	public final TableField<Integer> hdLocalOrderStatus = new TableFieldImpl<Integer>(this,"hd_local_order_status","hdLocalOrderStatus","本地订单状态1 订单成功（钱已到 先锋齐牛商户号）2 订单操作中 3订单部分成功4订单失败");

	/**
	 * 远程订单状态 | varchar(10)
	 */
	public final TableField<String> hdRemoteOrderStatus = new TableFieldImpl<String>(this,"hd_remote_order_status","hdRemoteOrderStatus","远程订单状态");

	/**
	 * 赎回成功金额,红豆理财订单不一定成功，或者会部分成功，这时候需要退款。提现的金额与赎回成功的金额一致。 | decimal(16,2)
	 */
	public final TableField<BigDecimal> hdSucceedAmount = new TableFieldImpl<BigDecimal>(this,"hd_succeed_amount","hdSucceedAmount","赎回成功金额,红豆理财订单不一定成功，或者会部分成功，这时候需要退款。提现的金额与赎回成功的金额一致。");

	/**
	 *  | datetime
	 */
	public final DateTableField<Date> syncTime = new DateTableFieldImpl<Date>(this,"sync_time","syncTime","");

	/**
	 * 下次同步的时间间隔（秒） | int(11)
	 */
	public final TableField<Integer> syncIntervel = new TableFieldImpl<Integer>(this,"sync_intervel","syncIntervel","下次同步的时间间隔（秒）");

	/**
	 * 下次开始同步的时间 | datetime
	 */
	public final DateTableField<Date> syncNextTime = new DateTableFieldImpl<Date>(this,"sync_next_time","syncNextTime","下次开始同步的时间");

	/**
	 * 提现请求ID,与先锋支付模块对接的字段,本字段一旦生成，不能再变更 | varchar(23)
	 */
	public final TableField<String> xfWithdrawId = new TableFieldImpl<String>(this,"xf_withdraw_id","xfWithdrawId","提现请求ID,与先锋支付模块对接的字段,本字段一旦生成，不能再变更");

	/**
	 * 提现请求发送状态,W:等待发送,E:发生了明确错误,U:未知状态（无回应或者发生了异常）,S:成功 | char(1)
	 */
	public final TableField<String> xfSendStatus = new TableFieldImpl<String>(this,"xf_send_status","xfSendStatus","提现请求发送状态,W:等待发送,E:发生了明确错误,U:未知状态（无回应或者发生了异常）,S:成功");

	/**
	 * 提现调用失败的错误信息	 | varchar(256)
	 */
	public final TableField<String> xfSendError = new TableFieldImpl<String>(this,"xf_send_error","xfSendError","提现调用失败的错误信息	");

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

	private final TableField<?>[] allFields = new TableField<?>[] {currencyRedeemId,userId,clientReqId,md5,amount,free,redeemFee,orderLifeCycle,redeemStatus,redeemFailedMsg,hdLocalId,hdRemoteId,hdSendStatus,hdErrorMsg,hdLocalOrderStatus,hdRemoteOrderStatus,hdSucceedAmount,syncTime,syncIntervel,syncNextTime,xfWithdrawId,xfSendStatus,xfSendError,createTime,updateTime,lockVersion};

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
		return "TFprdCurrencyRedeem[table=fprd_currency_redeem]";
	}
}
