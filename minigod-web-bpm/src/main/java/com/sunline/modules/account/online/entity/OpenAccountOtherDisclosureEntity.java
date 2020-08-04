package com.sunline.modules.account.online.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 其他信息披露表
 *
 * @author lcs
 * @email
 * @date 2018-09-28 14:10:22
 */
public class OpenAccountOtherDisclosureEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //主键ID
    private Long id;
    //预约流水号
    private String applicationId;
    //编号
    private Integer disclosureCode;
    //标示符[0-否 1-是]
    private Integer disclosureIsTrue;
    //	//姓名
//	private String disclosureName;
//	//详情（地址/关系）
//	private String disclosureDetail;
	//拼接姓名和地址
	private String disclosureNameJoinDetail;

    //披露字段1,多组信息逗号隔开
    private String disclosure1;
    //披露字段2,多组信息逗号隔开
    private String disclosure2;
    //披露字段3,多组信息逗号隔开
    private String disclosure3;
    //披露字段4,多组信息逗号隔开
    private String disclosure4;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;

    List<List> disclosureList;

    public List<List> getDisclosureList() {
        return disclosureList;
    }

    public void setDisclosureList(List<List> disclosureList) {
        this.disclosureList = disclosureList;
    }

    /**
     * 设置：主键ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置：预约流水号
     */
    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    /**
     * 获取：预约流水号
     */
    public String getApplicationId() {
        return applicationId;
    }

    /**
     * 设置：编号
     */
    public void setDisclosureCode(Integer disclosureCode) {
        this.disclosureCode = disclosureCode;
    }

    /**
     * 获取：编号
     */
    public Integer getDisclosureCode() {
        return disclosureCode;
    }

    /**
     * 设置：标示符[0-否 1-是]
     */
    public void setDisclosureIsTrue(Integer disclosureIsTrue) {
        this.disclosureIsTrue = disclosureIsTrue;
    }

    /**
     * 获取：标示符[0-否 1-是]
     */
    public Integer getDisclosureIsTrue() {
        return disclosureIsTrue;
    }

    public String getDisclosure1() {
        return disclosure1;
    }

    public void setDisclosure1(String disclosure1) {
        this.disclosure1 = disclosure1;
    }

    public String getDisclosure2() {
        return disclosure2;
    }

    public void setDisclosure2(String disclosure2) {
        this.disclosure2 = disclosure2;
    }

    public String getDisclosure3() {
        return disclosure3;
    }

    public void setDisclosure3(String disclosure3) {
        this.disclosure3 = disclosure3;
    }

    public String getDisclosure4() {
        return disclosure4;
    }

    public void setDisclosure4(String disclosure4) {
        this.disclosure4 = disclosure4;
    }

    /**
     * 设置：创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取：创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置：更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取：更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    public String getDisclosureNameJoinDetail() {
        return disclosureNameJoinDetail;
    }

    public void setDisclosureNameJoinDetail(String disclosureNameJoinDetail) {
        this.disclosureNameJoinDetail = disclosureNameJoinDetail;
    }
}
