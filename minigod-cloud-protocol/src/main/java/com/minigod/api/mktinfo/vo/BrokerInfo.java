package com.minigod.api.mktinfo.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by CaiJianbo on 2016/5/25 17:23.
 * 经纪人信息
 * minigod
 */
public class BrokerInfo implements Serializable{

    private static final long serialVersionUID = -9131264100638653497L;

    List<String> brokerIds ; //经纪编号
    String brokerCode; //经纪代码
    String tcName;  //繁体简称
    String tcFullName; //繁体全称
    String scName;
    String scFullName;
    String enName;
    String enFullName;
    String brokerIdStr;//经纪编号串，用逗号分隔

    public List<String> getBrokerIds() {
        return brokerIds;
    }

    public void setBrokerIds(List<String> brokerIds) {
        this.brokerIds = brokerIds;
    }

    public String getBrokerCode() {
        return brokerCode;
    }

    public void setBrokerCode(String brokerCode) {
        this.brokerCode = brokerCode;
    }

    public String getTcName() {
        return tcName;
    }

    public void setTcName(String tcName) {
        this.tcName = tcName;
    }

    public String getTcFullName() {
        return tcFullName;
    }

    public void setTcFullName(String tcFullName) {
        this.tcFullName = tcFullName;
    }

    public String getScName() {
        return scName;
    }

    public void setScName(String scName) {
        this.scName = scName;
    }

    public String getScFullName() {
        return scFullName;
    }

    public void setScFullName(String scFullName) {
        this.scFullName = scFullName;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getEnFullName() {
        return enFullName;
    }

    public void setEnFullName(String enFullName) {
        this.enFullName = enFullName;
    }

    public String getBrokerIdStr() {
        return brokerIdStr;
    }

    public void setBrokerIdStr(String brokerIdStr) {
        this.brokerIdStr = brokerIdStr;
    }

    @Override
    public String toString() {
        return "BrokerInfo{" +
                "brokerIds=" + brokerIds +
                ", brokerCode='" + brokerCode + '\'' +
                ", tcName='" + tcName + '\'' +
                ", tcFullName='" + tcFullName + '\'' +
                ", scName='" + scName + '\'' +
                ", scFullName='" + scFullName + '\'' +
                ", enName='" + enName + '\'' +
                ", enFullName='" + enFullName + '\'' +
                '}';
    }
}
