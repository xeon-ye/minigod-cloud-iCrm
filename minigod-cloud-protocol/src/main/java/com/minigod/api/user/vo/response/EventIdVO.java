package com.minigod.api.user.vo.response;

import java.io.Serializable;

public class EventIdVO implements Serializable {

	private static final long serialVersionUID = -7315374019150684748L;

	private Long eventId;//验证码事件ID

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

}
