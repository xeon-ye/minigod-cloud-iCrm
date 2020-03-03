
package com.minigod.api.mktinfo.vo.resp;

import java.io.Serializable;



public class StkNewsUserRespVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int readNum;
	private int laudNum;
	private boolean isFavorite;
	private boolean isLaud;
	
	public int getReadNum() {
		return readNum;
	}
	public void setReadNum(int readNum) {
		this.readNum = readNum;
	}
	public int getLaudNum() {
		return laudNum;
	}
	public void setLaudNum(int laudNum) {
		this.laudNum = laudNum;
	}
	public boolean isFavorite() {
		return isFavorite;
	}
	public void setFavorite(boolean isFavorite) {
		this.isFavorite = isFavorite;
	}
	public boolean isLaud() {
		return isLaud;
	}
	public void setLaud(boolean isLaud) {
		this.isLaud = isLaud;
	}

}
