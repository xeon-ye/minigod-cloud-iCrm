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

public class TPayWxRefund extends AbstractTable {

	static {
		init();
	}

	private TPayWxRefund(){
		super.tableName = "pay_wx_refund";
	}

	private TPayWxRefund(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TPayWxRefund getInstance() {
		return new TPayWxRefund();
	}

	public static final TPayWxRefund getInstance(String aliasName) {
		return new TPayWxRefund(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("wxRefundId", "wx_refund_id");
		allFieldMap.put("srcSys", "src_sys");
		allFieldMap.put("srcBus", "src_bus");
		allFieldMap.put("srcTransId", "src_trans_id");
		allFieldMap.put("md5", "md5");
		allFieldMap.put("accountId", "account_id");
		allFieldMap.put("toRefundSys", "to_refund_sys");
		allFieldMap.put("toRefundBus", "to_refund_bus");
		allFieldMap.put("toRefundId", "to_refund_id");
		allFieldMap.put("orderAmt", "order_amt");
		allFieldMap.put("refundAmt", "refund_amt");
		allFieldMap.put("description", "description");
		allFieldMap.put("refundChannel", "refund_channel");
		allFieldMap.put("refundStatus", "refund_status");
		allFieldMap.put("refundSentTime", "refund_sent_time");
		allFieldMap.put("frzTrxId", "frz_trx_id");
		allFieldMap.put("refundTrxId", "refund_trx_id");
		allFieldMap.put("appid", "appid");
		allFieldMap.put("mchId", "mch_id");
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
	 * 微信退款订单ID | int(11)
	 */
	public final TableField<Integer>  pk = new TableFieldImpl<Integer>(this,"wx_refund_id","wxRefundId","微信退款订单ID");

	/**
	 * 乐观锁字段
	 */
	public final TableField<Integer>  lock = new TableFieldImpl<Integer>(this,"lock_version","lockVersion","微信退款订单ID");

	public final TableField<Integer> wxRefundId = new TableFieldImpl<Integer>(this,"wx_refund_id","wxRefundId","微信退款订单ID");

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
	 * 执行退款的账号 | int(11)
	 */
	public final TableField<Integer> accountId = new TableFieldImpl<Integer>(this,"account_id","accountId","执行退款的账号");

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
	 * 订单总金额 | decimal(16,2)
	 */
	public final TableField<BigDecimal> orderAmt = new TableFieldImpl<BigDecimal>(this,"order_amt","orderAmt","订单总金额");

	/**
	 * 退款金额 | decimal(16,2)
	 */
	public final TableField<BigDecimal> refundAmt = new TableFieldImpl<BigDecimal>(this,"refund_amt","refundAmt","退款金额");

	/**
	 * 订单描述 | varchar(32)
	 */
	public final TableField<String> description = new TableFieldImpl<String>(this,"description","description","订单描述");

	/**
	 * 退款渠道 | char(1)
	 */
	public final TableField<String> refundChannel = new TableFieldImpl<String>(this,"refund_channel","refundChannel","退款渠道");

	/**
	 * 退款状态 | char(1)
	 */
	public final TableField<String> refundStatus = new TableFieldImpl<String>(this,"refund_status","refundStatus","退款状态");

	/**
	 * 退款申请发送时间 | datetime
	 */
	public final DateTableField<Date> refundSentTime = new DateTableFieldImpl<Date>(this,"refund_sent_time","refundSentTime","退款申请发送时间");

	/**
	 * 冻结退款的交易ID | int(11)
	 */
	public final TableField<Integer> frzTrxId = new TableFieldImpl<Integer>(this,"frz_trx_id","frzTrxId","冻结退款的交易ID");

	/**
	 * 确认微信退款后的交易ID | int(11)
	 */
	public final TableField<Integer> refundTrxId = new TableFieldImpl<Integer>(this,"refund_trx_id","refundTrxId","确认微信退款后的交易ID");

	/**
	 * 公众账号ID | varchar(32)
	 */
	public final TableField<String> appid = new TableFieldImpl<String>(this,"appid","appid","公众账号ID");

	/**
	 * 商户号 | varchar(32)
	 */
	public final TableField<String> mchId = new TableFieldImpl<String>(this,"mch_id","mchId","商户号");

	/**
	 * 备注信息 | varchar(128)
	 */
	public final TableField<String> remark = new TableFieldImpl<String>(this,"remark","remark","备注信息");

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

	private final TableField<?>[] allFields = new TableField<?>[] {wxRefundId,srcSys,srcBus,srcTransId,md5,accountId,toRefundSys,toRefundBus,toRefundId,orderAmt,refundAmt,description,refundChannel,refundStatus,refundSentTime,frzTrxId,refundTrxId,appid,mchId,remark,isStatus,createTime,updateTime,lockVersion};

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
		return "TPayWxRefund[table=pay_wx_refund]";
	}
}
