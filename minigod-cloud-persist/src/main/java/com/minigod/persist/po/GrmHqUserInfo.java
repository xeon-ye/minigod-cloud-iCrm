package com.minigod.persist.po;
import com.minigod.persist.tables.TGrmHqUserInfo;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;

/**
 * 用户信息表
 */
@Entity(table=TGrmHqUserInfo.class)
public class GrmHqUserInfo implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer id;
	private String mobile;
	private String nameChs;
	private String nameEng;
	private String nameCht;
	private Integer sex;
	private String address;
	private String telNo;
	private Integer nationality;

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public String getMobile () {
        return mobile;
    }

    public void setMobile (String mobile) {
        this.mobile = mobile;
    }

    public String getNameChs () {
        return nameChs;
    }

    public void setNameChs (String nameChs) {
        this.nameChs = nameChs;
    }

    public String getNameEng () {
        return nameEng;
    }

    public void setNameEng (String nameEng) {
        this.nameEng = nameEng;
    }

    public String getNameCht () {
        return nameCht;
    }

    public void setNameCht (String nameCht) {
        this.nameCht = nameCht;
    }

    public Integer getSex () {
        return sex;
    }

    public void setSex (Integer sex) {
        this.sex = sex;
    }

    public String getAddress () {
        return address;
    }

    public void setAddress (String address) {
        this.address = address;
    }

    public String getTelNo () {
        return telNo;
    }

    public void setTelNo (String telNo) {
        this.telNo = telNo;
    }

    public Integer getNationality () {
        return nationality;
    }

    public void setNationality (Integer nationality) {
        this.nationality = nationality;
    }
}