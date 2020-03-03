package com.minigod.api.adviser.vo.enums;

/**
 * <code>EQuestionFlowStatus</code> 问题流转状态
 *
 * @author panlz
 * @date 2015-11-3 下午8:18:09
 * @version v1.0
 */
public enum EQuestionFlowStatus {
	stay("待抢答", 0),
	closed("已被抢答", 1),
	unanswered("已抢未答", 2),
	giveUp("放弃", 3),
	timeout("超时", 4),
	answered("已回答", 9) ;

	private String typeName;
	private Integer typeValue;

	private EQuestionFlowStatus(String typeName, Integer typeValue) {
		this.typeName = typeName;
		this.typeValue = typeValue;
	}

	public Integer getTypeValue() {
		return this.typeValue;
	}

	public static Integer getTypeValue(EQuestionFlowStatus index) {
		return index.getTypeValue();
	}

	public static String getName(EQuestionFlowStatus index) {
		for (EQuestionFlowStatus c : EQuestionFlowStatus.values()) {
			if (c.getTypeValue().equals(index.getTypeValue())) {
				return c.typeName;
			}
		}
		return null;
	}

	public static String getName(Integer index) {
		for (EQuestionFlowStatus c : EQuestionFlowStatus.values()) {
			if (c.getTypeValue().equals(index)) {
				return c.typeName;
			}
		}
		return null;
	}
}
