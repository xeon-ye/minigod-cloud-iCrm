package com.minigod.api.user.vo.response.adviser;
import java.io.Serializable;

/**
 * 投顾开户信息返回
 */
public class AdviserOpenFuncVO implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	
	private String switchVal; //开关值
	
	private String detailUrl; //开户展现页面url
	
	private String openUrl; //开户url
	
	private String pkg; //开户app包名

	public String getSwitchVal() {
		return switchVal;
	}

	public void setSwitchVal(String switchVal) {
		this.switchVal = switchVal;
	}

	public String getDetailUrl() {
		return detailUrl;
	}

	public void setDetailUrl(String detailUrl) {
		this.detailUrl = detailUrl;
	}

	public String getOpenUrl() {
		return openUrl;
	}

	public void setOpenUrl(String openUrl) {
		this.openUrl = openUrl;
	}

	public String getPkg() {
		return pkg;
	}

	public void setPkg(String pkg) {
		this.pkg = pkg;
	}
	
	

}