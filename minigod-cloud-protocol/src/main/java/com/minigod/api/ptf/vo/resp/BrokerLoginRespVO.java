/**
 * @Title: BrokerLoginRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.resp;

import java.io.Serializable;
import java.util.List;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2015-7-7 上午9:24:07
 * @version v1.0
 */

public class BrokerLoginRespVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String cId;// 客户号
	private String cnm;// 客户姓名
	private String dpsAcc;// 资金账号
	private List<BrokerAccountInfo> inf;// 股东账号信息

	public String getcId() {
		return cId;
	}

	public void setcId(String cId) {
		this.cId = cId;
	}

	public String getCnm() {
		return cnm;
	}

	public void setCnm(String cnm) {
		this.cnm = cnm;
	}

	public String getDpsAcc() {
		return dpsAcc;
	}

	public void setDpsAcc(String dpsAcc) {
		this.dpsAcc = dpsAcc;
	}

	public List<BrokerAccountInfo> getInf() {
		return inf;
	}

	public void setInf(List<BrokerAccountInfo> inf) {
		this.inf = inf;
	}



	public static class BrokerAccountInfo implements Serializable {
		private static final long serialVersionUID = 1L;

		private String acc;// 股东账号
		private String mkt;// 市场代码

		public String getAcc() {
			return acc;
		}

		public void setAcc(String acc) {
			this.acc = acc;
		}

		public String getMkt() {
			return mkt;
		}

		public void setMkt(String mkt) {
			this.mkt = mkt;
		}

	}
}
