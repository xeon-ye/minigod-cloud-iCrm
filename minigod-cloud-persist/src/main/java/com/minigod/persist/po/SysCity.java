package com.minigod.persist.po;
import com.minigod.persist.tables.TSysCity;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;

/**
 * 城市信息表
 */
@Entity(table=TSysCity.class)
public class SysCity implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer id;
	private String name;//城市名称
	private Integer provinceId;//所属省份
	private String keyTitle;//拼音首字符
	private Integer status;//是否有效，1为有效，0未无效

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public Integer getProvinceId () {
        return provinceId;
    }

    public void setProvinceId (Integer provinceId) {
        this.provinceId = provinceId;
    }

    public String getKeyTitle () {
        return keyTitle;
    }

    public void setKeyTitle (String keyTitle) {
        this.keyTitle = keyTitle;
    }

    public Integer getStatus () {
        return status;
    }

    public void setStatus (Integer status) {
        this.status = status;
    }
}