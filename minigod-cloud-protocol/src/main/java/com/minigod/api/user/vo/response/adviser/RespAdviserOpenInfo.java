package com.minigod.api.user.vo.response.adviser;

import java.io.Serializable;

/**
 * @Title: RespAdviserOpenInfo.java
 * @Description: 
 * @Copyright:  2015 minigod
 * @Company: minigod
 *
 * @author panlz
 * @date 2015-9-28 上午8:46:50
 * @version v1.0
 */

public class RespAdviserOpenInfo implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	
	private String switchVal ; //开关值
	
	private String act ; //开户活动
	
	private String bkge ; //开户佣金
	
	private String[] pvlg ; //开户专享特权
	
	private String instr ; //开户说明
	
	private String openUrl ; //开户url
	
	private String detailUrl ; //开户详情url
	
	private String pkg ; //app包名

	public String getSwitchVal() {
		return switchVal;
	}

	public void setSwitchVal(String switchVal) {
		this.switchVal = switchVal;
	}

	public String getAct() {
		return act;
	}

	public void setAct(String act) {
		this.act = act;
	}

	public String getBkge() {
		return bkge;
	}

	public void setBkge(String bkge) {
		this.bkge = bkge;
	}

	public String[] getPvlg() {
		return pvlg;
	}

	public void setPvlg(String[] pvlg) {
		this.pvlg = pvlg;
	}

	public String getInstr() {
		return instr;
	}

	public void setInstr(String instr) {
		this.instr = instr;
	}

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
