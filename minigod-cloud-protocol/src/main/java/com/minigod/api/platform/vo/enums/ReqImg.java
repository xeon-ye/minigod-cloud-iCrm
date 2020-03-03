package com.minigod.api.platform.vo.enums;

import java.io.Serializable;

import com.minigod.api.vo.BaseVO;

public class ReqImg extends BaseVO implements Serializable  {

	private static final long serialVersionUID = 7049754063884151898L;

	private String fileName;
	private String content;
	private String path;

	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	

}
