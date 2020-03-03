package com.minigod.api.user.vo.open.req;

import com.minigod.api.vo.BaseVO;

/**
 * @author 寇艳东
 * @version v1.0
 * @project: minigod
 * @description: 这里描述类的用处
 * @copyright: © 2017
 * @company:
 * @date 2017/3/22 10:55
 */
public class ReanlNameVO extends BaseVO {
    private String name;
    private String idCard;
    private String phoneInfo;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneInfo() {
        return phoneInfo;
    }

    public void setPhoneInfo(String phoneInfo) {
        this.phoneInfo = phoneInfo;
    }
}
