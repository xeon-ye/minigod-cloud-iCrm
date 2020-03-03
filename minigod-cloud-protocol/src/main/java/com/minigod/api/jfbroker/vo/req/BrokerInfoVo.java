package com.minigod.api.jfbroker.vo.req;

import com.minigod.common.anno.TransferBean;

import java.io.Serializable;

/**
 * @Author: PENGFENG
 * @Description:
 * @Date: Created in 14:16 2017/9/4
 * @Modified By:
 */
public class BrokerInfoVo implements Serializable{

    private static final long serialVersionUID = -1163833696907526399L;
    private Integer userId; // 用户ID

    private Integer brokerType; // 券商类型

    private Integer btnType; // 按钮类型 1：A股交易tab 2：极速开户 3：绑定犇犇

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBrokerType() {
        return brokerType;
    }

    public void setBrokerType(Integer brokerType) {
        this.brokerType = brokerType;
    }

    public Integer getBtnType() {
        return btnType;
    }

    public void setBtnType(Integer btnType) {
        this.btnType = btnType;
    }
}
