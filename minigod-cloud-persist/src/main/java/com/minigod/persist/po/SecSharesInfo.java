package com.minigod.persist.po;
import com.minigod.persist.tables.TSecSharesInfo;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;

/**
 * 
 */
@Entity(table=TSecSharesInfo.class)
public class SecSharesInfo implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long sharesId;//转入股票信息ID
	private Integer userId;//用户ID
	private String sharesName;//股票信息
	private String sharesCode;//股票代码
	private Integer sharesNum;//转出数量
	private Integer sharesType;//股票类型 1港股 2美股
	private Integer isFind = 1;//是否全部加载 0 否 1 是
	private Long stockId;//关联转入股票表

    public Long getSharesId () {
        return sharesId;
    }

    public void setSharesId (Long sharesId) {
        this.sharesId = sharesId;
    }

    public Integer getUserId () {
        return userId;
    }

    public void setUserId (Integer userId) {
        this.userId = userId;
    }

    public String getSharesName () {
        return sharesName;
    }

    public void setSharesName (String sharesName) {
        this.sharesName = sharesName;
    }

    public String getSharesCode () {
        return sharesCode;
    }

    public void setSharesCode (String sharesCode) {
        this.sharesCode = sharesCode;
    }

    public Integer getSharesNum () {
        return sharesNum;
    }

    public void setSharesNum (Integer sharesNum) {
        this.sharesNum = sharesNum;
    }

    public Integer getSharesType () {
        return sharesType;
    }

    public void setSharesType (Integer sharesType) {
        this.sharesType = sharesType;
    }

    public Integer getIsFind () {
        return isFind;
    }

    public void setIsFind (Integer isFind) {
        this.isFind = isFind;
    }

    public Long getStockId () {
        return stockId;
    }

    public void setStockId (Long stockId) {
        this.stockId = stockId;
    }
}