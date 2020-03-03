/**
 * @Title: ImGroupSimpleVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2015-11-17 上午11:28:01
 * @version v1.0
 */

public class ImGroupSimpleVO implements Serializable {
	// extends ImGroup
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	private Date serviceEndDate;
	private String affiliation;
	private String memberId;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getAffiliation() {
		return affiliation;
	}

	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}

	public Date getServiceEndDate() {
		return serviceEndDate;
	}

	public void setServiceEndDate(Date serviceEndDate) {
		this.serviceEndDate = serviceEndDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
