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

public class TPtfSale extends AbstractTable {

	static {
		init();
	}

	private TPtfSale(){
		super.tableName = "ptf_sale";
	}

	private TPtfSale(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TPtfSale getInstance() {
		return new TPtfSale();
	}

	public static final TPtfSale getInstance(String aliasName) {
		return new TPtfSale(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("ptfSaleId", "ptf_sale_id");
		allFieldMap.put("sellerUserId", "seller_user_id");
		allFieldMap.put("ptfId", "ptf_id");
		allFieldMap.put("buyUserId", "buy_user_id");
		allFieldMap.put("priceType", "price_type");
		allFieldMap.put("price", "price");
		allFieldMap.put("ptfNameSnapshot", "ptf_name_snapshot");
		allFieldMap.put("ptfDescSnapshot", "ptf_desc_snapshot");
		allFieldMap.put("saleDesc", "sale_desc");
		allFieldMap.put("startDate", "start_date");
		allFieldMap.put("endDate", "end_date");
		allFieldMap.put("targetYield", "target_yield");
		allFieldMap.put("indexType", "index_type");
		allFieldMap.put("beginIndex", "begin_index");
		allFieldMap.put("endIndex", "end_index");
		allFieldMap.put("highIndex", "high_index");
		allFieldMap.put("highDate", "high_date");
		allFieldMap.put("achieveDateIndex", "achieve_date_index");
		allFieldMap.put("achieveDate", "achieve_date");
		allFieldMap.put("ptfSaleStatus", "ptf_sale_status");
		allFieldMap.put("needRetry", "need_retry");
		allFieldMap.put("chargeOrderId", "charge_order_id");
		allFieldMap.put("payChannel", "pay_channel");
		allFieldMap.put("chargeTrxId", "charge_trx_id");
		allFieldMap.put("transferOrderId", "transfer_order_id");
		allFieldMap.put("transferStatus", "transfer_status");
		allFieldMap.put("transferError", "transfer_error");
		allFieldMap.put("transferTrxId", "transfer_trx_id");
		allFieldMap.put("payOrderId", "pay_order_id");
		allFieldMap.put("payStatus", "pay_status");
		allFieldMap.put("payError", "pay_error");
		allFieldMap.put("payTrxId", "pay_trx_id");
		allFieldMap.put("payActualAmt", "pay_actual_amt");
		allFieldMap.put("payFee", "pay_fee");
		allFieldMap.put("refundOrderId", "refund_order_id");
		allFieldMap.put("refundStatus", "refund_status");
		allFieldMap.put("refundError", "refund_error");
		allFieldMap.put("refundToUserTrxId", "refund_to_user_trx_id");
		allFieldMap.put("refundToWxTrxId", "refund_to_wx_trx_id");
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
	 * 主键  自增长 | int(11)
	 */
	public final TableField<Integer>  pk = new TableFieldImpl<Integer>(this,"ptf_sale_id","ptfSaleId","主键  自增长");

	/**
	 * 乐观锁字段
	 */
	public final TableField<Integer>  lock = new TableFieldImpl<Integer>(this,"lock_version","lockVersion","主键  自增长");

	public final TableField<Integer> ptfSaleId = new TableFieldImpl<Integer>(this,"ptf_sale_id","ptfSaleId","主键  自增长");

	/**
	 * 组合所有者ID | int(11)
	 */
	public final TableField<Integer> sellerUserId = new TableFieldImpl<Integer>(this,"seller_user_id","sellerUserId","组合所有者ID");

	/**
	 * 组合ID  购买的组合 | int(11)
	 */
	public final TableField<Integer> ptfId = new TableFieldImpl<Integer>(this,"ptf_id","ptfId","组合ID  购买的组合");

	/**
	 * 购买用户ID   | int(11)
	 */
	public final TableField<Integer> buyUserId = new TableFieldImpl<Integer>(this,"buy_user_id","buyUserId","购买用户ID  ");

	/**
	 * 价格类型  N:正价S:优惠价格 | char(1)
	 */
	public final TableField<String> priceType = new TableFieldImpl<String>(this,"price_type","priceType","价格类型  N:正价S:优惠价格");

	/**
	 * 价格  购买价格 | decimal(16,2)
	 */
	public final TableField<BigDecimal> price = new TableFieldImpl<BigDecimal>(this,"price","price","价格  购买价格");

	/**
	 * 组合名称  不超过30个汉字(备查,客户端不显示) | varchar(90)
	 */
	public final TableField<String> ptfNameSnapshot = new TableFieldImpl<String>(this,"ptf_name_snapshot","ptfNameSnapshot","组合名称  不超过30个汉字(备查,客户端不显示)");

	/**
	 * 组合描述  投资理念的描述 | varchar(450)
	 */
	public final TableField<String> ptfDescSnapshot = new TableFieldImpl<String>(this,"ptf_desc_snapshot","ptfDescSnapshot","组合描述  投资理念的描述");

	/**
	 * 收费描述   | varchar(512)
	 */
	public final TableField<String> saleDesc = new TableFieldImpl<String>(this,"sale_desc","saleDesc","收费描述  ");

	/**
	 * 服务开始交易日  交易日早上九点后购买组合则服务开始时间为下一个交易日 | date
	 */
	public final DateTableField<Date> startDate = new DateTableFieldImpl<Date>(this,"start_date","startDate","服务开始交易日  交易日早上九点后购买组合则服务开始时间为下一个交易日");

	/**
	 * 服务结束交易日   | date
	 */
	public final DateTableField<Date> endDate = new DateTableFieldImpl<Date>(this,"end_date","endDate","服务结束交易日  ");

	/**
	 * 组合收费目标收益率   | decimal(3,2)
	 */
	public final TableField<BigDecimal> targetYield = new TableFieldImpl<BigDecimal>(this,"target_yield","targetYield","组合收费目标收益率  ");

	/**
	 * 指数类型 R:实盘 S:模拟盘 | char(1)
	 */
	public final TableField<String> indexType = new TableFieldImpl<String>(this,"index_type","indexType","指数类型 R:实盘 S:模拟盘");

	/**
	 * 服务开始指数  服务开始的交易日的上一个交易日的指数（待确认） | decimal(10,4)
	 */
	public final TableField<BigDecimal> beginIndex = new TableFieldImpl<BigDecimal>(this,"begin_index","beginIndex","服务开始指数  服务开始的交易日的上一个交易日的指数（待确认）");

	/**
	 * 服务结束指数  服务结束的交易日收盘后计算 | decimal(10,4)
	 */
	public final TableField<BigDecimal> endIndex = new TableFieldImpl<BigDecimal>(this,"end_index","endIndex","服务结束指数  服务结束的交易日收盘后计算");

	/**
	 * 服务期间最高收益的指数 服务期间每个交易日收盘后计算 | decimal(10,4)
	 */
	public final TableField<BigDecimal> highIndex = new TableFieldImpl<BigDecimal>(this,"high_index","highIndex","服务期间最高收益的指数 服务期间每个交易日收盘后计算");

	/**
	 * 服务期间最高收益的日期 服务期间每个交易日收盘后计算 | date
	 */
	public final DateTableField<Date> highDate = new DateTableFieldImpl<Date>(this,"high_date","highDate","服务期间最高收益的日期 服务期间每个交易日收盘后计算");

	/**
	 * 达到预期收益的日期的指数  服务期间每个交易日收盘后计算 | decimal(10,4)
	 */
	public final TableField<BigDecimal> achieveDateIndex = new TableFieldImpl<BigDecimal>(this,"achieve_date_index","achieveDateIndex","达到预期收益的日期的指数  服务期间每个交易日收盘后计算");

	/**
	 * 达到预期收益的日期 服务期间每个交易日收盘后计算 | date
	 */
	public final DateTableField<Date> achieveDate = new DateTableFieldImpl<Date>(this,"achieve_date","achieveDate","达到预期收益的日期 服务期间每个交易日收盘后计算");

	/**
	 * 订单状态  A:客户待付款B:未付款已关闭C:服务中，任务未达成D:服务中，任务已达成E:服务结束，任务已达成F:服务结束，任务未达成 | char(1)
	 */
	public final TableField<String> ptfSaleStatus = new TableFieldImpl<String>(this,"ptf_sale_status","ptfSaleStatus","订单状态  A:客户待付款B:未付款已关闭C:服务中，任务未达成D:服务中，任务已达成E:服务结束，任务已达成F:服务结束，任务未达成");

	/**
	 * 存在业务需要重试  Y/N | char(1)
	 */
	public final TableField<String> needRetry = new TableFieldImpl<String>(this,"need_retry","needRetry","存在业务需要重试  Y/N");

	/**
	 * 申请支付订单的ID 本地生成，申请支付订单的ID | varchar(23)
	 */
	public final TableField<String> chargeOrderId = new TableFieldImpl<String>(this,"charge_order_id","chargeOrderId","申请支付订单的ID 本地生成，申请支付订单的ID");

	/**
	 * 当前支付渠道  W:微信 | char(1)
	 */
	public final TableField<String> payChannel = new TableFieldImpl<String>(this,"pay_channel","payChannel","当前支付渠道  W:微信");

	/**
	 * 客户充值账务ID  把客户支付的钱转到客户账户中。 | int(11)
	 */
	public final TableField<Integer> chargeTrxId = new TableFieldImpl<Integer>(this,"charge_trx_id","chargeTrxId","客户充值账务ID  把客户支付的钱转到客户账户中。");

	/**
	 * 申请转账到组合收费账户的ID  本地生成，申请转账的ID | varchar(23)
	 */
	public final TableField<String> transferOrderId = new TableFieldImpl<String>(this,"transfer_order_id","transferOrderId","申请转账到组合收费账户的ID  本地生成，申请转账的ID");

	/**
	 * 转账状态  W:等待转账E:转账超时F:转账失败（有明确的错误原因）S:转账已成功 | char(1)
	 */
	public final TableField<String> transferStatus = new TableFieldImpl<String>(this,"transfer_status","transferStatus","转账状态  W:等待转账E:转账超时F:转账失败（有明确的错误原因）S:转账已成功");

	/**
	 * 转账失败的描述  | varchar(256)
	 */
	public final TableField<String> transferError = new TableFieldImpl<String>(this,"transfer_error","transferError","转账失败的描述 ");

	/**
	 * 客户付款的账务系统交易ID  | int(11)
	 */
	public final TableField<Integer> transferTrxId = new TableFieldImpl<Integer>(this,"transfer_trx_id","transferTrxId","客户付款的账务系统交易ID ");

	/**
	 * 申请转账到投顾账户的ID  本地生成，申请转账的ID | varchar(23)
	 */
	public final TableField<String> payOrderId = new TableFieldImpl<String>(this,"pay_order_id","payOrderId","申请转账到投顾账户的ID  本地生成，申请转账的ID");

	/**
	 * 付款状态  W:等待转账E:转账超时F:转账失败（有明确的错误原因）S:转账已成功 | char(1)
	 */
	public final TableField<String> payStatus = new TableFieldImpl<String>(this,"pay_status","payStatus","付款状态  W:等待转账E:转账超时F:转账失败（有明确的错误原因）S:转账已成功");

	/**
	 * 付款失败的描述  | varchar(256)
	 */
	public final TableField<String> payError = new TableFieldImpl<String>(this,"pay_error","payError","付款失败的描述 ");

	/**
	 * 付款给投顾的账务系统交易ID   | int(11)
	 */
	public final TableField<Integer> payTrxId = new TableFieldImpl<Integer>(this,"pay_trx_id","payTrxId","付款给投顾的账务系统交易ID  ");

	/**
	 * 转给投顾的实际金额 | decimal(16,2)
	 */
	public final TableField<BigDecimal> payActualAmt = new TableFieldImpl<BigDecimal>(this,"pay_actual_amt","payActualAmt","转给投顾的实际金额");

	/**
	 * 齐牛收取的费用 | decimal(16,2)
	 */
	public final TableField<BigDecimal> payFee = new TableFieldImpl<BigDecimal>(this,"pay_fee","payFee","齐牛收取的费用");

	/**
	 * 申请转账到投顾账户的ID  本地生成，申请退款到用户账户的ID | varchar(23)
	 */
	public final TableField<String> refundOrderId = new TableFieldImpl<String>(this,"refund_order_id","refundOrderId","申请转账到投顾账户的ID  本地生成，申请退款到用户账户的ID");

	/**
	 * 退款状态  W:等待退款E:退款超时F:退款失败（有明确的错误原因）S:退款已成功 | char(1)
	 */
	public final TableField<String> refundStatus = new TableFieldImpl<String>(this,"refund_status","refundStatus","退款状态  W:等待退款E:退款超时F:退款失败（有明确的错误原因）S:退款已成功");

	/**
	 * 退款到客户账户失败的描述   | varchar(256)
	 */
	public final TableField<String> refundError = new TableFieldImpl<String>(this,"refund_error","refundError","退款到客户账户失败的描述  ");

	/**
	 * 退款给客户的账务系统交易ID   | int(11)
	 */
	public final TableField<Integer> refundToUserTrxId = new TableFieldImpl<Integer>(this,"refund_to_user_trx_id","refundToUserTrxId","退款给客户的账务系统交易ID  ");

	/**
	 * 退款给微信的账务系统交易ID   | int(11)
	 */
	public final TableField<Integer> refundToWxTrxId = new TableFieldImpl<Integer>(this,"refund_to_wx_trx_id","refundToWxTrxId","退款给微信的账务系统交易ID  ");

	/**
	 * 创建时间  | datetime
	 */
	public final DateTableField<Date> createTime = new DateTableFieldImpl<Date>(this,"create_time","createTime","创建时间 ");

	/**
	 * 修改时间  | datetime
	 */
	public final DateTableField<Date> updateTime = new DateTableFieldImpl<Date>(this,"update_time","updateTime","修改时间 ");

	/**
	 * 乐观锁版本号   | int(11)
	 */
	public final TableField<Integer> lockVersion = new TableFieldImpl<Integer>(this,"lock_version","lockVersion","乐观锁版本号  ");

	private final TableField<?>[] allFields = new TableField<?>[] {ptfSaleId,sellerUserId,ptfId,buyUserId,priceType,price,ptfNameSnapshot,ptfDescSnapshot,saleDesc,startDate,endDate,targetYield,indexType,beginIndex,endIndex,highIndex,highDate,achieveDateIndex,achieveDate,ptfSaleStatus,needRetry,chargeOrderId,payChannel,chargeTrxId,transferOrderId,transferStatus,transferError,transferTrxId,payOrderId,payStatus,payError,payTrxId,payActualAmt,payFee,refundOrderId,refundStatus,refundError,refundToUserTrxId,refundToWxTrxId,createTime,updateTime,lockVersion};

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
		return "TPtfSale[table=ptf_sale]";
	}
}
