package com.minigod.api.user.vo.response.adviser;

import java.io.Serializable;

/**
 * @Title: RespSaveOpenInfoVO.java
 * @Description: 
 * @Copyright:  2015 minigod
 * @Company: minigod
 *
 * @author panlz
 * @date 2015-9-29 下午5:20:15
 * @version v1.0
 */

public class RespSaveOpenInfoVO implements Serializable {

	private static final long serialVersionUID = -1651584739271904264L;

	private String openUrl ; //开户url
	
	private String detailUrl ; //开户展现url
	
	private String 	pkg ; //开户app包名

	public String getOpenUrl() {
		return openUrl;
	}

	public void setOpenUrl(String openUrl) {
		this.openUrl = openUrl;
	}

	public String getDetailUrl() {
		return detailUrl;
	}

	public void setDetailUrl(String detailUrl) {
		this.detailUrl = detailUrl;
	}

	public String getPkg() {
		return pkg;
	}

	public void setPkg(String pkg) {
		this.pkg = pkg;
	}
	
}
