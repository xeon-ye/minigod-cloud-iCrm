package com.minigod.api.grm;

import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by caijianbo
 * Date:4/9/16
 * Time:10:30 PM
 */
public abstract class GrmRequestVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 功能号
     */
    protected String functionId;

    /**
     * 语言种类
     */
    protected String lang;

    /**
     * sid 渠道编号
     * @return
     */
    protected String sid;

    /**
     *sessionId
     * @return
     */
    protected String sessionId;

    protected String ipAddress;

    protected String pkgId;

    protected long recvTime;

    public String getFunctionId() {
        return functionId;
    }

    public void setFunctionId(String functionId) {
        this.functionId = functionId;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }
    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getPkgId() {
        return pkgId;
    }

    public void setPkgId(String pkgId) {
        this.pkgId = pkgId;
    }

    public GrmRequestVO copyCommonParams(GrmRequestVO grmRequestVO){
        this.setIpAddress(grmRequestVO.getIpAddress());
        this.setSessionId(grmRequestVO.getSessionId());
        this.setSid(grmRequestVO.getSid());
        String sessionId = grmRequestVO.getSessionId();
        if(StringUtils.isNotEmpty(sessionId)){
            this.setSessionId(sessionId);
        }
        this.setLang(grmRequestVO.lang);
        return this;
    }

    public long getRecvTime() {
        return recvTime;
    }

    public void setRecvTime(long recvTime) {
        this.recvTime = recvTime;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("GrmRequestVO{");
        sb.append("functionId='").append(functionId).append('\'');
        sb.append(", lang='").append(lang).append('\'');
        sb.append(", sid='").append(sid).append('\'');
        sb.append(", sessionId='").append(sessionId).append('\'');
        sb.append(", ipAddress='").append(ipAddress).append('\'');
        sb.append(", packageId='").append(pkgId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
