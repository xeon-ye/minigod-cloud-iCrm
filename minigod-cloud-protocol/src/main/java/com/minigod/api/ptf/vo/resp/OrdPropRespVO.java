package com.minigod.api.ptf.vo.resp;

import java.io.Serializable;
import java.util.List;


/**
 * @description 组合委托返回值对象
 *
 * @author 许德佑
 * @date 2015-3-16
 * @version v2.0
 */
public class OrdPropRespVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<String> rstMsgs;
	private String ordProp;
	
	
	public List<String> getRstMsgs() {
		return rstMsgs;
	}
	
	public void setRstMsgs(List<String> rstMsgs) {
		this.rstMsgs = rstMsgs;
	}
	
	
	public String getOrdProp() {
		return ordProp;
	}
	
	public void setOrdProp(String ordProp) {
		this.ordProp = ordProp;
	}
	
	

}
