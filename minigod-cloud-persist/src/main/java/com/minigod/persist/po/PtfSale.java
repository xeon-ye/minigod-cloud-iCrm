package com.minigod.persist.po;
import com.minigod.persist.tables.TPtfSale;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 */
@Entity(table=TPtfSale.class)
public class PtfSale implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer ptfSaleId;//主键  自增长
	private Integer sellerUserId;//组合所有者ID
	private Integer ptfId;//组合ID  购买的组合
	private Integer buyUserId;//购买用户ID  
	private String priceType;//价格类型  N:正价S:优惠价格
	private BigDecimal price;//价格  购买价格
	private String ptfNameSnapshot;//组合名称  不超过30个汉字(备查,客户端不显示)
	private String ptfDescSnapshot;//组合描述  投资理念的描述
	private String saleDesc;//收费描述  
	private Date startDate;//服务开始交易日  交易日早上九点后购买组合则服务开始时间为下一个交易日
	private Date endDate;//服务结束交易日  
	private BigDecimal targetYield;//组合收费目标收益率  
	private String indexType;//指数类型 R:实盘 S:模拟盘
	private BigDecimal beginIndex;//服务开始指数  服务开始的交易日的上一个交易日的指数（待确认）
	private BigDecimal endIndex;//服务结束指数  服务结束的交易日收盘后计算
	private BigDecimal highIndex;//服务期间最高收益的指数 服务期间每个交易日收盘后计算
	private Date highDate;//服务期间最高收益的日期 服务期间每个交易日收盘后计算
	private BigDecimal achieveDateIndex;//达到预期收益的日期的指数  服务期间每个交易日收盘后计算
	private Date achieveDate;//达到预期收益的日期 服务期间每个交易日收盘后计算
	private String ptfSaleStatus;//订单状态  A:客户待付款B:未付款已关闭C:服务中，任务未达成D:服务中，任务已达成E:服务结束，任务已达成F:服务结束，任务未达成
	private String needRetry;//存在业务需要重试  Y/N
	private String chargeOrderId;//申请支付订单的ID 本地生成，申请支付订单的ID
	private String payChannel;//当前支付渠道  W:微信
	private Integer chargeTrxId;//客户充值账务ID  把客户支付的钱转到客户账户中。
	private String transferOrderId;//申请转账到组合收费账户的ID  本地生成，申请转账的ID
	private String transferStatus;//转账状态  W:等待转账E:转账超时F:转账失败（有明确的错误原因）S:转账已成功
	private String transferError;//转账失败的描述 
	private Integer transferTrxId;//客户付款的账务系统交易ID 
	private String payOrderId;//申请转账到投顾账户的ID  本地生成，申请转账的ID
	private String payStatus;//付款状态  W:等待转账E:转账超时F:转账失败（有明确的错误原因）S:转账已成功
	private String payError;//付款失败的描述 
	private Integer payTrxId;//付款给投顾的账务系统交易ID  
	private BigDecimal payActualAmt;//转给投顾的实际金额
	private BigDecimal payFee;//齐牛收取的费用
	private String refundOrderId;//申请转账到投顾账户的ID  本地生成，申请退款到用户账户的ID
	private String refundStatus;//退款状态  W:等待退款E:退款超时F:退款失败（有明确的错误原因）S:退款已成功
	private String refundError;//退款到客户账户失败的描述  
	private Integer refundToUserTrxId;//退款给客户的账务系统交易ID  
	private Integer refundToWxTrxId;//退款给微信的账务系统交易ID  
	private Date createTime;//创建时间 
	private Date updateTime;//修改时间 
	private Integer lockVersion;//乐观锁版本号  

    public Integer getPtfSaleId () {
        return ptfSaleId;
    }

    public void setPtfSaleId (Integer ptfSaleId) {
        this.ptfSaleId = ptfSaleId;
    }

    public Integer getSellerUserId () {
        return sellerUserId;
    }

    public void setSellerUserId (Integer sellerUserId) {
        this.sellerUserId = sellerUserId;
    }

    public Integer getPtfId () {
        return ptfId;
    }

    public void setPtfId (Integer ptfId) {
        this.ptfId = ptfId;
    }

    public Integer getBuyUserId () {
        return buyUserId;
    }

    public void setBuyUserId (Integer buyUserId) {
        this.buyUserId = buyUserId;
    }

    public String getPriceType () {
        return priceType;
    }

    public void setPriceType (String priceType) {
        this.priceType = priceType;
    }

    public BigDecimal getPrice () {
        return price;
    }

    public void setPrice (BigDecimal price) {
        this.price = price;
    }

    public String getPtfNameSnapshot () {
        return ptfNameSnapshot;
    }

    public void setPtfNameSnapshot (String ptfNameSnapshot) {
        this.ptfNameSnapshot = ptfNameSnapshot;
    }

    public String getPtfDescSnapshot () {
        return ptfDescSnapshot;
    }

    public void setPtfDescSnapshot (String ptfDescSnapshot) {
        this.ptfDescSnapshot = ptfDescSnapshot;
    }

    public String getSaleDesc () {
        return saleDesc;
    }

    public void setSaleDesc (String saleDesc) {
        this.saleDesc = saleDesc;
    }

    public Date getStartDate () {
        return startDate;
    }

    public void setStartDate (Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate () {
        return endDate;
    }

    public void setEndDate (Date endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getTargetYield () {
        return targetYield;
    }

    public void setTargetYield (BigDecimal targetYield) {
        this.targetYield = targetYield;
    }

    public String getIndexType () {
        return indexType;
    }

    public void setIndexType (String indexType) {
        this.indexType = indexType;
    }

    public BigDecimal getBeginIndex () {
        return beginIndex;
    }

    public void setBeginIndex (BigDecimal beginIndex) {
        this.beginIndex = beginIndex;
    }

    public BigDecimal getEndIndex () {
        return endIndex;
    }

    public void setEndIndex (BigDecimal endIndex) {
        this.endIndex = endIndex;
    }

    public BigDecimal getHighIndex () {
        return highIndex;
    }

    public void setHighIndex (BigDecimal highIndex) {
        this.highIndex = highIndex;
    }

    public Date getHighDate () {
        return highDate;
    }

    public void setHighDate (Date highDate) {
        this.highDate = highDate;
    }

    public BigDecimal getAchieveDateIndex () {
        return achieveDateIndex;
    }

    public void setAchieveDateIndex (BigDecimal achieveDateIndex) {
        this.achieveDateIndex = achieveDateIndex;
    }

    public Date getAchieveDate () {
        return achieveDate;
    }

    public void setAchieveDate (Date achieveDate) {
        this.achieveDate = achieveDate;
    }

    public String getPtfSaleStatus () {
        return ptfSaleStatus;
    }

    public void setPtfSaleStatus (String ptfSaleStatus) {
        this.ptfSaleStatus = ptfSaleStatus;
    }

    public String getNeedRetry () {
        return needRetry;
    }

    public void setNeedRetry (String needRetry) {
        this.needRetry = needRetry;
    }

    public String getChargeOrderId () {
        return chargeOrderId;
    }

    public void setChargeOrderId (String chargeOrderId) {
        this.chargeOrderId = chargeOrderId;
    }

    public String getPayChannel () {
        return payChannel;
    }

    public void setPayChannel (String payChannel) {
        this.payChannel = payChannel;
    }

    public Integer getChargeTrxId () {
        return chargeTrxId;
    }

    public void setChargeTrxId (Integer chargeTrxId) {
        this.chargeTrxId = chargeTrxId;
    }

    public String getTransferOrderId () {
        return transferOrderId;
    }

    public void setTransferOrderId (String transferOrderId) {
        this.transferOrderId = transferOrderId;
    }

    public String getTransferStatus () {
        return transferStatus;
    }

    public void setTransferStatus (String transferStatus) {
        this.transferStatus = transferStatus;
    }

    public String getTransferError () {
        return transferError;
    }

    public void setTransferError (String transferError) {
        this.transferError = transferError;
    }

    public Integer getTransferTrxId () {
        return transferTrxId;
    }

    public void setTransferTrxId (Integer transferTrxId) {
        this.transferTrxId = transferTrxId;
    }

    public String getPayOrderId () {
        return payOrderId;
    }

    public void setPayOrderId (String payOrderId) {
        this.payOrderId = payOrderId;
    }

    public String getPayStatus () {
        return payStatus;
    }

    public void setPayStatus (String payStatus) {
        this.payStatus = payStatus;
    }

    public String getPayError () {
        return payError;
    }

    public void setPayError (String payError) {
        this.payError = payError;
    }

    public Integer getPayTrxId () {
        return payTrxId;
    }

    public void setPayTrxId (Integer payTrxId) {
        this.payTrxId = payTrxId;
    }

    public BigDecimal getPayActualAmt () {
        return payActualAmt;
    }

    public void setPayActualAmt (BigDecimal payActualAmt) {
        this.payActualAmt = payActualAmt;
    }

    public BigDecimal getPayFee () {
        return payFee;
    }

    public void setPayFee (BigDecimal payFee) {
        this.payFee = payFee;
    }

    public String getRefundOrderId () {
        return refundOrderId;
    }

    public void setRefundOrderId (String refundOrderId) {
        this.refundOrderId = refundOrderId;
    }

    public String getRefundStatus () {
        return refundStatus;
    }

    public void setRefundStatus (String refundStatus) {
        this.refundStatus = refundStatus;
    }

    public String getRefundError () {
        return refundError;
    }

    public void setRefundError (String refundError) {
        this.refundError = refundError;
    }

    public Integer getRefundToUserTrxId () {
        return refundToUserTrxId;
    }

    public void setRefundToUserTrxId (Integer refundToUserTrxId) {
        this.refundToUserTrxId = refundToUserTrxId;
    }

    public Integer getRefundToWxTrxId () {
        return refundToWxTrxId;
    }

    public void setRefundToWxTrxId (Integer refundToWxTrxId) {
        this.refundToWxTrxId = refundToWxTrxId;
    }

    public Date getCreateTime () {
        return createTime;
    }

    public void setCreateTime (Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime () {
        return updateTime;
    }

    public void setUpdateTime (Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getLockVersion () {
        return lockVersion;
    }

    public void setLockVersion (Integer lockVersion) {
        this.lockVersion = lockVersion;
    }
}