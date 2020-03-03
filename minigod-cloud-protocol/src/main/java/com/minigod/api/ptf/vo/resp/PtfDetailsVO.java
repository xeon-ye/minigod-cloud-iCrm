package com.minigod.api.ptf.vo.resp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.minigod.api.ptf.vo.resp.PtfFlagDetailsVO.Rebalance;
import com.minigod.api.ptf.vo.resp.PtfFlagDetailsVO.StkCate;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @Title: PtfDetailsVO.java
 * @Description: 组合详情返回值对象
 * @Copyright: © 2014 minigod
 * @Company: minigod
 * 
 * @author minigod
 * @date 2014-11-1 下午2:10:08
 * @version v1.0
 */
@TransferBean
public class PtfDetailsVO implements Serializable {

	private static final long serialVersionUID = 1L;
	@Emoji
	private String name; // 组合名称
	
	@TransferID
	private String ptfId; // 组合id
	
	private Double tdYield; // 日收益率
	
	private Double tYield; // 总收益率
	@Emoji
	private String desc; // 组合描述

	private Integer volatility; // 组合波动率
	
	@TransferID
	private String uId; // 用户id
	@Emoji
	private String uName; // 创建者名字
	
	private String uSig; // 创建者个性签名
	
	private String uImg; // 创建者图像Url地址
	
	private Double ptfIdx; // 组合指数
	
	private Long createTime; // 组合创建时间
	
	private String isReal;//是否实盘
	
	private Double pe; // 市盈率
	
	private List<StkCate> stkCate; // 股票大类
	
	private Integer uType;//用户类型 1、普通用户 2、投顾
	
	private Integer gender;//用户性别(1男，0女)
	@Emoji
	private String orgName;//所属投顾机构名称
	@Emoji
	private String orgDesc;//简介
	
	private BigDecimal stkWgt;//仓位
	
	private BigDecimal ptfWinRate;//组合选股胜率
	
	private Integer favCnt; // 关注人数
	
	private BigDecimal ptfMaxRetrace;//组合最大回测
	
	private Double mYield; // 月收益率
	
	private Double yYield; // 年收益率
	
	private Rebalance rebalance;//最近一次调仓

	private String adviserName;//认证名称
	
	private String[] specialFields;// 擅长领域
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPtfId() {
		return ptfId;
	}

	public void setPtfId(String ptfId) {
		this.ptfId = ptfId;
	}

	public Double getTdYield() {
		return tdYield;
	}

	public void setTdYield(Double tdYield) {
		this.tdYield = tdYield;
	}

	public Double gettYield() {
		return tYield;
	}

	public void settYield(Double tYield) {
		this.tYield = tYield;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Integer getVolatility() {
		return volatility;
	}

	public void setVolatility(Integer volatility) {
		this.volatility = volatility;
	}

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuSig() {
		return uSig;
	}

	public void setuSig(String uSig) {
		this.uSig = uSig;
	}

	public String getuImg() {
		return uImg;
	}

	public void setuImg(String uImg) {
		this.uImg = uImg;
	}
	
	public Double getPtfIdx() {
		return ptfIdx;
	}

	public void setPtfIdx(Double ptfIdx) {
		this.ptfIdx = ptfIdx;
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

	public List<StkCate> getStkCate() {
		return stkCate;
	}

	public void setStkCate(List<StkCate> stkCate) {
		this.stkCate = stkCate;
	}

	public Double getPe() {
		return pe;
	}

	public void setPe(Double pe) {
		this.pe = pe;
	}

	public Integer getuType() {
		return uType;
	}

	public void setuType(Integer uType) {
		this.uType = uType;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgDesc() {
		return orgDesc;
	}

	public void setOrgDesc(String orgDesc) {
		this.orgDesc = orgDesc;
	}

	public BigDecimal getStkWgt() {
		return stkWgt;
	}

	public void setStkWgt(BigDecimal stkWgt) {
		this.stkWgt = stkWgt;
	}

	public BigDecimal getPtfWinRate() {
		return ptfWinRate;
	}

	public void setPtfWinRate(BigDecimal ptfWinRate) {
		this.ptfWinRate = ptfWinRate;
	}

	public Integer getFavCnt() {
		return favCnt;
	}

	public void setFavCnt(Integer favCnt) {
		this.favCnt = favCnt;
	}

	public BigDecimal getPtfMaxRetrace() {
		return ptfMaxRetrace;
	}

	public void setPtfMaxRetrace(BigDecimal ptfMaxRetrace) {
		this.ptfMaxRetrace = ptfMaxRetrace;
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

	public Rebalance getRebalance() {
		return rebalance;
	}

	public void setRebalance(Rebalance rebalance) {
		this.rebalance = rebalance;
	}

	public String getAdviserName() {
		return adviserName;
	}

	public void setAdviserName(String adviserName) {
		this.adviserName = adviserName;
	}

	public String[] getSpecialFields() {
		return specialFields;
	}

	public void setSpecialFields(String[] specialFields) {
		this.specialFields = specialFields;
	}
	
	

}
