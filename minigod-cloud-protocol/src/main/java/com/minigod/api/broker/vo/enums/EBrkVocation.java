/**
 * @Title: EBrkVocation.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.broker.vo.enums;

/**
 * @description 职业
 *
 * @author 余俊斌
 * @date 2015年3月18日 下午3:03:54
 * @version v1.0
 */
public enum EBrkVocation {
	/** 其他 */
	OTHER("0", "其他"),
	/** 文教科卫专业人员 */
	CEAH("1", "文教科卫专业人员"),
	/** 党政机关干部 */
	GOVERNMENT("2", "党政机关干部 "),
	/** 企事业单位干部 */
	ENTERPRISE("3", "企事业单位干部"),
	/** 行政企事业单位工人 */
	INSTITUTION("4", "行政企事业单位工人"),
	/** 农民 */
	FARMER("5", "农民"),
	/** 个体 */
	INDIVIDUAL("6", "个体"),
	/** 无业 */
	NONE("7", "无业"),
	/** 军人 */
	SOLDIER("8", "军人"),
	/** 学生 */
	STUDENT("9", "学生"),
	/** 证券从业人员 */
	STOCKS("A", "证券从业人员"),
	/** 退休 */
	RETIRED("B", "退休"),
	/** 收租 */
	RENT("C", "收租"),
	/** 自由职业者 */
	PROFESSIONAL("D", "自由职业者"),
	/** 私营企业主 */
	PRIVATE_ENTERPRISE("E", "私营企业主");

	private String typeName;
	private String typeValue;

	private EBrkVocation(String typeValue, String typeName) {
		this.typeName = typeName;
		this.typeValue = typeValue;
	}

	public String getTypeName() {
		return this.typeName;
	}
	
	public String getTypeValue() {
		return typeValue;
	}

	public static EBrkVocation findByTypeName(String name) {
		for (EBrkVocation eCurrencyType : EBrkVocation.values()) {
			if (eCurrencyType.typeName.equals(name)) {
				return eCurrencyType;
			}
		}
		return null;
	}

}
