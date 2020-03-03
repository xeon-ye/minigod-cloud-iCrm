package com.minigod.api.mktinfo.vo;

import com.minigod.protocol.MktStaticType;
import com.minigod.protocol.StaticType;

public class MktException extends RuntimeException {
	private static final long serialVersionUID = -4157675170325821600L;
	/** 自定义的错误消息 */
	private String custErrMsg;
	/**  */
	private MktStaticType.CodeType codeType;

	private StaticType.CodeType commCodeType;
	/**
	 * @param codeType
	 */
	public MktException(MktStaticType.CodeType codeType) {
		this(codeType, null);
	}
	/**
	 * @param codeType
	 * @param sMsg
	 */
	public MktException(MktStaticType.CodeType codeType, String sMsg) {
		this.codeType = codeType;
		custErrMsg = sMsg;
	}
	/**
	 * @param codeType
	 */
	public MktException(StaticType.CodeType codeType) {
		this(codeType, null);
	}
	/**
	 * @param codeType
	 * @param sMsg
	 */
	public MktException(StaticType.CodeType codeType, String sMsg) {
		commCodeType = codeType;
		custErrMsg = sMsg;
	}
	/**
	 * 错误码
	 * 
	 * @return
	 */
	public int getErrCode() {
		if (codeType != null) {
			return codeType.getCode();
		}
		return commCodeType.getCode();
	}
	/**
	 * 错误信息
	 * 
	 * @return
	 */
	public String getErrMsg() {
		if (custErrMsg != null) {
			return custErrMsg;
		}
		if (codeType != null) {
			return codeType.getErrorMsg();
		}
		return commCodeType.getMessage();
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Throwable#toString()
	 */
	public String toString() {
		String sContent = getErrCode() + ":" + getErrMsg() + "\n" + super.toString();
		return sContent;
	}
}
