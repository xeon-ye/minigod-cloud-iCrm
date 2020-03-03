package com.minigod.persist.po;
import com.minigod.persist.tables.TImportData;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TImportData.class)
public class ImportData implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer id;
	private String phone;//手机
	private String name;//名字
	private String sex;//性别
	private String city;//城市
	private Date registDate;//注册时间
	private String amount;//额度
	private Integer orderCount;//下单次数
	private Integer level;//优先级
	private Integer isImport = 0;//是否已导入 0未导入1已导入
	private String remark;

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public String getPhone () {
        return phone;
    }

    public void setPhone (String phone) {
        this.phone = phone;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getSex () {
        return sex;
    }

    public void setSex (String sex) {
        this.sex = sex;
    }

    public String getCity () {
        return city;
    }

    public void setCity (String city) {
        this.city = city;
    }

    public Date getRegistDate () {
        return registDate;
    }

    public void setRegistDate (Date registDate) {
        this.registDate = registDate;
    }

    public String getAmount () {
        return amount;
    }

    public void setAmount (String amount) {
        this.amount = amount;
    }

    public Integer getOrderCount () {
        return orderCount;
    }

    public void setOrderCount (Integer orderCount) {
        this.orderCount = orderCount;
    }

    public Integer getLevel () {
        return level;
    }

    public void setLevel (Integer level) {
        this.level = level;
    }

    public Integer getIsImport () {
        return isImport;
    }

    public void setIsImport (Integer isImport) {
        this.isImport = isImport;
    }

    public String getRemark () {
        return remark;
    }

    public void setRemark (String remark) {
        this.remark = remark;
    }
}