package com.minigod.api.discover.vo.resp;

import java.io.Serializable;

/**
 * <code>DiscLabelNewsRespVO<code>
 *
 * @author Jane
 * @since MiniGod v0.0.1 (2014-12-06)
 *
 */
public class DiscLabelNewsRespVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer cId; // 概念ID
	private String cName;// 概念名
	private Integer id;// 事件ID
	private String title;// 事件标题
	private String from;// 事件来源
	private Long time;// 事件时间
	private Integer stkNum;// 相关股票数量
	private Integer evtNum;// 相关事件数量
	/**
	 * @return the cId
	 */
	public Integer getcId() {
		return cId;
	}
	/**
	 * @param cId the cId to set
	 */
	public void setcId(Integer cId) {
		this.cId = cId;
	}
	/**
	 * @return the cName
	 */
	public String getcName() {
		return cName;
	}
	/**
	 * @param cName the cName to set
	 */
	public void setcName(String cName) {
		this.cName = cName;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}
	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * @return the stkNum
	 */
	public Integer getStkNum() {
		return stkNum;
	}
	/**
	 * @param stkNum the stkNum to set
	 */
	public void setStkNum(Integer stkNum) {
		this.stkNum = stkNum;
	}
	/**
	 * @return the time
	 */
	public Long getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(Long time) {
		this.time = time;
	}
	/**
	 * @return the evtNum
	 */
	public Integer getEvtNum() {
		return evtNum;
	}
	/**
	 * @param evtNum the evtNum to set
	 */
	public void setEvtNum(Integer evtNum) {
		this.evtNum = evtNum;
	}
	
	
}
