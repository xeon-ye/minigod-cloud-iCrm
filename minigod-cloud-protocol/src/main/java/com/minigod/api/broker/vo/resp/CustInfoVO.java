/**
 * @Title: CustInfo.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.broker.vo.resp;

import java.io.Serializable;
import java.util.Date;

import com.minigod.api.broker.vo.enums.EBrkClientType;
import com.minigod.api.broker.vo.enums.EBrkEducationDegree;
import com.minigod.api.broker.vo.enums.EBrkGender;
import com.minigod.api.broker.vo.enums.EBrkIdType;
import com.minigod.api.broker.vo.enums.EBrkVocation;

/**
 * @description 客户信息
 * 
 * @author Jimmy
 * @date 2015-3-10 下午9:14:53
 * @version v1.0
 */

public class CustInfoVO implements Serializable {
	private static final long serialVersionUID = 1L;
	// 客户ID
	private String custId;
	// 客户名称
	private String custName;
	// 证件类型
	private EBrkIdType idType;
	// 证件号码
	private String idNo;
	// 电话
	private String phone;
	// 客户手机号码
	private String mobile;
	// 客户性别
	private EBrkGender sex;
	// 地址
	private String address;
	// 邮编
	private String postId;
	// 邮箱
	private String email;
	// 生日
	private Date birthday;
	// 学历
	private EBrkEducationDegree education;
	// 客户类型
	private EBrkClientType clientType;
	// 职业
	private EBrkVocation occType;
	// 股东账号
	private String stkAcc;
	// 资金账号
	private String depositAcc;

	public String getStkAcc() {
		return stkAcc;
	}

	public void setStkAcc(String stkAcc) {
		this.stkAcc = stkAcc;
	}

	public String getDepositAcc() {
		return depositAcc;
	}

	public void setDepositAcc(String depositAcc) {
		this.depositAcc = depositAcc;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public EBrkIdType getIdType() {
		return idType;
	}

	public void setIdType(EBrkIdType idType) {
		this.idType = idType;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public EBrkGender getSex() {
		return sex;
	}

	public void setSex(EBrkGender sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public EBrkEducationDegree getEducation() {
		return education;
	}

	public void setEducation(EBrkEducationDegree education) {
		this.education = education;
	}

	public EBrkClientType getClientType() {
		return clientType;
	}

	public void setClientType(EBrkClientType clientType) {
		this.clientType = clientType;
	}

	public EBrkVocation getOccType() {
		return occType;
	}

	public void setOccType(EBrkVocation occType) {
		this.occType = occType;
	}

}
