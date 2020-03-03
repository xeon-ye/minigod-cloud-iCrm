/**
 * @Title: BrokerLoginInfoVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.req;

import java.io.Serializable;
import java.util.List;

import com.minigod.api.vo.BaseVO;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;

/**
 * @description 券商登录日志上传请求类
 *
 * @author minigod
 * @date 2015-3-10 上午9:19:34
 * @version v2.0
 */
@TransferBean
public class BrkLogInfoVO extends BaseVO {

	private static final long serialVersionUID = 1L;
	
	private Integer brkId; // 券商ID
	
	private String custId; // 券商端的客户编号
	@Emoji
	private String name; // 客户名称
	
	private String bind; // 本次登录是否制定绑定券商动作
	
	private String qnOpenId; // minigodopend_id
	
	private String tradeNode; // 交易节点号
	
	private String branchNo; // 机构代码
	
	private String ext; // 扩展属性
	
	private List<AccInfo> accInfo;

	public Integer getBrkId() {
		return brkId;
	}

	public void setBrkId(Integer brkId) {
		this.brkId = brkId;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBind() {
		return bind;
	}

	public void setBind(String bind) {
		this.bind = bind;
	}
	
	public String getQnOpenId() {
		return qnOpenId;
	}

	public void setQnOpenId(String qnOpenId) {
		this.qnOpenId = qnOpenId;
	}
	
	public List<AccInfo> getAccInfo() {
		return accInfo;
	}

	public void setAccInfo(List<AccInfo> AccInfo) {
		this.accInfo = AccInfo;
	}
	
	public String getTradeNode() {
		return tradeNode;
	}

	public void setTradeNode(String tradeNode) {
		this.tradeNode = tradeNode;
	}

	public String getBranchNo() {
		return branchNo;
	}

	public void setBranchNo(String branchNo) {
		this.branchNo = branchNo;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}
	
	/**
	 * 
	 * @description 用户股东账户信息类
	 *
	 * @author minigod
	 * @date 2015-3-10 上午9:31:12
	 * @version v2.0
	 */
	public static class AccInfo implements Serializable {

		private static final long serialVersionUID = 1L;
		
		private String dpstAcc; // 资金账号
		
		private String stkAcc; // 股东账号
		
		private String exchType; // 交易市场
		
		private String dpstAccType; // 资金账号类型

		public String getDpstAcc() {
			return dpstAcc;
		}

		public void setDpstAcc(String dpstAcc) {
			this.dpstAcc = dpstAcc;
		}

		public String getStkAcc() {
			return stkAcc;
		}

		public void setStkAcc(String stkAcc) {
			this.stkAcc = stkAcc;
		}
		
		public String getExchType() {
			return exchType;
		}

		public void setExchType(String exchType) {
			this.exchType = exchType;
		}

		public String getDpstAccType() {
			return dpstAccType;
		}

		public void setDpstAccType(String dpstAccType) {
			this.dpstAccType = dpstAccType;
		}
		
	}

}
