package com.minigod.persist.po;
import com.minigod.persist.tables.TGrmHqProductInfo;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 行情产品信息表
 */
@Entity(table=TGrmHqProductInfo.class)
public class GrmHqProductInfo implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer id;
	private String productId;//产品唯一编码
	private String productName;//产品名称
	private String productDesc;//产品描述
	private String productPicUrl;//产品图片
	private Double originalPrice;//原始价格
	private Double price;//产品价格
	private Integer moneyType;//计价币种
	private String totalQuantity;//产品总数
	private String remainingQuantity;//剩余数量
	private Date addDate;//添加日期
	private String addOperator;//添加操作员
	private Date modifyDate;//最近一次修改日期
	private String modifyOperator;//最近一次修改操作员
	private Date expiryDate;//截至时间
	private Date deleteDate;//删除日期
	private String deleteOperator;//删除产品的操作员

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public String getProductId () {
        return productId;
    }

    public void setProductId (String productId) {
        this.productId = productId;
    }

    public String getProductName () {
        return productName;
    }

    public void setProductName (String productName) {
        this.productName = productName;
    }

    public String getProductDesc () {
        return productDesc;
    }

    public void setProductDesc (String productDesc) {
        this.productDesc = productDesc;
    }

    public String getProductPicUrl () {
        return productPicUrl;
    }

    public void setProductPicUrl (String productPicUrl) {
        this.productPicUrl = productPicUrl;
    }

    public Double getOriginalPrice () {
        return originalPrice;
    }

    public void setOriginalPrice (Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Double getPrice () {
        return price;
    }

    public void setPrice (Double price) {
        this.price = price;
    }

    public Integer getMoneyType () {
        return moneyType;
    }

    public void setMoneyType (Integer moneyType) {
        this.moneyType = moneyType;
    }

    public String getTotalQuantity () {
        return totalQuantity;
    }

    public void setTotalQuantity (String totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public String getRemainingQuantity () {
        return remainingQuantity;
    }

    public void setRemainingQuantity (String remainingQuantity) {
        this.remainingQuantity = remainingQuantity;
    }

    public Date getAddDate () {
        return addDate;
    }

    public void setAddDate (Date addDate) {
        this.addDate = addDate;
    }

    public String getAddOperator () {
        return addOperator;
    }

    public void setAddOperator (String addOperator) {
        this.addOperator = addOperator;
    }

    public Date getModifyDate () {
        return modifyDate;
    }

    public void setModifyDate (Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getModifyOperator () {
        return modifyOperator;
    }

    public void setModifyOperator (String modifyOperator) {
        this.modifyOperator = modifyOperator;
    }

    public Date getExpiryDate () {
        return expiryDate;
    }

    public void setExpiryDate (Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Date getDeleteDate () {
        return deleteDate;
    }

    public void setDeleteDate (Date deleteDate) {
        this.deleteDate = deleteDate;
    }

    public String getDeleteOperator () {
        return deleteOperator;
    }

    public void setDeleteOperator (String deleteOperator) {
        this.deleteOperator = deleteOperator;
    }
}