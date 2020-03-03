/**
 * @Title: MarketIndexRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.resp;

import java.io.Serializable;
import java.util.List;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2015-8-27 下午9:32:45
 * @version v1.0
 */

public class MarketIndexRespVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long ts;
	private List<List<Object>> indus;
	private List<List<Object>> labs;
	private List<List<Object>> stks;
	private List<List<Object>> idxs;
	private List<List<Object>> usChStks;
	private List<List<Object>> usHotStks;
	private List<List<Object>> usTechStks;
	private List<List<Object>> mainBoardStks;
	private List<List<Object>> gemStks;
	private List<List<Object>> downStks;
	
	private List<List<Object>> hgtStks;//沪股通
	private List<List<Object>> sgtStks;//深股通
	private List<List<Object>> ggtStks;//港股通(沪/深)
	private List<List<Object>> ahStks;//AH股(沪/深)
	private List<List<Object>> surplus;//剩余
	
	private List<Object> jfFintechTitles;


	public List<List<Object>> getDownStks() {
		return downStks;
	}

	public void setDownStks(List<List<Object>> downStks) {
		this.downStks = downStks;
	}

	public Long getTs() {
		return ts;
	}

	public void setTs(Long ts) {
		this.ts = ts;
	}

	public List<List<Object>> getIndus() {
		return indus;
	}

	public void setIndus(List<List<Object>> indus) {
		this.indus = indus;
	}

	public List<List<Object>> getLabs() {
		return labs;
	}

	public void setLabs(List<List<Object>> labs) {
		this.labs = labs;
	}

	public List<List<Object>> getStks() {
		return stks;
	}

	public void setStks(List<List<Object>> stks) {
		this.stks = stks;
	}

	public List<List<Object>> getIdxs() {
		return idxs;
	}

	public void setIdxs(List<List<Object>> idxs) {
		this.idxs = idxs;
	}

	public List<List<Object>> getUsChStks() {
		return usChStks;
	}

	public void setUsChStks(List<List<Object>> usChStks) {
		this.usChStks = usChStks;
	}

	public List<List<Object>> getUsHotStks() {
		return usHotStks;
	}

	public void setUsHotStks(List<List<Object>> usHotStks) {
		this.usHotStks = usHotStks;
	}

	public List<List<Object>> getUsTechStks() {
		return usTechStks;
	}

	public void setUsTechStks(List<List<Object>> usTechStks) {
		this.usTechStks = usTechStks;
	}

	public List<List<Object>> getMainBoardStks() {
		return mainBoardStks;
	}

	public void setMainBoardStks(List<List<Object>> mainBoardStks) {
		this.mainBoardStks = mainBoardStks;
	}

	public List<List<Object>> getGemStks() {
		return gemStks;
	}

	public void setGemStks(List<List<Object>> gemStks) {
		this.gemStks = gemStks;
	}

	public List<List<Object>> getHgtStks() {
		return hgtStks;
	}

	public void setHgtStks(List<List<Object>> hgtStks) {
		this.hgtStks = hgtStks;
	}

	public List<List<Object>> getSgtStks() {
		return sgtStks;
	}

	public void setSgtStks(List<List<Object>> sgtStks) {
		this.sgtStks = sgtStks;
	}

	public List<List<Object>> getGgtStks() {
		return ggtStks;
	}

	public void setGgtStks(List<List<Object>> ggtStks) {
		this.ggtStks = ggtStks;
	}

	public List<List<Object>> getAhStks() {
		return ahStks;
	}

	public void setAhStks(List<List<Object>> ahStks) {
		this.ahStks = ahStks;
	}

	public List<List<Object>> getSurplus() {
		return surplus;
	}

	public void setSurplus(List<List<Object>> surplus) {
		this.surplus = surplus;
	}

	public List<Object> getJfFintechTitles() {
		return jfFintechTitles;
	}

	public void setJfFintechTitles(List<Object> jfFintechTitles) {
		this.jfFintechTitles = jfFintechTitles;
	}
	

}
