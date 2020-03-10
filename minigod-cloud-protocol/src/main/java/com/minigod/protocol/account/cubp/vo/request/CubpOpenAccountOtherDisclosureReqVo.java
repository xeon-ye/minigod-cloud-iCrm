package com.minigod.protocol.account.cubp.vo.request;

import java.io.Serializable;


/**
 * 其他信息披露
 */
public class CubpOpenAccountOtherDisclosureReqVo implements Serializable {
	private static final long serialVersionUID = 1L;

	//编号
	private Integer disclosureCode;
	//标示符[0-否 1-是]
	private Integer disclosureIsTrue;
    //披露字段1,多组信息逗号隔开
    private String disclosure1;
    //披露字段2,多组信息逗号隔开
    private String disclosure2;
    //披露字段3,多组信息逗号隔开
    private String disclosure3;
    //披露字段4,多组信息逗号隔开
    private String disclosure4;

	/**
	 * 设置：编号
	 */
	public void setDisclosureCode(Integer disclosureCode) {
		this.disclosureCode = disclosureCode;
	}
	/**
	 * 获取：编号
	 */
	public Integer getDisclosureCode() {
		return disclosureCode;
	}
	/**
	 * 设置：标示符[0-否 1-是]
	 */
	public void setDisclosureIsTrue(Integer disclosureIsTrue) {
		this.disclosureIsTrue = disclosureIsTrue;
	}
	/**
	 * 获取：标示符[0-否 1-是]
	 */
	public Integer getDisclosureIsTrue() {
		return disclosureIsTrue;
	}

    public String getDisclosure1() {
        return disclosure1;
    }

    public void setDisclosure1(String disclosure1) {
        this.disclosure1 = disclosure1;
    }

    public String getDisclosure2() {
        return disclosure2;
    }

    public void setDisclosure2(String disclosure2) {
        this.disclosure2 = disclosure2;
    }

    public String getDisclosure3() {
        return disclosure3;
    }

    public void setDisclosure3(String disclosure3) {
        this.disclosure3 = disclosure3;
    }

    public String getDisclosure4() {
        return disclosure4;
    }

    public void setDisclosure4(String disclosure4) {
        this.disclosure4 = disclosure4;
    }
}
