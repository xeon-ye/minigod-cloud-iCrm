package com.sunline.modules.ccass.model;


import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * @description: CCASS参与者信息
 * @author: Larry Lai
 * @date: 2019/1/9 9:05
 * @version: v1.0
 */

public class CcassParticipantsInfoModel extends BaseRowModel {

    @ExcelProperty(value = "序号" ,index = 0)
    private String id;

    @ExcelProperty(value = "CCASS编号" ,index = 1)
    private String ccassId;

    @ExcelProperty(value = "参与者英文名" ,index = 2)
    private String ccassNameEn;

    @ExcelProperty(value = "参与者中文名" ,index = 3)
    private String ccassNameTc;

    @ExcelProperty(value = "创建时间" ,index = 4)
    private String createTime;

    @ExcelProperty(value = "更新时间" ,index = 5)
    private String updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCcassId() {
        return ccassId;
    }

    public void setCcassId(String ccassId) {
        this.ccassId = ccassId;
    }

    public String getCcassNameEn() {
        return ccassNameEn;
    }

    public void setCcassNameEn(String ccassNameEn) {
        this.ccassNameEn = ccassNameEn;
    }

    public String getCcassNameTc() {
        return ccassNameTc;
    }

    public void setCcassNameTc(String ccassNameTc) {
        this.ccassNameTc = ccassNameTc;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
