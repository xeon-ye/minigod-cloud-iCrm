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

public class TAdviserQuestion extends AbstractTable {

	static {
		init();
	}

	private TAdviserQuestion(){
		super.tableName = "adviser_question";
	}

	private TAdviserQuestion(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TAdviserQuestion getInstance() {
		return new TAdviserQuestion();
	}

	public static final TAdviserQuestion getInstance(String aliasName) {
		return new TAdviserQuestion(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("questionId", "question_id");
		allFieldMap.put("userId", "user_id");
		allFieldMap.put("assignUserId", "assign_user_id");
		allFieldMap.put("userIdType", "user_id_type");
		allFieldMap.put("questionSource", "question_source");
		allFieldMap.put("questionType", "question_type");
		allFieldMap.put("assetId", "asset_id");
		allFieldMap.put("costPrice", "cost_price");
		allFieldMap.put("position", "position");
		allFieldMap.put("content", "content");
		allFieldMap.put("rushStatus", "rush_status");
		allFieldMap.put("timeoutTime", "timeout_time");
		allFieldMap.put("matchNum", "match_num");
		allFieldMap.put("unsatisfyNum", "unsatisfy_num");
		allFieldMap.put("bestAnswerId", "best_answer_id");
		allFieldMap.put("latestAnswerId", "latest_answer_id");
		allFieldMap.put("fristDistributeTime", "frist_distribute_time");
		allFieldMap.put("isLock", "is_lock");
		allFieldMap.put("lockVersion", "lock_version");
		allFieldMap.put("isStatus", "is_status");
		allFieldMap.put("createTime", "create_time");
		allFieldMap.put("updateTime", "update_time");
	}

	public String getFieldName(String javaFieldName) {
		return allFieldMap.get(javaFieldName);
	}

	public final TableField<Integer> all = new AllField<Integer>(this,  "*",null);

	public TableField<?> allField() {
		return all;
	}

	/**
	 * 问题ID | int(20)
	 */
	public final TableField<Integer>  pk = new TableFieldImpl<Integer>(this,"question_id","questionId","问题ID");

	/**
	 * 乐观锁字段
	 */
	public final TableField<Integer>  lock = new TableFieldImpl<Integer>(this,"lock_version","lockVersion","问题ID");

	public final TableField<Integer> questionId = new TableFieldImpl<Integer>(this,"question_id","questionId","问题ID");

	/**
	 * 提问用户id | int(20)
	 */
	public final TableField<Integer> userId = new TableFieldImpl<Integer>(this,"user_id","userId","提问用户id");

	/**
	 * 指派回答用户id，指定专人回答，记录指定人用户id，属于广场问答分发的非指派此字段为空 | int(20)
	 */
	public final TableField<Integer> assignUserId = new TableFieldImpl<Integer>(this,"assign_user_id","assignUserId","指派回答用户id，指定专人回答，记录指定人用户id，属于广场问答分发的非指派此字段为空");

	/**
	 * 用户类型 1一起牛用户 2微信用户 | tinyint(4)
	 */
	public final TableField<Integer> userIdType = new TableFieldImpl<Integer>(this,"user_id_type","userIdType","用户类型 1一起牛用户 2微信用户");

	/**
	 * 问题来源  1广场问答(后续微信问答也属于广场问答)，2专属投顾问答 | tinyint(4)
	 */
	public final TableField<Integer> questionSource = new TableFieldImpl<Integer>(this,"question_source","questionSource","问题来源  1广场问答(后续微信问答也属于广场问答)，2专属投顾问答");

	/**
	 * 问题类型 1股票，2大盘，3其它 | tinyint(4)
	 */
	public final TableField<Integer> questionType = new TableFieldImpl<Integer>(this,"question_type","questionType","问题类型 1股票，2大盘，3其它");

	/**
	 * 资产id | varchar(20)
	 */
	public final TableField<String> assetId = new TableFieldImpl<String>(this,"asset_id","assetId","资产id");

	/**
	 * 成本价 | decimal(10,4)
	 */
	public final TableField<BigDecimal> costPrice = new TableFieldImpl<BigDecimal>(this,"cost_price","costPrice","成本价");

	/**
	 * 仓位 | varchar(20)
	 */
	public final TableField<String> position = new TableFieldImpl<String>(this,"position","position","仓位");

	/**
	 * 提问内容 | varchar(500)
	 */
	public final TableField<String> content = new TableFieldImpl<String>(this,"content","content","提问内容");

	/**
	 * 抢答状态，默认0待抢答 ，  1已抢答，因未抢答或抢答且超时再次推送给下一批投顾将此状态重置成0 | tinyint(4)
	 */
	public final TableField<Integer> rushStatus = new TableFieldImpl<Integer>(this,"rush_status","rushStatus","抢答状态，默认0待抢答 ，  1已抢答，因未抢答或抢答且超时再次推送给下一批投顾将此状态重置成0");

	/**
	 * 超时时间 未抢答或已抢答状态下超时则触发推送给下一批投顾，另不满意时用户再次问其他投顾或投顾放弃回答也会触发推送给下一批投顾,触发时再次设置下一个超时时间 永不过期时间设置9999-12-31 12:00:00 | datetime
	 */
	public final DateTableField<Date> timeoutTime = new DateTableFieldImpl<Date>(this,"timeout_time","timeoutTime","超时时间 未抢答或已抢答状态下超时则触发推送给下一批投顾，另不满意时用户再次问其他投顾或投顾放弃回答也会触发推送给下一批投顾,触发时再次设置下一个超时时间 永不过期时间设置9999-12-31 12:00:00");

	/**
	 * 匹配推送次数 默认1 每匹配推送给下一批投顾 +1 | tinyint(4)
	 */
	public final TableField<Integer> matchNum = new TableFieldImpl<Integer>(this,"match_num","matchNum","匹配推送次数 默认1 每匹配推送给下一批投顾 +1");

	/**
	 * 不满意推送次数 点不满意发送给其他投顾 +1 | tinyint(4)
	 */
	public final TableField<Integer> unsatisfyNum = new TableFieldImpl<Integer>(this,"unsatisfy_num","unsatisfyNum","不满意推送次数 点不满意发送给其他投顾 +1");

	/**
	 *  | int(20)
	 */
	public final TableField<Integer> bestAnswerId = new TableFieldImpl<Integer>(this,"best_answer_id","bestAnswerId","");

	/**
	 * 最新的答案id | int(20)
	 */
	public final TableField<Integer> latestAnswerId = new TableFieldImpl<Integer>(this,"latest_answer_id","latestAnswerId","最新的答案id");

	/**
	 * 第一次分发时间 | datetime
	 */
	public final DateTableField<Date> fristDistributeTime = new DateTableFieldImpl<Date>(this,"frist_distribute_time","fristDistributeTime","第一次分发时间");

	/**
	 * 投顾举报锁住 0正常  1锁住  | tinyint(1)
	 */
	public final TableField<Boolean> isLock = new TableFieldImpl<Boolean>(this,"is_lock","isLock","投顾举报锁住 0正常  1锁住 ");

	/**
	 * 乐观锁 | int(11)
	 */
	public final TableField<Integer> lockVersion = new TableFieldImpl<Integer>(this,"lock_version","lockVersion","乐观锁");

	/**
	 * 记录状态 1-有效，0-无效 | tinyint(1)
	 */
	public final TableField<Boolean> isStatus = new TableFieldImpl<Boolean>(this,"is_status","isStatus","记录状态 1-有效，0-无效");

	/**
	 * 创建时间 | datetime
	 */
	public final DateTableField<Date> createTime = new DateTableFieldImpl<Date>(this,"create_time","createTime","创建时间");

	/**
	 * 修改时间 | datetime
	 */
	public final DateTableField<Date> updateTime = new DateTableFieldImpl<Date>(this,"update_time","updateTime","修改时间");

	private final TableField<?>[] allFields = new TableField<?>[] {questionId,userId,assignUserId,userIdType,questionSource,questionType,assetId,costPrice,position,content,rushStatus,timeoutTime,matchNum,unsatisfyNum,bestAnswerId,latestAnswerId,fristDistributeTime,isLock,lockVersion,isStatus,createTime,updateTime};

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
		return "TAdviserQuestion[table=adviser_question]";
	}
}
