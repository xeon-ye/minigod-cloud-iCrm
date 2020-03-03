package com.minigod.common.events;

import com.minigod.common.forkjoin.ThreadPool;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 抽象事件监听器
 */

public abstract class AbstractEventListener implements EventListener {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 事件监听器运行时指定的线程池的名称
     */
    protected String threadPoolName;

    /**
     * 设置运行时的线程池为default
     */
    public AbstractEventListener() {
        threadPoolName = ThreadPool.DEFAULT_THREAD_POOL;
    }

    /**
     * @param threadPoolName 运行时的线程池名称
     */
    public AbstractEventListener(String threadPoolName) {
        if (StringUtils.isBlank(threadPoolName)) {
            throw new IllegalArgumentException("invalid thread-pool name:" + threadPoolName);
        }
        this.threadPoolName = threadPoolName;
    }

    public void setThreadPoolName(String threadPoolName) {
        this.threadPoolName = threadPoolName;
    }

    public String getThreadPoolName() {
        return threadPoolName;
    }

    public void init() {
        if (logger.isInfoEnabled()) {
            logger.info(String.format("event listener '%s' initialized", this.getClass().getSimpleName()));
        }
    }

    public void destroy() {
        if (logger.isInfoEnabled()) {
            logger.info(String.format("event listener '%s' destroyed", this.getClass().getSimpleName()));
        }
    }
}
