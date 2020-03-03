package com.minigod.common.events;

import java.io.Serializable;

/**
 * 事件及其数据
 */
public class Event implements Cloneable, Serializable {

	private static final long serialVersionUID = 1525441397618531878L;

	private String eventType;

	private Object data;

	public Event() {

	}

	/**
	 * @param eventType 事件类型。
	 * @param data 事件附带的数据。如果是非原型数据类型，必须实现clone方法并且implements Cloneable接口
	 */
	public Event(String eventType, Object data) {
		this.eventType = eventType;
		this.data = data;
	}

	public String getEventType() {
		return eventType;
	}

	/**
	 * 设置事件类型
	 * 
	 * @param eventType 事件类型。
	 */
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	/**
	 * 获取事件附带的数据
	 * @return 事件附带的数据
	 */
	public Object getData() {
		return data;
	}

	/**
	 * 设置事件附带的数据
	 * @param data 事件附带的数据。如果是非原型数据类型，必须实现clone方法并且implements Cloneable接口
	 */
	public void setData(Object data) {
		this.data = data;
	}

	public Event clone() {
		Event event = new Event();
		event.setEventType(this.eventType);
		event.setData(this.data);
		return event;
	}
}
