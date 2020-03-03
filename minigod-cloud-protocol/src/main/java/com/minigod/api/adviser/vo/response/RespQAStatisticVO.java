package com.minigod.api.adviser.vo.response;

import java.io.Serializable;

/**
 * 某个投顾的问答数据统计返回
 */
public class RespQAStatisticVO  implements Serializable{

	private static final long serialVersionUID = 340831528495266018L;
	
	private Integer total; //总问答量
	
	private Integer dayTotal; //今日问答量
	
	private String satisfiedRate; //总满意度
	
	private Integer signContractNum; //问答签约量

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getDayTotal() {
		return dayTotal;
	}

	public void setDayTotal(Integer dayTotal) {
		this.dayTotal = dayTotal;
	}

	public String getSatisfiedRate() {
		return satisfiedRate;
	}

	public void setSatisfiedRate(String satisfiedRate) {
		this.satisfiedRate = satisfiedRate;
	}

	public Integer getSignContractNum() {
		return signContractNum;
	}

	public void setSignContractNum(Integer signContractNum) {
		this.signContractNum = signContractNum;
	}
	
}
