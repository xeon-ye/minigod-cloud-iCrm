package com.minigod.api.grm.fc.vo;

import java.io.Serializable;

/**
 * Created by CaiJianbo on 2016/11/12 15:43.
 * minigod
 */
public class HqProductInfo implements Serializable{
    private static final long serialVersionUID = 1L;

    protected int productId ;
    protected String productName;
    protected String productInfo;
    protected String imgPath;
    protected double productPrice;
    //0代表点击报价产品，1代表实时串流产品
    protected int productType;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(String productInfo) {
        this.productInfo = productInfo;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }
}
