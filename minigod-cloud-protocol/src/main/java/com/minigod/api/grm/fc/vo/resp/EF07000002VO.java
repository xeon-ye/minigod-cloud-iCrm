package com.minigod.api.grm.fc.vo.resp;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by caijianbo
 * Date:4/9/16
 * Time:10:12 PM
 * 登录返回行情信息
 */
public class EF07000002VO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 上次登录日期，如没有返回Null
     */
    private boolean isSuccess;

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }
}
