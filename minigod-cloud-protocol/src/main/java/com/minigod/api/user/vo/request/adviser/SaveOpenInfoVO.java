package com.minigod.api.user.vo.request.adviser;

import java.io.Serializable;

import com.minigod.api.user.vo.SNUserBase;

/**
 * @Title: SaveOpenInfoVO.java
 * @Description: 
 * @Copyright:  2015 minigod
 * @Company: minigod
 *
 * @author panlz
 * @date 2015-9-28 下午5:15:47
 * @version v1.0
 */
public class SaveOpenInfoVO extends SNUserBase implements Serializable {

	private static final long serialVersionUID = 2406842815060417640L;

	private String switchVal ; //开关设置值
	
	private String act ; //开户活动
	
	private String bkge ; //开户佣金
	
	private String instr ; //开户说明
	
	private String openUrl ; //开户url

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
	
	
}
