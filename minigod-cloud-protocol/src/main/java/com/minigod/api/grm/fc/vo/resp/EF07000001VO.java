package com.minigod.api.grm.fc.vo.resp;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by caijianbo
 * Date:4/9/16
 * Time:10:12 PM
 * 登录返回行情信息
 */
public class EF07000001VO implements Serializable {
    protected static final long serialVersionUID = 1L;

    /**
     * 上次登录日期，如没有返回Null
     */
    protected Date lastLoginTime;
    /**
     * 上次登录IP，如没有返回Null
     */
    protected String lastLoginIp;
    /**
     * 1代表港股行情登录成功，需要踢出旧的在线记录，0表示港股行情登录失败；
     * 港股行情登录失败不会报错，详细报错在GrmResponseVo的nofifymsg中
     */
    protected boolean hkLive = false;
    /**
     * 同上，美股默认开通；总是1
     */
    protected boolean usLive = false;
    /**
     * 港股川流行情有效期截止日期 YYYYmmdd
     */
    protected String hkEdate;
    /**
     * 同上，但美股无限期，所以返回Null
     */
    protected String usEdate;
    /**
     * 港股点击报价剩余数量
     */
    protected int hkRemainDjNum = 0;
    /**
     * 美股点击报价剩余数量
     */
    protected int usRemainDjNum = 0;

    protected boolean bmpLive = false;

    protected String sessionId;

    protected boolean l2OnOff = false;
    
    protected String l2Msg = "";
    
	public String getL2Msg() {
		return l2Msg;
	}
	public void setL2Msg(String l2Msg) {
		this.l2Msg = l2Msg;
	}
	public boolean isL2OnOff() {
        return l2OnOff;
    }
    public boolean getL2OnOff() {
        return l2OnOff;
    }
    public void setL2OnOff(boolean l2OnOff) {
        this.l2OnOff = l2OnOff;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public boolean getBmpLive() {
        return bmpLive;
    }

    public void setBmpLive(boolean bmpLive) {
        this.bmpLive = bmpLive;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public boolean getHkLive() {
        return hkLive;
    }

    public void setHkLive(boolean hkLive) {
        this.hkLive = hkLive;
    }

    public boolean getUsLive() {
        return usLive;
    }

    public void setUsLive(boolean usLive) {
        this.usLive = usLive;
    }

    public String getHkEdate() {
        return hkEdate;
    }

    public void setHkEdate(String hkEdate) {
        this.hkEdate = hkEdate;
    }

    public String getUsEdate() {
        return usEdate;
    }

    public void setUsEdate(String usEdate) {
        this.usEdate = usEdate;
    }

    public int getHkRemainDjNum() {
        return hkRemainDjNum;
    }

    public void setHkRemainDjNum(int hkRemainDjNum) {
        this.hkRemainDjNum = hkRemainDjNum;
    }

    public int getUsRemainDjNum() {
        return usRemainDjNum;
    }

    public void setUsRemainDjNum(int usRemainDjNum) {
        this.usRemainDjNum = usRemainDjNum;
    }

    @Override
    public String toString() {
        return "EF07000001VO{" +
                "lastLoginTime=" + lastLoginTime +
                ", lastLoginIp='" + lastLoginIp + '\'' +
                ", hkLive=" + hkLive +
                ", usLive=" + usLive +
                ", hkEdate='" + hkEdate + '\'' +
                ", usEdate='" + usEdate + '\'' +
                ", hkRemainDjNum=" + hkRemainDjNum +
                ", usRemainDjNum=" + usRemainDjNum +
                '}';
    }
}
