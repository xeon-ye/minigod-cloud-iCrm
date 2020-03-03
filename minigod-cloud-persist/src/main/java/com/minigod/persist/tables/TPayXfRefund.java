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

public class TPayXfRefund extends AbstractTable {

	static {
		init();
	}

	private TPayXfRefund(){
		super.tableName = "pay_xf_refund";
	}

	private TPayXfRefund(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TPayXfRefund getInstance() {
		return new TPayXfRefund();
	}

	public static final TPayXfRefund getInstance(String aliasName) {
		return new TPayXfRefund(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("xfRefundId", "xf_refund_id");
		allFieldMap.put("srcSys", "src_sys");
		allFieldMap.put("srcBus", "src_bus");
		allFieldMap.put("srcTransId", "src_trans_id");
		allFieldMap.put("md5", "md5");
		allFieldMap.put("toRefundSys", "to_refund_sys");
		allFieldMap.put("toRefundBus", "to_refund_bus");
		allFieldMap.put("toRefundId", "to_refund_id");
		allFieldMap.put("tradeNo", "trade_no");
		allFieldMap.put("orderAmt", "order_amt");
		allFieldMap.put("refundAmt", "refund_amt");
		allFieldMap.put("description", "description");
		allFieldMap.put("sendStatus", "send_status");
		allFieldMap.put("refundStatus", "refund_status");
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
	 * 先锋退款订单ID,主键，自增长 | int(11)
	 */
	public final TableField<Integer>  pk = new TableFieldImpl<Integer>(this,"xf_refund_id","xfRefundId","先锋退款订单ID,主键，自增长");

	/**
	 * 乐观锁字段
	 */
	public final TableField<Integer>  lock = new TableFieldImpl<Integer>(this,"lock_version","lockVersion","先锋退款订单ID,主键，自增长");

	public final TableField<Integer> xfRefundId = new TableFieldImpl<Integer>(this,"xf_refund_id","xfRefundId","先锋退款订单ID,主键，自增长");

	/**
	 * 请求来源系统,齐牛内部业务系统登记到账务系统的代号 | char(3)
	 */
	public final TableField<String> srcSys = new TableFieldImpl<String>(this,"src_sys","srcSys","请求来源系统,齐牛内部业务系统登记到账务系统的代号");

	/**
	 * 请求来源业务,齐牛内部业务系统功能登记到账务系统的代号 | char(6)
	 */
	public final TableField<String> srcBus = new TableFieldImpl<String>(this,"src_bus","srcBus","请求来源业务,齐牛内部业务系统功能登记到账务系统的代号");

	/**
	 * 客户端交易ID,调用者传入的业务内不重复的字符串 | varchar(23)
	 */
	public final TableField<String> srcTransId = new TableFieldImpl<String>(this,"src_trans_id","srcTransId","客户端交易ID,调用者传入的业务内不重复的字符串");

	/**
	 * 请求数据摘要,用于判断同一业务具有相同客户端交易ID的请求是否相等 | char(32)
	 */
	public final TableField<String> md5 = new TableFieldImpl<String>(this,"md5","md5","请求数据摘要,用于判断同一业务具有相同客户端交易ID的请求是否相等");

	/**
	 * 需要退款的订单所在系统 | char(3)
	 */
	public final TableField<String> toRefundSys = new TableFieldImpl<String>(this,"to_refund_sys","toRefundSys","需要退款的订单所在系统");

	/**
	 * 需要退款的订单所属业务 | char(6)
	 */
	public final TableField<String> toRefundBus = new TableFieldImpl<String>(this,"to_refund_bus","toRefundBus","需要退款的订单所属业务");

	/**
	 * 需要退款的订单的交易Id | varchar(23)
	 */
	public final TableField<String> toRefundId = new TableFieldImpl<String>(this,"to_refund_id","toRefundId","需要退款的订单的交易Id");

	/**
	 * 先锋订单号 | varchar(32)
	 */
	public final TableField<String> tradeNo = new TableFieldImpl<String>(this,"trade_no","tradeNo","先锋订单号");

	/**
	 * 订单总金额,发送退款申请时要用到 | decimal(16,2)
	 */
	public final TableField<BigDecimal> orderAmt = new TableFieldImpl<BigDecimal>(this,"order_amt","orderAmt","订单总金额,发送退款申请时要用到");

	/**
	 * 退款金额 | decimal(16,2)
	 */
	public final TableField<BigDecimal> refundAmt = new TableFieldImpl<BigDecimal>(this,"refund_amt","refundAmt","退款金额");

	/**
	 * 订单描述,商品或者支付的简要描述 | varchar(32)
	 */
	public final TableField<String> description = new TableFieldImpl<String>(this,"description","description","订单描述,商品或者支付的简要描述");

	/**
	 * 请求发送状态,A:客户申请提现，等待OMS批准W:等待发送(正常情况只会极短瞬间出现，否则，程序必然发生了异常)U:未知状态（不确定是否提现成功）E:失败。S:发送成功 | varchar(1)
	 */
	public final TableField<String> sendStatus = new TableFieldImpl<String>(this,"send_status","sendStatus","请求发送状态,A:客户申请提现，等待OMS批准W:等待发送(正常情况只会极短瞬间出现，否则，程序必然发生了异常)U:未知状态（不确定是否提现成功）E:失败。S:发送成功");

	/**
	 * 退款状态,处理中I成功S失败F | char(1)
	 */
	public final TableField<String> refundStatus = new TableFieldImpl<String>(this,"refund_status","refundStatus","退款状态,处理中I成功S失败F");

	/**
	 * 备注信息 | varchar(128)
	 */
	public final TableField<String> remark = new TableFieldImpl<String>(this,"remark","remark","备注信息");

	/**
	 * 记录状态,1-有效，0-无效（删除） | tinyint(1)
	 */
	public final TableField<Boolean> isStatus = new TableFieldImpl<Boolean>(this,"is_status","isStatus","记录状态,1-有效，0-无效（删除）");

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

	private final TableField<?>[] allFields = new TableField<?>[] {xfRefundId,srcSys,srcBus,srcTransId,md5,toRefundSys,toRefundBus,toRefundId,tradeNo,orderAmt,refundAmt,description,sendStatus,refundStatus,remark,isStatus,createTime,updateTime,lockVersion};

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
		return false;
	}

	public final boolean isLockVersion() {
		return true;
	}

	public String toString() {
		return "TPayXfRefund[table=pay_xf_refund]";
	}
}
