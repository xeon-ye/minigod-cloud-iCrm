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

public class TGameFightEvent extends AbstractTable {

	static {
		init();
	}

	private TGameFightEvent(){
		super.tableName = "game_fight_event";
	}

	private TGameFightEvent(String aliasName){
		this();
		setAliasName(aliasName);
	}

	public static final TGameFightEvent getInstance() {
		return new TGameFightEvent();
	}

	public static final TGameFightEvent getInstance(String aliasName) {
		return new TGameFightEvent(aliasName);
	}

	private static Map<String, String> allFieldMap;
	private static final void init() {
		allFieldMap = new HashMap<String, String>();
		allFieldMap.put("fightEventId", "fight_event_id");
		allFieldMap.put("phaseNum", "phase_num");
		allFieldMap.put("eventName", "event_name");
		allFieldMap.put("startTime", "start_time");
		allFieldMap.put("endTime", "end_time");
		allFieldMap.put("lowerLimit", "lower_limit");
		allFieldMap.put("upperLimit", "upper_limit");
		allFieldMap.put("prize", "prize");
		allFieldMap.put("winner", "winner");
		allFieldMap.put("totalNum", "total_num");
		allFieldMap.put("remainNum", "remain_num");
		allFieldMap.put("runDay", "run_day");
		allFieldMap.put("eventStatus", "event_status");
		allFieldMap.put("lockVersion", "lock_version");
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
	 * 一战到底赛事表 赛事id | int(11)
	 */
	public final TableField<Integer>  pk = new TableFieldImpl<Integer>(this,"fight_event_id","fightEventId","一战到底赛事表 赛事id");

	/**
	 * 乐观锁字段
	 */
	public final TableField<Integer>  lock = new TableFieldImpl<Integer>(this,"lock_version","lockVersion","一战到底赛事表 赛事id");

	public final TableField<Integer> fightEventId = new TableFieldImpl<Integer>(this,"fight_event_id","fightEventId","一战到底赛事表 赛事id");

	/**
	 * 第N期 | int(11)
	 */
	public final TableField<Integer> phaseNum = new TableFieldImpl<Integer>(this,"phase_num","phaseNum","第N期");

	/**
	 * 赛事名称 | varchar(50)
	 */
	public final TableField<String> eventName = new TableFieldImpl<String>(this,"event_name","eventName","赛事名称");

	/**
	 * 比赛开始时间 | datetime
	 */
	public final DateTableField<Date> startTime = new DateTableFieldImpl<Date>(this,"start_time","startTime","比赛开始时间");

	/**
	 * 比赛结束时间 | datetime
	 */
	public final DateTableField<Date> endTime = new DateTableFieldImpl<Date>(this,"end_time","endTime","比赛结束时间");

	/**
	 * 参数人数下限 | int(11)
	 */
	public final TableField<Integer> lowerLimit = new TableFieldImpl<Integer>(this,"lower_limit","lowerLimit","参数人数下限");

	/**
	 * 参赛人数上限 | int(11)
	 */
	public final TableField<Integer> upperLimit = new TableFieldImpl<Integer>(this,"upper_limit","upperLimit","参赛人数上限");

	/**
	 * 奖金 | decimal(10,2)
	 */
	public final TableField<BigDecimal> prize = new TableFieldImpl<BigDecimal>(this,"prize","prize","奖金");

	/**
	 * 冠军用户id | int(11)
	 */
	public final TableField<Integer> winner = new TableFieldImpl<Integer>(this,"winner","winner","冠军用户id");

	/**
	 * 已参赛总人数 | int(11)
	 */
	public final TableField<Integer> totalNum = new TableFieldImpl<Integer>(this,"total_num","totalNum","已参赛总人数");

	/**
	 * 剩余人数 | int(11)
	 */
	public final TableField<Integer> remainNum = new TableFieldImpl<Integer>(this,"remain_num","remainNum","剩余人数");

	/**
	 * 持续交易日 | int(11)
	 */
	public final TableField<Integer> runDay = new TableFieldImpl<Integer>(this,"run_day","runDay","持续交易日");

	/**
	 * 赛事状态 默认0-未开始 1-进行中 2-作废 3-结束 | tinyint(4)
	 */
	public final TableField<Integer> eventStatus = new TableFieldImpl<Integer>(this,"event_status","eventStatus","赛事状态 默认0-未开始 1-进行中 2-作废 3-结束");

	/**
	 * 乐观锁 | int(11)
	 */
	public final TableField<Integer> lockVersion = new TableFieldImpl<Integer>(this,"lock_version","lockVersion","乐观锁");

	/**
	 * 创建时间 | datetime
	 */
	public final DateTableField<Date> createTime = new DateTableFieldImpl<Date>(this,"create_time","createTime","创建时间");

	/**
	 * 修改时间 | datetime
	 */
	public final DateTableField<Date> updateTime = new DateTableFieldImpl<Date>(this,"update_time","updateTime","修改时间");

	private final TableField<?>[] allFields = new TableField<?>[] {fightEventId,phaseNum,eventName,startTime,endTime,lowerLimit,upperLimit,prize,winner,totalNum,remainNum,runDay,eventStatus,lockVersion,createTime,updateTime};

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
		return "TGameFightEvent[table=game_fight_event]";
	}
}
