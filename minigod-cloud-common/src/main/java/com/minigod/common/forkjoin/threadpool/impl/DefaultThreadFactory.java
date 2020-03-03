package com.minigod.common.forkjoin.threadpool.impl;

import com.minigod.common.forkjoin.ThreadUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author
 * @version v1.0
 * @Title: DefaultThreadFactory.java
 * @Description: 默认线程池工厂, 基于线程分组
 * @Copyright: 2016 minigod
 * @Company: minigod
 * @date 2015-3-15 下午4:53:37
 */

public class DefaultThreadFactory implements ThreadFactory {

    private static Logger logger = LoggerFactory.getLogger(DefaultThreadFactory.class);

    private AtomicInteger number = new AtomicInteger(1);

    private ThreadGroup threadGroup;

    public DefaultThreadFactory() {
        this("yiminigod");
    }

    public DefaultThreadFactory(String namePrefix) {
        ThreadGroup root = ThreadUtil.getRootThreadGroup();
        threadGroup = new ThreadGroup(root, namePrefix + "-pool");
        //
        threadGroup.setDaemon(true);
    }

    public Thread newThread(Runnable r) {
        Thread thread = new Thread(threadGroup, r);
        thread.setName(threadGroup.getName() + "-" + number.getAndIncrement());

        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (Thread.NORM_PRIORITY != thread.getPriority()) {
            thread.setPriority(Thread.NORM_PRIORITY);
        }
        if (logger.isDebugEnabled()) {
            logger.debug(String.format("initialization a new thread %s to thread group.", threadGroup.getName() + "-" + number.getAndIncrement()));
        }
        return thread;
    }
}
