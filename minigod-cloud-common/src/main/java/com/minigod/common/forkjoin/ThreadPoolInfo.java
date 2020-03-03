package com.minigod.common.forkjoin;

import java.io.Serializable;

/**
 * @Title: ThreadPoolInfo.java
 * @Description: 初始化线程数据
 * @Copyright:  2016 minigod
 * @Company: minigod
 *
 * @author
 * @date 2015-3-15 下午4:53:37
 * @version v1.0
 */

public class ThreadPoolInfo implements Serializable {

	private static final long serialVersionUID = 8994270363831737712L;

	// 线程池名称
	private String name = ThreadPool.DEFAULT_THREAD_POOL;
	// 核心线程数
	private int coreSize = 5;
	// 最大线程数
	private int maxSize = 30;
	// 线程空闲的生存时间单位:秒
	private long threadKeepAliveTime = 15;
	// 线程池队列的容量
	private int queueSize = 1000;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCoreSize() {
		return coreSize;
	}

	public void setCoreSize(int coreSize) {
		this.coreSize = coreSize;
	}

	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	public long getThreadKeepAliveTime() {
		return threadKeepAliveTime;
	}

	public void setThreadKeepAliveTime(long threadKeepAliveTime) {
		this.threadKeepAliveTime = threadKeepAliveTime;
	}

	public int getQueueSize() {
		return queueSize;
	}

	public void setQueueSize(int queueSize) {
		this.queueSize = queueSize;
	}

	public ThreadPoolInfo() {
	}

	public ThreadPoolInfo(String name) {
		super();
		this.name = name;
	}

	public ThreadPoolInfo(String name, int coreSize, int maxSize, long threadKeepAliveTime, int queueSize) {
		super();
		this.name = name;
		this.coreSize = coreSize;
		this.maxSize = maxSize;
		this.threadKeepAliveTime = threadKeepAliveTime;
		this.queueSize = queueSize;
	}
}
