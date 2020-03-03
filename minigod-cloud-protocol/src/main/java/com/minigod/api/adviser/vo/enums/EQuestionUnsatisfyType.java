package com.minigod.api.adviser.vo.enums;

/**
 * <code>EQuestionUnsatisfyType</code> 问答 评价不满意类型原因
 *
 * @author panlz
 * @date 2015-11-23 下午8:18:09
 * @version v1.0
 */
public enum EQuestionUnsatisfyType {
	notimely("回答不够及时", 1),
	simple("答案过于简单", 2),
	noclear("内容不够清晰", 3),
	independent("发表无关内容", 4),
	other("其他类型", 99) ;

	private String typeName;
	private Integer typeValue;

	private EQuestionUnsatisfyType(String typeName, Integer typeValue) {
		this.typeName = typeName;
		this.typeValue = typeValue;
	}

	public Integer getTypeValue() {
		return this.typeValue;
	}

	public static Integer getTypeValue(EQuestionUnsatisfyType index) {
		return index.getTypeValue();
	}

	public static String getName(EQuestionUnsatisfyType index) {
		for (EQuestionUnsatisfyType c : EQuestionUnsatisfyType.values()) {
			if (c.getTypeValue().equals(index.getTypeValue())) {
				return c.typeName;
			}
		}
		return null;
	}

	public static String getName(Integer index) {
		for (EQuestionUnsatisfyType c : EQuestionUnsatisfyType.values()) {
			if (c.getTypeValue().equals(index)) {
				return c.typeName;
			}
		}
		return null;
	}
}
