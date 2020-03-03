/**
 * @Title: PtfWithdrawRequestVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.resp;

import java.util.List;

import com.minigod.api.user.vo.SNVersion;

/**
 * @description 模拟组合撤单请求返回值对象
 *
 * @author minigod
 * @date 2015-3-31 下午2:14:06
 * @version v1.0
 */

public class SimuPtfWithdrawRespVO extends SNVersion {

	private static final long serialVersionUID = 1L;
	
	private Long ptfTransId;
	
	private List<SimuPtfWithdrawRespVO_Ord> ords;
	
	public Long getPtfTransId() {
		return ptfTransId;
	}

	public void setPtfTransId(Long ptfTransId) {
		this.ptfTransId = ptfTransId;
	}

	
	public List<SimuPtfWithdrawRespVO_Ord> getOrds() {
		return ords;
	}

	public void setOrds(List<SimuPtfWithdrawRespVO_Ord> ords) {
		this.ords = ords;
	}


	public static class SimuPtfWithdrawRespVO_Ord{
		private String ordSeq;
		
		private String name;
		
		private String sucess;
		
		private String msg;

		public String getOrdSeq() {
			return ordSeq;
		}

		public void setOrdSeq(String ordSeq) {
			this.ordSeq = ordSeq;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getSucess() {
			return sucess;
		}

		public void setSucess(String sucess) {
			this.sucess = sucess;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

	}
	
	
	
}
