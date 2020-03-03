package com.minigod.api.user.vo.api;

import java.io.Serializable;

/**
 * @author 寇艳东
 * @version v1.0
 * @project: minigod
 * @description: 这里描述类的用处
 * @copyright: © 2017
 * @company:
 * @date 2017/4/11 23:25
 */
public class ErrorCountVO implements Serializable {

    private static final long serialVersionUID = -3953782439480578779L;
    private String phone;
    private Integer count;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
