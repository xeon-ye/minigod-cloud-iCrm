package com.minigod.common.events;

import com.minigod.common.forkjoin.ILifeCycle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 事件调度器
 */

public class EventDispatch implements ILifeCycle {

    private final static Logger _logger = LoggerFactory.getLogger(EventDispatch.class);

    protected Map<String, Delegator> _eventMap = new HashMap<String, Delegator>();

    protected AtomicBoolean _isStarted = new AtomicBoolean(false);

    private static EventDispatch _instance = new EventDispatch();

    private EventDispatch() {
    }

    public static EventDispatch getInstance() {
        return _instance;
    }

    /**
     * 根据事件类型分发事件。所有注册监听该事件的监听器将被通知。
     *
     * @param event 事件
     */
    public void dispatch(Event event) {
        if (_logger.isDebugEnabled()) {
            _logger.debug("dispatch event:" + event);
        }

        Delegator delegator = _eventMap.get(event.getEventType());
        if (null != delegator) {
            delegator.fire(event);
        } else {
            _logger.warn(String.format("event %s has no listener", event.toString()));
        }
    }

    /**
     * 获取事件及其监听器列表的历遍器
     *
     * @return 事件及其监听器列表的历遍器
     */
    public Iterator<Entry<String, Delegator>> iterator() {
        return _eventMap.entrySet().iterator();
    }


    public void destroy() {
        // 先关闭所有的事件
        for (Iterator<Entry<String, Delegator>> iterator = iterator(); iterator.hasNext(); ) {
            Entry<String, Delegator> entry = iterator.next();
            entry.getValue().destroy();
        }

        // 再关闭线程池
        //ThreadPoolim.destroy();

        _isStarted.set(false);
    }

    public void init() {

    }

    public void destroy(String threadPoolName) {

    }

    public void destroyAll() {

    }
}
