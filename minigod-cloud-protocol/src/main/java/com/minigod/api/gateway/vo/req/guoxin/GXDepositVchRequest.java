/**
 * @Title: GXDepositVchRequest.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.gateway.vo.req.guoxin;

/**
 * @description 资金流水
 * 
 * @author Jimmy
 * @date 2015-3-12 下午1:55:24
 * @version v1.0
 */

public class GXDepositVchRequest extends GXRequest {
	private static final long serialVersionUID = 1L;
	// 起始日期
	private String strdate;
	// 终止日期
	private String enddate;
	// 重打标识
	private String printflag;
	// 查询方向
	private String qryflag;
	// 货币
	private String moneytype;
	// 信用产品标识
	private String creditid;
	// 信用委托类型
	private String creditflag;
	// 业务代码
	private String digestids;

	public String getStrdate() {
		return strdate;
	}

	public void setStrdate(String strdate) {
		this.strdate = strdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getPrintflag() {
		return printflag;
	}

	public void setPrintflag(String printflag) {
		this.printflag = printflag;
	}

	public String getQryflag() {
		return qryflag;
	}

	public void setQryflag(String qryflag) {
		this.qryflag = qryflag;
	}

	public String getMoneytype() {
		return moneytype;
	}

	public void setMoneytype(String moneytype) {
		this.moneytype = moneytype;
	}

	public String getCreditid() {
		return creditid;
	}

	public void setCreditid(String creditid) {
		this.creditid = creditid;
	}

	public String getCreditflag() {
		return creditflag;
	}

	public void setCreditflag(String creditflag) {
		this.creditflag = creditflag;
	}

	public String getDigestids() {
		return digestids;
	}

	public void setDigestids(String digestids) {
		this.digestids = digestids;
	}
}
