/**
 * @Title: GXCustInfoVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.gateway.vo.resp.guoxin;

import java.io.Serializable;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-3-13 下午5:48:22
 * @version v1.0
 */

public class GXCustInfoVO implements Serializable {
	private static final long serialVersionUID = 1L;
	// 客户姓名
	private String custname;
	// 性别 , 需要转~
	private String sex;
	// 身份证号
	private String idno;
	// 地址
	private String addr;
	// 邮编
	private String postid;
	// 电话
	private String telno;
	// 移动电话
	private String mobileno;
	// 电子邮箱
	private String email;
	// 客户代码
	private String custid;
	// 机构代码
	private String orgid;
	// 出生日期
	private String birthday;
	// 学历, 需要转~
	private String edu;
	// 客户类型
	private String singleflag;
	// 职业 , 需要转~
	private String occtype;

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIdno() {
		return idno;
	}

	public void setIdno(String idno) {
		this.idno = idno;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPostid() {
		return postid;
	}

	public void setPostid(String postid) {
		this.postid = postid;
	}

	public String getTelno() {
		return telno;
	}

	public void setTelno(String telno) {
		this.telno = telno;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCustid() {
		return custid;
	}

	public void setCustid(String custid) {
		this.custid = custid;
	}

	public String getOrgid() {
		return orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEdu() {
		return edu;
	}

	public void setEdu(String edu) {
		this.edu = edu;
	}

	public String getSingleflag() {
		return singleflag;
	}

	public void setSingleflag(String singleflag) {
		this.singleflag = singleflag;
	}

	public String getOcctype() {
		return occtype;
	}

	public void setOcctype(String occtype) {
		this.occtype = occtype;
	}

}
