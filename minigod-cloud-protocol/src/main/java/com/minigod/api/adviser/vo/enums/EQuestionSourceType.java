package com.minigod.api.adviser.vo.enums;

/**
 * <code>QuestionSourceType</code> 问题来源类型
 *
 * @author panlz
 * @date 2015-11-3 下午8:18:09
 * @version v1.0
 */
public enum EQuestionSourceType {
	SQUARE("广场问答", 1),
	EXCLUSIVE("专属投顾问答", 2); 

	private String typeName;
	private Integer typeValue;

	private EQuestionSourceType(String typeName, Integer typeValue) {
		this.typeName = typeName;
		this.typeValue = typeValue;
	}

	public Integer getTypeValue() {
		return this.typeValue;
	}

	public static Integer getTypeValue(EQuestionSourceType index) {
		return index.getTypeValue();
	}

	public static String getName(EQuestionSourceType index) {
		for (EQuestionSourceType c : EQuestionSourceType.values()) {
			if (c.getTypeValue().equals(index.getTypeValue())) {
				return c.typeName;
			}
		}
		return null;
	}

	public static String getName(Integer index) {
		for (EQuestionSourceType c : EQuestionSourceType.values()) {
			if (c.getTypeValue().equals(index)) {
				return c.typeName;
			}
		}
		return null;
	}
}
