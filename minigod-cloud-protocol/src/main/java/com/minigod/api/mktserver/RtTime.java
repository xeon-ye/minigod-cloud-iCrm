/**
 * @Title: RtTime.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktserver;

import java.io.Serializable;

/**
 * <code>RtTime</code>
 *
 * @author Jimmy
 * @date 2015-7-3 下午4:02:11
 * @version v1.0
 */

public class RtTime implements Serializable {
	private static final long serialVersionUID = -9152923269922880242L;

	private String time;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
