package com.sunline.modules.ccass.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * CCASS参与者信息
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-05-17 16:05:58
 */
public class CcassParticipantsEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer id;
    //CCASS编号
    private String ccassId;
    //参与者英文名
    private String ccassNameEn;
    //参与者中文名
    private String ccassNameTc;
    //外部编号
    private Integer partId;

    private String createTime;
    private String updateTime;

    /**
     * 设置：
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置：CCASS编号
     */
    public void setCcassId(String ccassId) {
        this.ccassId = ccassId;
    }

    /**
     * 获取：CCASS编号
     */
    public String getCcassId() {
        return ccassId;
    }

    /**
     * 设置：参与者英文名
     */
    public void setCcassNameEn(String ccassNameEn) {
        this.ccassNameEn = ccassNameEn;
    }

    /**
     * 获取：参与者英文名
     */
    public String getCcassNameEn() {
        return ccassNameEn;
    }

    /**
     * 设置：参与者中文名
     */
    public void setCcassNameTc(String ccassNameTc) {
        this.ccassNameTc = ccassNameTc;
    }

    /**
     * 获取：参与者中文名
     */
    public String getCcassNameTc() {
        return ccassNameTc;
    }

    /**
     * 设置：外部编号
     */
    public void setPartId(Integer partId) {
        this.partId = partId;
    }

    /**
     * 获取：外部编号
     */
    public Integer getPartId() {
        return partId;
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
