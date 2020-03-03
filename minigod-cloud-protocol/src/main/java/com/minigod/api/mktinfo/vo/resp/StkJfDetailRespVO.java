/**
 * @Title: StkLabelDetailRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.resp;

import java.io.Serializable;
import java.util.List;

/**
 * @description 行业详情返回对象
 *
 * @author 余俊斌
 * @date 2015年8月19日 下午9:29:38
 * @version v1.0
 */

public class StkJfDetailRespVO implements Serializable {

	private static final long serialVersionUID = -8632142344659195231L;


	private List<List<Object>> indexs;
	private String  title;
	private String  hisChg;
	private String  hisChgDes;
	private String  subTitle;
	public List<List<Object>> getIndexs() {
		return indexs;
	}
	public void setIndexs(List<List<Object>> indexs) {
		this.indexs = indexs;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getHisChg() {
		return hisChg;
	}
	public void setHisChg(String hisChg) {
		this.hisChg = hisChg;
	}
	public String getHisChgDes() {
		return hisChgDes;
	}
	public void setHisChgDes(String hisChgDes) {
		this.hisChgDes = hisChgDes;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	
}
