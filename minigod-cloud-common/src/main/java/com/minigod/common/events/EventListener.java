package com.minigod.common.events;

import com.minigod.common.forkjoin.ILifeCycle;


/**
 * 处理指定事件的事件监听器。事件监听器必须是无状态的
 * 因为监听器被初始化（调用默认的构造方法然后执行init方法进行初始化）后会一直持有这个实例处理事件
 * 如果处理过程中涉及到共享资源，需要考虑线程安全
 */
public interface EventListener extends ILifeCycle {
    
    /**
     * 处理事件
     * @param event 事件及附带的数据
     */
    public void execute(Event event);
    
    /**
     * 设置事件监听器运行时的线程池的名称。
     * @param threadPoolName 事件监听器运行时的线程池的名称。
     */
    public void setThreadPoolName(String threadPoolName);
    
    /**
     * 通过在配置文件event4j.xml中配置，每个事件监听器运行时可以指定在某一个线程池中执行，此方法用于获取事件监听器运行时指定的线程池的名称。
     * @return 事件监听器运行时指定的线程池的名称。
     */
    public String getThreadPoolName();
}
