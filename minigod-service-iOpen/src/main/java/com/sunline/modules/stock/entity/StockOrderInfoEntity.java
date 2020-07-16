package com.sunline.modules.stock.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 股票订单信息表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-12-07 15:19:20
 */
public class StockOrderInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//自增id
	private Integer id;
	//买卖方向
    private int stockDirection;
	//股票代码
	private String stockCode;
	//股票名称
	private String stockName;
	//股票数量
	private String stockQuantity;
	//最高价
	private BigDecimal maxPrice;
	//最低价
	private BigDecimal minPrice;
	//发送状态
	private Integer status;
	//创建时间
	private Date createTime;
	//创建人
	private String createUser;
	//修改时间
	private Date updateTime;
	//修改人
	private String updateUser;
	//截止日期
    private String expiryDate;


	//时间区间
	private String beginDate;
	private String endDate;

	//自营账户号
    private String accountNo;
    //自营账户名
    private String accountName;



    /**
     * 持仓量
     */
    private String positionAmount;

	/**
	 * 设置：自增id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：自增id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：股票代码
	 */
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
	/**
	 * 获取：股票代码
	 */
	public String getStockCode() {
		return stockCode;
	}
	/**
	 * 设置：股票名称
	 */
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	/**
	 * 获取：股票名称
	 */
	public String getStockName() {
		return stockName;
	}
	/**
	 * 设置：股票数量
	 */
	public void setStockQuantity(String stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	/**
	 * 获取：股票数量
	 */
	public String getStockQuantity() {
		return stockQuantity;
	}

	/**
	 * 设置：发送状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：发送状态
	 */
	public Integer getStatus() {
		return status;
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
	 * 设置：创建人
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取：创建人
	 */
	public String getCreateUser() {
		return createUser;
	}
	/**
	 * 设置：修改时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：修改人
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	/**
	 * 获取：修改人
	 */
	public String getUpdateUser() {
		return updateUser;
	}

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getPositionAmount() {
        return positionAmount;
    }

    public void setPositionAmount(String positionAmount) {
        this.positionAmount = positionAmount;
    }

    public int getStockDirection() {
        return stockDirection;
    }

    public void setStockDirection(int stockDirection) {
        this.stockDirection = stockDirection;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}
