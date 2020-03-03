package com.minigod.protocol;

import java.io.Serializable;

/**
 * @Title: JobStatus.java
 * @Description: 
 * @Copyright:  2015 minigod
 * @Company: minigod
 *
 * @author ken
 * @date 2015-12-1 下午3:18:22
 * @version v1.0
 */

public class JobStatus implements Serializable {
	private static final long serialVersionUID = 1011406228024315768L;
	private String jobName;
	private Object obj;

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}
}
