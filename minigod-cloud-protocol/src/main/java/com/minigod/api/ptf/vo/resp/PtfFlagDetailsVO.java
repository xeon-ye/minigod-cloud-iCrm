package com.minigod.api.ptf.vo.resp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.minigod.api.ptf.vo.req.PtfInfoSimuVO.SaleFlag;
import com.minigod.api.ptf.vo.resp.PtfAttentionRspVO.PtfAttentionRspVO_Follower;
import com.minigod.api.ptf.vo.resp.PtfFollowerRspVO.PtfFollowerRspVO_Follower;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @Title: PtfFlagDetailsVO.java
 * @Description: 按标志位取组合详情信息值对象
 * @Copyright: © 2014 minigod
 * @Company: minigod
 *
 * @author minigod
 * @date 2014-11-11 上午11:33:48
 * @version v1.0
 */
@TransferBean
public class PtfFlagDetailsVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Emoji
	private String name; // 组合名称
	
	@TransferID
	private Long ptfId; // 组合id
	
	private Double ptfIdx; // 组合指数
	
	private Double tdYield; // 日收益率
	
	private Double mYield; // 月收益率
	
	private Double yYield; // 年收益率
	
	private Double tYield; // 总收益率
	
	private Long runTime; // 组合创建以来运行的总天数
	
	@Emoji
	private String desc; // 组合描述

	private Integer perm; // 组合权限

	private Long idxTs; // 组合净值日期

	private Integer bchType; // 组合业绩基准

	private String bchId; // 业绩基准id

	private Integer mktStatus; // 市场状态
	
	private Integer fowCnt; // 跟单人数
	
	private Integer notes; // 笔记条数
	
	private String owner; // 所有者
	
	private Integer volatility; // 组合波动率
	
	@TransferID
	private Long uId; // 用户id
	
	@Emoji
	private String uName; // 创建者名字
	
	private String uImg; // 创建者图像Url地址

	private List<Stocks> stks; // 组合资产对象
	
	private Long createTime; // 组合的创建日期
	
	private String isReal; // 是否实盘
	
	private Double pe; // 市盈率
	
	private String like; // 观点数
	
	private List<StkCate> stkCate; // 股票大类
	
	private Integer favCnt; // 关注人数
	
	private String fav; // 关注者
	
	private String fow; // 跟单者
	
	private Integer likeCnt; // 观点数
	
	private String isTransing; // 创建人是否存在在途交易
	
	private String authShare; // 允许分享
	
	private Double avgMonthYield; // 月均收益（只有在拉取组合列表且拉取组合的类型为 G,H,I时有效）
	
	@TransferID
	@Emoji
	private List<PtfAttentionRspVO_Follower> favPers;//关注人集合
	
	@TransferID
	@Emoji
	private List<PtfFollowerRspVO_Follower> fowPers;//购买人集合
	
	private Integer uType;//用户类型 1、普通用户 2、投顾
	
	private Integer brkId;//组合实盘券商ID
	
	private PtfWinRate ptfWinRate;//组合选股胜率
	
	private BigDecimal ptfMaxRetrace;//组合最大回测
	
	private SaleInfo saleInfo;//收费订阅信息
	
	private BuyInfo buyInfo;//订阅信息
	
	private Rebalance rebalance;//最近一次调仓
	
	private Integer ptfDetailForm;//组合详情展示形式  0：所有信息 1：受限信息（未付费）
	
	private BigDecimal stkWgt;
	
	private Integer saleCount;
	
	private NeedToBuildRelation needToBuildRelation;
	
	public NeedToBuildRelation getNeedToBuildRelation() {
		return needToBuildRelation;
	}

	public void setNeedToBuildRelation(NeedToBuildRelation needToBeCustomer) {
		this.needToBuildRelation = needToBeCustomer;
	}

	public Integer getSaleCount() {
		return saleCount;
	}

	public void setSaleCount(Integer saleCount) {
		this.saleCount = saleCount;
	}

	public BigDecimal getStkWgt() {
		return stkWgt;
	}

	public void setStkWgt(BigDecimal stkWgt) {
		this.stkWgt = stkWgt;
	}

	public Rebalance getRebalance() {
		return rebalance;
	}

	public void setRebalance(Rebalance rebalance) {
		this.rebalance = rebalance;
	}

	public Integer getPtfDetailForm() {
		return ptfDetailForm;
	}

	public void setPtfDetailForm(Integer ptfDetailForm) {
		this.ptfDetailForm = ptfDetailForm;
	}

	public BuyInfo getBuyInfo() {
		return buyInfo;
	}

	public void setBuyInfo(BuyInfo buyInfo) {
		this.buyInfo = buyInfo;
	}

	public SaleInfo getSaleInfo() {
		return saleInfo;
	}

	public void setSaleInfo(SaleInfo saleInfo) {
		this.saleInfo = saleInfo;
	}


	public PtfWinRate getPtfWinRate() {
		return ptfWinRate;
	}

	public void setPtfWinRate(PtfWinRate ptfWinRate) {
		this.ptfWinRate = ptfWinRate;
	}

	public BigDecimal getPtfMaxRetrace() {
		return ptfMaxRetrace;
	}

	public void setPtfMaxRetrace(BigDecimal ptfMaxRetrace) {
		this.ptfMaxRetrace = ptfMaxRetrace;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPtfId() {
		return ptfId;
	}

	public void setPtfId(Long ptfId) {
		this.ptfId = ptfId;
	}

	public Double getPtfIdx() {
		return ptfIdx;
	}

	public void setPtfIdx(Double ptfIdx) {
		this.ptfIdx = ptfIdx;
	}

	public Double getTdYield() {
		return tdYield;
	}

	public void setTdYield(Double tdYield) {
		this.tdYield = tdYield;
	}

	public Double getmYield() {
		return mYield;
	}

	public void setmYield(Double mYield) {
		this.mYield = mYield;
	}

	public Double getyYield() {
		return yYield;
	}

	public void setyYield(Double yYield) {
		this.yYield = yYield;
	}

	public Double gettYield() {
		return tYield;
	}

	public void settYield(Double tYield) {
		this.tYield = tYield;
	}

	public Long getRunTime() {
		return runTime;
	}

	public void setRunTime(Long runTime) {
		this.runTime = runTime;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Integer getPerm() {
		return perm;
	}

	public void setPerm(Integer perm) {
		this.perm = perm;
	}

	public Long getIdxTs() {
		return idxTs;
	}

	public void setIdxTs(Long idxTs) {
		this.idxTs = idxTs;
	}

	public Integer getBchType() {
		return bchType;
	}

	public void setBchType(Integer bchType) {
		this.bchType = bchType;
	}

	public String getBchId() {
		return bchId;
	}

	public void setBchId(String bchId) {
		this.bchId = bchId;
	}

	public Integer getMktStatus() {
		return mktStatus;
	}

	public void setMktStatus(Integer mktStatus) {
		this.mktStatus = mktStatus;
	}

	public Integer getFowCnt() {
		return fowCnt;
	}

	public void setFowCnt(Integer fowCnt) {
		this.fowCnt = fowCnt;
	}

	public Integer getNotes() {
		return notes;
	}

	public void setNotes(Integer notes) {
		this.notes = notes;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public Integer getVolatility() {
		return volatility;
	}

	public void setVolatility(Integer volatility) {
		this.volatility = volatility;
	}

	public Long getuId() {
		return uId;
	}

	public void setuId(Long uId) {
		this.uId = uId;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuImg() {
		return uImg;
	}

	public void setuImg(String uImg) {
		this.uImg = uImg;
	}

	public List<Stocks> getStks() {
		return stks;
	}

	public void setStks(List<Stocks> stks) {
		this.stks = stks;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
	
	public String getIsReal() {
		return isReal;
	}

	public void setIsReal(String isReal) {
		this.isReal = isReal;
	}

	public Double getPe() {
		return pe;
	}

	public void setPe(Double pe) {
		this.pe = pe;
	}

	public List<StkCate> getStkCate() {
		return stkCate;
	}

	public void setStkCate(List<StkCate> stkCate) {
		this.stkCate = stkCate;
	}

	public Integer getFavCnt() {
		return favCnt;
	}

	public void setFavCnt(Integer favCnt) {
		this.favCnt = favCnt;
	}

	public String getFav() {
		return fav;
	}

	public void setFav(String fav) {
		this.fav = fav;
	}

	public String getFow() {
		return fow;
	}

	public void setFow(String fow) {
		this.fow = fow;
	}

	public String getLike() {
		return like;
	}

	public void setLike(String like) {
		this.like = like;
	}

	public Integer getLikeCnt() {
		return likeCnt;
	}

	public void setLikeCnt(Integer likeCnt) {
		this.likeCnt = likeCnt;
	}

	public String getIsTransing() {
		return isTransing;
	}

	public void setIsTransing(String isTransing) {
		this.isTransing = isTransing;
	}

	public String getAuthShare() {
		return authShare;
	}

	public void setAuthShare(String authShare) {
		this.authShare = authShare;
	}
	
	public Double getAvgMonthYield() {
		return avgMonthYield;
	}

	public void setAvgMonthYield(Double avgMonthYield) {
		this.avgMonthYield = avgMonthYield;
	}

	public List<PtfAttentionRspVO_Follower> getFavPers() {
		return favPers;
	}

	public void setFavPers(List<PtfAttentionRspVO_Follower> favPers) {
		this.favPers = favPers;
	}

	public List<PtfFollowerRspVO_Follower> getFowPers() {
		return fowPers;
	}

	public void setFowPers(List<PtfFollowerRspVO_Follower> fowPers) {
		this.fowPers = fowPers;
	}

	public Integer getuType() {
		return uType;
	}

	public void setuType(Integer uType) {
		this.uType = uType;
	}



	public Integer getBrkId() {
		return brkId;
	}

	public void setBrkId(Integer brkId) {
		this.brkId = brkId;
	}


	public static class NeedToBuildRelation{
		/**
		 * 	String notNeed ="U";
		 *	String toBeFriend ="A";
		 *	String toBeCustomer ="B";
		 */
		private String fav;
		private String buy;
		
		
		public String getFav() {
			return fav;
		}
		public void setFav(String fav) {
			this.fav = fav;
		}
		public String getBuy() {
			return buy;
		}
		public void setBuy(String buy) {
			this.buy = buy;
		}
	}
	
	public static class PtfWinRate implements Serializable{
		
		private static final long serialVersionUID = 1L;
		
		private BigDecimal rate;
		private Integer hldStkCount;
		private Integer winStkCount;
		public BigDecimal getRate() {
			return rate;
		}
		public void setRate(BigDecimal rate) {
			this.rate = rate;
		}
		public Integer getHldStkCount() {
			return hldStkCount;
		}
		public void setHldStkCount(Integer hldStkCount) {
			this.hldStkCount = hldStkCount;
		}
		public Integer getWinStkCount() {
			return winStkCount;
		}
		public void setWinStkCount(Integer winStkCount) {
			this.winStkCount = winStkCount;
		}
	}


	public static class SaleInfo implements Serializable{
		private static final long serialVersionUID = 1L;
		
		private SaleFlag saleFlag;
		private String targetTimeDesc;
		private BigDecimal targetYield;
		private BigDecimal price;
		private BigDecimal salesPrice;
		private BigDecimal vipPrice;
		private String priceType;
		
		
		public SaleFlag getSaleFlag() {
			return saleFlag;
		}
		public void setSaleFlag(SaleFlag saleFlag) {
			this.saleFlag = saleFlag;
		}
		public String getTargetTimeDesc() {
			return targetTimeDesc;
		}
		public void setTargetTimeDesc(String targetTimeDesc) {
			this.targetTimeDesc = targetTimeDesc;
		}
		public BigDecimal getTargetYield() {
			return targetYield;
		}
		public void setTargetYield(BigDecimal targetYield) {
			this.targetYield = targetYield;
		}
		public BigDecimal getPrice() {
			return price;
		}
		public void setPrice(BigDecimal price) {
			this.price = price;
		}
		public BigDecimal getSalesPrice() {
			return salesPrice;
		}
		public void setSalesPrice(BigDecimal salesPrice) {
			this.salesPrice = salesPrice;
		}
		public String getPriceType() {
			return priceType;
		}
		public void setPriceType(String priceType) {
			this.priceType = priceType;
		}
		public BigDecimal getVipPrice() {
			return vipPrice;
		}
		public void setVipPrice(BigDecimal vipPrice) {
			this.vipPrice = vipPrice;
		}
		
	}
	
	public static class BuyInfo implements Serializable{

		private static final long serialVersionUID = 1L;
		
		private String buyFlag;
		private String targetTimeDesc;
		private BigDecimal targetYield;
		private BigDecimal currentYield;
		private Integer restDay;
		private Date startDay;
		private Date endDay;
		private Date achieveDay;
		private BigDecimal achieveDayYield;
		
		public Date getStartDay() {
			return startDay;
		}
		public void setStartDay(Date startDay) {
			this.startDay = startDay;
		}
		public Date getEndDay() {
			return endDay;
		}
		public void setEndDay(Date endDay) {
			this.endDay = endDay;
		}
		public BigDecimal getAchieveDayYield() {
			return achieveDayYield;
		}
		public void setAchieveDayYield(BigDecimal achieveDayYield) {
			this.achieveDayYield = achieveDayYield;
		}
		public String getBuyFlag() {
			return buyFlag;
		}
		public void setBuyFlag(String buyFlag) {
			this.buyFlag = buyFlag;
		}
		public String getTargetTimeDesc() {
			return targetTimeDesc;
		}
		public void setTargetTimeDesc(String targetTimeDesc) {
			this.targetTimeDesc = targetTimeDesc;
		}
		public BigDecimal getTargetYield() {
			return targetYield;
		}
		public void setTargetYield(BigDecimal targetYield) {
			this.targetYield = targetYield;
		}
		public BigDecimal getCurrentYield() {
			return currentYield;
		}
		public void setCurrentYield(BigDecimal currentYield) {
			this.currentYield = currentYield;
		}
		public Integer getRestDay() {
			return restDay;
		}
		public void setRestDay(Integer restDay) {
			this.restDay = restDay;
		}
		public Date getAchieveDay() {
			return achieveDay;
		}
		public void setAchieveDay(Date achieveDay) {
			this.achieveDay = achieveDay;
		}
		
		
	}
	
	public static class Rebalance implements Serializable{

		private static final long serialVersionUID = 261842106862776392L;
		
		private String busCon;
		private Date ts;
		
		public String getBusCon() {
			return busCon;
		}
		public void setBusCon(String busCon) {
			this.busCon = busCon;
		}
		public Date getTs() {
			return ts;
		}
		public void setTs(Date ts) {
			this.ts = ts;
		}
	}


	public static class StkCate implements Serializable{
		private static final long serialVersionUID = -5783602355338325599L;

		private String cateName; // 大类股票名称

		private Double wgt; // 大类股票占比
		
		private Integer stksCnt;
		
		
		
		public Integer getStksCnt() {
			return stksCnt;
		}

		public void setStksCnt(Integer stksCnt) {
			this.stksCnt = stksCnt;
		}

		private List<Stocks> stks;

		public String getCateName() {
			return cateName;
		}

		public void setCateName(String cateName) {
			this.cateName = cateName;
		}

		public Double getWgt() {
			return wgt;
		}

		public void setWeight(Double wgt) {
			this.wgt = wgt;
		}

		public List<Stocks> getStks() {
			return stks;
		}

		public void setStks(List<Stocks> stks) {
			this.stks = stks;
		}
	}
	
	/**
	 * 资产基本信息类
	 */
	public static class Stocks implements Serializable{
		/**  */
		private static final long serialVersionUID = 3710508109918467208L;

		private String assetId; // 资产id

		private String stkName; // 资产名称

		private Double weight; // 资产占比

		private String price; // 资产当前价格

		private Double changePct; // 日涨跌幅
		
		private Integer status; // 股票状态
		
		private String hldPrc;//持仓成本价
		
		private Double hldYld;//盈亏比例
		
		private String stkType;//证券类别

		public String getAssetId() {
			return assetId;
		}

		public void setAssetId(String assetId) {
			this.assetId = assetId;
		}

		public String getStkName() {
			return stkName;
		}

		public void setStkName(String stkName) {
			this.stkName = stkName;
		}

		public Double getWeight() {
			return weight;
		}

		public void setWeight(Double weight) {
			this.weight = weight;
		}

		public String getPrice() {
			return price;
		}

		public void setPrice(String price) {
			this.price = price;
		}

		public Double getChangePct() {
			return changePct;
		}

		public void setChangePct(Double changePct) {
			this.changePct = changePct;
		}

		public Integer getStatus() {
			return status;
		}

		public void setStatus(Integer status) {
			this.status = status;
		}

		public String getHldPrc() {
			return hldPrc;
		}

		public void setHldPrc(String hldPrc) {
			this.hldPrc = hldPrc;
		}

		public Double getHldYld() {
			return hldYld;
		}

		public void setHldYld(Double hldYld) {
			this.hldYld = hldYld;
		}

		public String getStkType() {
			return stkType;
		}

		public void setStkType(String stkType) {
			this.stkType = stkType;
		}
		
		
	}

}
