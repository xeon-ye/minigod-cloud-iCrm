package com.minigod.api.adviser.vo.enums;

/**
 * <code>QuestionType</code> 问题类型
 *
 * @author panlz
 * @date 2015-11-3 下午8:18:09
 * @version v1.0
 */
public enum EQuestionType {
	ASSET("股票", 1),
	TAPE("大盘", 2), 
	OTHER("其它", 3);

	private String typeName;
	private Integer typeValue;

	private EQuestionType(String typeName, Integer typeValue) {
		this.typeName = typeName;
		this.typeValue = typeValue;
	}

	public Integer getTypeValue() {
		return this.typeValue;
	}

	public static Integer getTypeValue(EQuestionType index) {
		return index.getTypeValue();
	}

	public static String getName(EQuestionType index) {
		for (EQuestionType c : EQuestionType.values()) {
			if (c.getTypeValue().equals(index.getTypeValue())) {
				return c.typeName;
			}
		}
		return null;
	}

	public static String getName(Integer index) {
		for (EQuestionType c : EQuestionType.values()) {
			if (c.getTypeValue().equals(index)) {
				return c.typeName;
			}
		}
		return null;
	}
}
