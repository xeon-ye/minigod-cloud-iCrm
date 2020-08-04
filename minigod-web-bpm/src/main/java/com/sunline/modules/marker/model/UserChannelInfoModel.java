package com.sunline.modules.marker.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

import java.io.Serializable;
import java.util.List;


/**
 * 渠道信息表
 *
 * @author lcs
 * @email
 * @date 2018-04-25 09:31:43
 */
public class UserChannelInfoModel  extends BaseRowModel {


    @ExcelProperty(value = "序号",index = 0)
    private Integer id;

    @ExcelProperty(value = "渠道号",index = 1)
    private String channelId;

    @ExcelProperty(value = "渠道名称",index = 2)
    private String channelName;

    @ExcelProperty(value = "上级渠道名",index = 2)
    private String parentName;

    @ExcelProperty(value = "创建人",index = 2)
    private String createBy;

    @ExcelProperty(value = "修改人",index = 2)
    private String updateBy;

    @ExcelProperty(value = "创建日期",index = 2)
    private String createTime;

    @ExcelProperty(value = "修改日期",index = 2)
    private String updateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
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
