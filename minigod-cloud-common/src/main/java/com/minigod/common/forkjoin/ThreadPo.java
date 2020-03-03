package com.minigod.common.forkjoin;

import java.io.Serializable;
import java.util.concurrent.ExecutorService;

/**
 * @Title: ThreadPo.java
 * @Description: 
 * @Copyright:  2016 minigod
 * @Company: minigod
 *
 * @author
 * @date 2015-3-26 下午2:59:55
 * @version v1.0
 */

public class ThreadPo implements Serializable {

	private static final long serialVersionUID = -4633394737576006594L;

	private ExecutorService executorService;

	private ThreadPoolInfo threadPoolInfo;

	public ExecutorService getExecutorService() {
		return executorService;
	}

	public void setExecutorService(ExecutorService executorService) {
		this.executorService = executorService;
	}

	public ThreadPoolInfo getThreadPoolInfo() {
		return threadPoolInfo;
	}

	public void setThreadPoolInfo(ThreadPoolInfo threadPoolInfo) {
		this.threadPoolInfo = threadPoolInfo;
	}

	public ThreadPo() {
		super();
	}

	public ThreadPo(ExecutorService executorService, ThreadPoolInfo threadPoolInfo) {
		super();
		this.executorService = executorService;
		this.threadPoolInfo = threadPoolInfo;
	}
}
