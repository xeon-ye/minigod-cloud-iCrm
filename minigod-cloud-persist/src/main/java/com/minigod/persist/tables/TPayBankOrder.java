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

public class TPayBankOrder extends AbstractTable {

	static {
		init();
	}

	private TPayBankOrder(){
		super.tableName = "pay_bank_order";
	}

	private TPayBankOrder(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TPayBankOrder getInstance() {
		return new TPayBankOrder();
	}

	public static final TPayBankOrder getInstance(String aliasName) {
		return new TPayBankOrder(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("bankOrderId", "bank_order_id");
		allFieldMap.put("srcSys", "src_sys");
		allFieldMap.put("srcBus", "src_bus");
		allFieldMap.put("srcTransId", "src_trans_id");
		allFieldMap.put("md5", "md5");
		allFieldMap.put("accountId", "account_id");
		allFieldMap.put("userId", "user_id");
		allFieldMap.put("feeType", "fee_type");
		allFieldMap.put("totalFee", "total_fee");
		allFieldMap.put("display", "display");
		allFieldMap.put("incomeOrExpense", "income_or_expense");
		allFieldMap.put("des", "des");
		allFieldMap.put("detail", "detail");
		allFieldMap.put("finishStatus", "finish_status");
		allFieldMap.put("payStatus", "pay_status");
		allFieldMap.put("cbStatus", "cb_status");
		allFieldMap.put("actStatus", "act_status");
		allFieldMap.put("transactionId", "transaction_id");
		allFieldMap.put("frzAmt", "frz_amt");
		allFieldMap.put("refundAmt", "refund_amt");
		allFieldMap.put("mchId", "mch_id");
		allFieldMap.put("billCreateIp", "bill_create_ip");
		allFieldMap.put("timeStart", "time_start");
		allFieldMap.put("timeExpire", "time_expire");
		allFieldMap.put("tradeType", "trade_type");
		allFieldMap.put("limitPay", "limit_pay");
		allFieldMap.put("prepayId", "prepay_id");
		allFieldMap.put("bankErrMsg", "bank_err_msg");
		allFieldMap.put("cbMethod", "cb_method");
		allFieldMap.put("cbAttach", "cb_attach");
		allFieldMap.put("cbRbReturn", "cb_rb_return");
		allFieldMap.put("cbTryTime", "cb_try_time");
		allFieldMap.put("cbErrMsg", "cb_err_msg");
		allFieldMap.put("remark", "remark");
		allFieldMap.put("isStatus", "is_status");
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
	 * 银行卡支付订单ID | int(11)
	 */
	public final TableField<Integer>  pk = new TableFieldImpl<Integer>(this,"bank_order_id","bankOrderId","银行卡支付订单ID");

	/**
	 * 乐观锁字段
	 */
	public final TableField<Integer>  lock = new TableFieldImpl<Integer>(this,"lock_version","lockVersion","银行卡支付订单ID");

	public final TableField<Integer> bankOrderId = new TableFieldImpl<Integer>(this,"bank_order_id","bankOrderId","银行卡支付订单ID");

	/**
	 * 请求来源系统 | char(3)
	 */
	public final TableField<String> srcSys = new TableFieldImpl<String>(this,"src_sys","srcSys","请求来源系统");

	/**
	 * 请求来源业务 | char(6)
	 */
	public final TableField<String> srcBus = new TableFieldImpl<String>(this,"src_bus","srcBus","请求来源业务");

	/**
	 * 客户端交易ID | varchar(23)
	 */
	public final TableField<String> srcTransId = new TableFieldImpl<String>(this,"src_trans_id","srcTransId","客户端交易ID");

	/**
	 * 请求数据摘要 | char(32)
	 */
	public final TableField<String> md5 = new TableFieldImpl<String>(this,"md5","md5","请求数据摘要");

	/**
	 * 账户表ID | int(11)
	 */
	public final TableField<Integer> accountId = new TableFieldImpl<Integer>(this,"account_id","accountId","账户表ID");

	/**
	 * 犇犇用户id | int(11)
	 */
	public final TableField<Integer> userId = new TableFieldImpl<Integer>(this,"user_id","userId","犇犇用户id");

	/**
	 * 货币类型 | char(3)
	 */
	public final TableField<String> feeType = new TableFieldImpl<String>(this,"fee_type","feeType","货币类型");

	/**
	 * 支付金额 | decimal(16,2)
	 */
	public final TableField<BigDecimal> totalFee = new TableFieldImpl<BigDecimal>(this,"total_fee","totalFee","支付金额");

	/**
	 * 是否在钱包中显示 | char(1)
	 */
	public final TableField<String> display = new TableFieldImpl<String>(this,"display","display","是否在钱包中显示");

	/**
	 * 是否为收支项 | char(1)
	 */
	public final TableField<String> incomeOrExpense = new TableFieldImpl<String>(this,"income_or_expense","incomeOrExpense","是否为收支项");

	/**
	 * 订单描述 | varchar(32)
	 */
	public final TableField<String> des = new TableFieldImpl<String>(this,"des","des","订单描述");

	/**
	 * 订单详细描述 | varchar(1024)
	 */
	public final TableField<String> detail = new TableFieldImpl<String>(this,"detail","detail","订单详细描述");

	/**
	 * 订单结束状态 | char(1)
	 */
	public final TableField<String> finishStatus = new TableFieldImpl<String>(this,"finish_status","finishStatus","订单结束状态");

	/**
	 * 银行卡订单状态 | char(1)
	 */
	public final TableField<String> payStatus = new TableFieldImpl<String>(this,"pay_status","payStatus","银行卡订单状态");

	/**
	 * 回调状态 | char(1)
	 */
	public final TableField<String> cbStatus = new TableFieldImpl<String>(this,"cb_status","cbStatus","回调状态");

	/**
	 * 是否已记账 | char(1)
	 */
	public final TableField<String> actStatus = new TableFieldImpl<String>(this,"act_status","actStatus","是否已记账");

	/**
	 * 支付对应的交易请求表ID | int(11)
	 */
	public final TableField<Integer> transactionId = new TableFieldImpl<Integer>(this,"transaction_id","transactionId","支付对应的交易请求表ID");

	/**
	 * 冻结的金额 | decimal(16,2)
	 */
	public final TableField<BigDecimal> frzAmt = new TableFieldImpl<BigDecimal>(this,"frz_amt","frzAmt","冻结的金额");

	/**
	 * 已申请退款金额 | decimal(16,2)
	 */
	public final TableField<BigDecimal> refundAmt = new TableFieldImpl<BigDecimal>(this,"refund_amt","refundAmt","已申请退款金额");

	/**
	 * 商户号 | varchar(32)
	 */
	public final TableField<String> mchId = new TableFieldImpl<String>(this,"mch_id","mchId","商户号");

	/**
	 * 终端IP | varchar(16)
	 */
	public final TableField<String> billCreateIp = new TableFieldImpl<String>(this,"bill_create_ip","billCreateIp","终端IP");

	/**
	 * 交易起始时间 | datetime
	 */
	public final DateTableField<Date> timeStart = new DateTableFieldImpl<Date>(this,"time_start","timeStart","交易起始时间");

	/**
	 * 交易结束时间 | datetime
	 */
	public final DateTableField<Date> timeExpire = new DateTableFieldImpl<Date>(this,"time_expire","timeExpire","交易结束时间");

	/**
	 * 交易类型 | varchar(16)
	 */
	public final TableField<String> tradeType = new TableFieldImpl<String>(this,"trade_type","tradeType","交易类型");

	/**
	 * 指定支付方式 | varchar(32)
	 */
	public final TableField<String> limitPay = new TableFieldImpl<String>(this,"limit_pay","limitPay","指定支付方式");

	/**
	 * 预支付交易会话标识 | varchar(64)
	 */
	public final TableField<String> prepayId = new TableFieldImpl<String>(this,"prepay_id","prepayId","预支付交易会话标识");

	/**
	 * 订单创建失败信息 | varchar(128)
	 */
	public final TableField<String> bankErrMsg = new TableFieldImpl<String>(this,"bank_err_msg","bankErrMsg","订单创建失败信息");

	/**
	 * 回调的方法识别标志 | varchar(50)
	 */
	public final TableField<String> cbMethod = new TableFieldImpl<String>(this,"cb_method","cbMethod","回调的方法识别标志");

	/**
	 * 附加信息 | varchar(1024)
	 */
	public final TableField<String> cbAttach = new TableFieldImpl<String>(this,"cb_attach","cbAttach","附加信息");

	/**
	 * 银行卡回调的传入完整信息 | varchar(5120)
	 */
	public final TableField<String> cbRbReturn = new TableFieldImpl<String>(this,"cb_rb_return","cbRbReturn","银行卡回调的传入完整信息");

	/**
	 * 尝试回调失败次数 | int(11)
	 */
	public final TableField<Integer> cbTryTime = new TableFieldImpl<Integer>(this,"cb_try_time","cbTryTime","尝试回调失败次数");

	/**
	 * 回调的错误信息 | varchar(1024)
	 */
	public final TableField<String> cbErrMsg = new TableFieldImpl<String>(this,"cb_err_msg","cbErrMsg","回调的错误信息");

	/**
	 * 备注 | varchar(128)
	 */
	public final TableField<String> remark = new TableFieldImpl<String>(this,"remark","remark","备注");

	/**
	 * 记录状态 | tinyint(1)
	 */
	public final TableField<Boolean> isStatus = new TableFieldImpl<Boolean>(this,"is_status","isStatus","记录状态");

	/**
	 * 记录创建时间 | datetime
	 */
	public final DateTableField<Date> createTime = new DateTableFieldImpl<Date>(this,"create_time","createTime","记录创建时间");

	/**
	 * 记录修改时间 | datetime
	 */
	public final DateTableField<Date> updateTime = new DateTableFieldImpl<Date>(this,"update_time","updateTime","记录修改时间");

	/**
	 * 乐观锁版本号 | int(11)
	 */
	public final TableField<Integer> lockVersion = new TableFieldImpl<Integer>(this,"lock_version","lockVersion","乐观锁版本号");

	private final TableField<?>[] allFields = new TableField<?>[] {bankOrderId,srcSys,srcBus,srcTransId,md5,accountId,userId,feeType,totalFee,display,incomeOrExpense,des,detail,finishStatus,payStatus,cbStatus,actStatus,transactionId,frzAmt,refundAmt,mchId,billCreateIp,timeStart,timeExpire,tradeType,limitPay,prepayId,bankErrMsg,cbMethod,cbAttach,cbRbReturn,cbTryTime,cbErrMsg,remark,isStatus,createTime,updateTime,lockVersion};

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
		return "TPayBankOrder[table=pay_bank_order]";
	}
}
