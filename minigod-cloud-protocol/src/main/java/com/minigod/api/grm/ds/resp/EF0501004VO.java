package com.minigod.api.grm.ds.resp;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by caijianbo
 * Date:4/9/16
 * Time:10:12 PM
 * 返回交易码表对象
 */
public class EF0501004VO  implements Serializable {
    private static final long serialVersionUID = 1L;
    private Date normalDate;//自然日期
    private String openMkts;//地区
    private String remark;

    public Date getNormalDate() {
        return normalDate;
    }

    public void setNormalDate(Date normalDate) {
        this.normalDate = normalDate;
    }

    public String getOpenMkts() {
        return openMkts;
    }

    public void setOpenMkts(String openMkts) {
        this.openMkts = openMkts;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
