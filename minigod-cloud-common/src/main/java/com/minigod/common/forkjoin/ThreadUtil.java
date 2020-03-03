package com.minigod.common.forkjoin;


/**
 * @Title: ThreadUtil.java
 * @Description: 线程实用操作方法
 * @Copyright:  2016 minigod
 * @Company: minigod
 *
 * @author
 * @date 2015-3-26 下午2:59:55
 * @version v1.0
 */

public class ThreadUtil {

    /**
     * 获取当前线程的Top Level线程组
     */
	public static ThreadGroup getRootThreadGroup() {
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        while (null != threadGroup.getParent()) {
            threadGroup = threadGroup.getParent();
        }
        return threadGroup;
    }
}
