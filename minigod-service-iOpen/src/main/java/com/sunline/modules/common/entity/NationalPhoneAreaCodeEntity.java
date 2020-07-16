package com.sunline.modules.common.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author lcs
 * @email
 * @date 2018-11-06 13:49:14
 */
public class NationalPhoneAreaCodeEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//自增id
	private Integer id;
	//国际区号
	private String name;
	//国际区值
	private String value;
	//
	private Date caeateTime;
	//
	private Date updateTime;
    //国际区名
	private String regionName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getCaeateTime() {
        return caeateTime;
    }

    public void setCaeateTime(Date caeateTime) {
        this.caeateTime = caeateTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
}
