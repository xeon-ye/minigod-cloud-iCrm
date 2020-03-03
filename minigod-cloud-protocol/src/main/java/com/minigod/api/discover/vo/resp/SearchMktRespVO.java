package com.minigod.api.discover.vo.resp;

import com.minigod.api.discover.vo.resp.DiscInduVO;

import java.io.Serializable;
import java.util.List;


public class SearchMktRespVO implements Serializable {

	private static final long serialVersionUID = 1L;

	// 概念集
	private List<DiscLabelVO> ccts;
	private String ccts_end;
	// 股票集
	private List<DiscAssetLVO> stks;
	private String stks_end;
	//行业集
	private List<DiscInduVO> indus;
	private String indus_end;
	
	public List<DiscLabelVO> getCcts() {
		return ccts;
	}
	
	public void setCcts(List<DiscLabelVO> ccts) {
		this.ccts = ccts;
	}
	
	public List<DiscAssetLVO> getStks() {
		return stks;
	}
	public void setStks(List<DiscAssetLVO> stks) {
		this.stks = stks;
	}
	
	public List<DiscInduVO> getIndus() {
		return indus;
	}
	
	public void setIndus(List<DiscInduVO> indus) {
		this.indus = indus;
	}

	public String getCcts_end() {
		return ccts_end;
	}

	public void setCcts_end(String ccts_end) {
		this.ccts_end = ccts_end;
	}

	public String getStks_end() {
		return stks_end;
	}

	public void setStks_end(String stks_end) {
		this.stks_end = stks_end;
	}

	public String getIndus_end() {
		return indus_end;
	}

	public void setIndus_end(String indus_end) {
		this.indus_end = indus_end;
	}
	
	
}
