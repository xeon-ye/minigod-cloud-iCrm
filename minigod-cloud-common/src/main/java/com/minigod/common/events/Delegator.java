package com.minigod.common.events;

import com.minigod.common.forkjoin.ILifeCycle;
import com.minigod.common.forkjoin.ThreadPool;
import com.minigod.common.forkjoin.ThreadPoolInfo;
import com.minigod.common.forkjoin.threadpool.impl.ThreadPoolImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 接受事件委托人（中介）
 */
public class Delegator implements ILifeCycle {

    private final static Logger logger = LoggerFactory.getLogger(Delegator.class);

    private ThreadPool _threadPool = new ThreadPoolImpl(new ThreadPoolInfo());

    protected List<EventListener> _listeners = new ArrayList<EventListener>();
    protected boolean _needClone = true;

    public Delegator() {

    }

    public void init() {
        for (Iterator<EventListener> iterator = iterator(); iterator.hasNext(); ) {
            EventListener listener = (EventListener) iterator.next();
            listener.init();
        }
    }

    /**
     * 注册事件监听器
     *
     * @param listener 事件监听器
     * @return 注册成功返回true；注册失败返回false
     */
    public boolean addListener(EventListener listener) {
        return _listeners.add(listener);
    }

    /**
     * 移除事件监听器
     *
     * @param listener 事件监听器
     * @return 移除成功返回true；移除失败返回false
     */
    public boolean removeListener(EventListener listener) {
        return _listeners.remove(listener);
    }

    /**
     * 获取监听器数量
     *
     * @return 监听器数量
     */
    public int getListenerCount() {
        return _listeners.size();
    }

    /**
     * 通知所有注册的事件监听器处理事件
     *
     * @param event 事件及其数据
     */
    public void fire(final Event event) {
        for (final EventListener listener : _listeners) {
            _threadPool.submit(new Task(listener, event, _needClone), listener.getThreadPoolName());
        }
    }

    /**
     * 返回事件监听器列表的历遍器
     *
     * @return 事件监听器列表的历遍器
     */
    public Iterator<EventListener> iterator() {
        return _listeners.iterator();
    }

    /**
     * 获取事件在分派时是否clone一份交给事件监听器
     *
     * @return 事件在分派时是否clone一份交给事件监听器
     */
    public boolean isNeedClone() {
        return _needClone;
    }

    public void setNeedClone(boolean needClone) {
        _needClone = needClone;
    }

    public void destroy() {
        for (Iterator<EventListener> iterator = iterator(); iterator.hasNext(); ) {
            EventListener listener = iterator.next();
            listener.destroy();
        }
    }

    /**
     * 线程池任务
     */
    private static class Task implements Runnable {

        private EventListener _listener;

        private Event _event;

        private boolean _needClone; // 将clone的工作放在线程中执行可以充分地利用多核，提升效率

        public Task(EventListener listener, Event event, boolean needClone) {
            _listener = listener;
            _event = event;
            _needClone = needClone;
        }

        public void run() {
            try {
                if (_needClone) {
                    _listener.execute(_event.clone());
                } else {
                    _listener.execute(_event);
                }
            } catch (Exception e) {
                logger.error(String.format("execute listener %s occurs handler", this._listener.getClass().getSimpleName()), e);
            }
        }

        public String toString() {
            if (null == this._event) {
                return "null";
            }

            return this._event.toString();
        }
    }

    public void destroy(String threadPoolName) {

    }

    public void destroyAll() {

    }
}
