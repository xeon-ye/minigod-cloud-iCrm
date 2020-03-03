package com.minigod.common.forkjoin.ranges;

import java.io.Serializable;

/**
 * @Title: Range.java
 * @Description: 数的范围，用于记录整数和长整数的范围
 * @Copyright:  2016 minigod
 * @Company: minigod
 *
 * @author
 * @date 2015-3-13 下午4:53:37
 * @version v1.0
 */

public class Range<T> implements Serializable {

	private static final long serialVersionUID = 7309925006058785346L;

	/**
	 * 起始数
	 */
	private T start;

	/**
	 * 结束数
	 */
	private T end;

	public Range() {
		super();
	}

	public Range(T start, T end) {
		super();
		this.start = start;
		this.end = end;
	}

	public void setStart(T start) {
		this.start = start;
	}

	public void setEnd(T end) {
		this.end = end;
	}

	public T getStart() {
		return start;
	}

	public T getEnd() {
		return end;
	}
}