/**
 * @Title: BrokerLoginInfoVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.req;

import java.util.List;

import com.minigod.api.ptf.vo.enums.EOrderDirection;
import com.minigod.api.ptf.vo.enums.EOrderExchMkt;
import com.minigod.api.ptf.vo.enums.EOrderInServerFlag;
import com.minigod.api.ptf.vo.enums.EOrderProperty;
import com.minigod.api.ptf.vo.enums.real_ptf_trans.ERealPtfTransType;
import com.minigod.api.vo.BaseVO;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description 组合委托请求值对象
 *
 * @author 许德佑
 * @date 2015-3-10 上午9:19:34
 * @version v2.0
 */
@TransferBean
public class PtfRealOrderVO extends BaseVO {

	private static final long serialVersionUID = 1L;
	
	@TransferID
	private Long ptfId; // 组合编号
	
	private Integer brkId; // 券商ID
	
	private String custId; // 券商的客户ID
	
	private ERealPtfTransType ptfTransType; // 组合交易类型
	
	private EOrderInServerFlag sendFlag; //委托标志
	
	private Integer ptfVer;//组合委托对应组合版本号
	
	private List<PtfRealOrderStock> stks;//委托股票列表
	
	public Long getPtfId() {
		return ptfId;
	}

	public void setPtfId(Long ptfId) {
			this.ptfId = ptfId; 
	}

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

	public ERealPtfTransType getPtfTransType() {
		return ptfTransType;
	}

	public void setPtfTransType(ERealPtfTransType ptfTransType) {
		this.ptfTransType = ptfTransType;
	}

	public EOrderInServerFlag getSendFlag() {
		return sendFlag;
	}

	public void setSendFlag(EOrderInServerFlag sendFlag) {
		this.sendFlag = sendFlag;
	}
	
	public Integer getPtfVer() {
		return ptfVer;
	}

	public void setPtfVer(Integer ptfVer) {
		this.ptfVer = ptfVer;
	}

	public List<PtfRealOrderStock> getStks() {
		return stks;
	}

	public void setStks(List<PtfRealOrderStock> stks) {
		this.stks = stks;
	}

	public static class PtfRealOrderStock {
		String stkCode; //股票代码
		
		Double ordQty; //委托数量
		
		Double ordPrc; //委托价格
		
		EOrderDirection ordBS; //委托方向
		
		EOrderProperty ordProp; //委托属性
		
		String stkAcc; //股东账号
		
		EOrderExchMkt exchType; //交易市场
		

		public Double getOrdQty() {
			return ordQty;
		}

		public void setOrdQty(Double ordQty) {
			this.ordQty = ordQty;
		}

		public String getStkCode() {
			return stkCode;
		}

		public void setStkCode(String stkCode) {
			this.stkCode = stkCode;
		}

		public Double getOrdPrc() {
			return ordPrc;
		}

		public void setOrdPrc(Double ordPrc) {
			this.ordPrc = ordPrc;
		}

		public EOrderDirection getOrdBS() {
			return ordBS;
		}

		public void setOrdBS(EOrderDirection ordBS) {
			this.ordBS = ordBS;
		}

		public EOrderProperty getOrdProp() {
			return ordProp;
		}

		public void setOrdProp(EOrderProperty ordProp) {
			this.ordProp = ordProp;
		}

		public String getStkAcc() {
			return stkAcc;
		}

		public void setStkAcc(String stkAcc) {
			this.stkAcc = stkAcc;
		}

		public EOrderExchMkt getExchType() {
			return exchType;
		}

		public void setExchType(EOrderExchMkt exchType) {
			this.exchType = exchType;
		}

		
		
	}
	
	

}
