/*******************************************************************************
 * Copyright (c) 2016 minigod minigod.Co.Ltd. All rights reserved.
 ******************************************************************************/

package com.minigod.api.ptf.vo.resp;

import java.io.Serializable;
import java.util.List;

public class BrokerListRespVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<BrokerListLoginVO> brks;
	private List<BrokerListRedirectVO> limitBrks;
	private AD ad;

	public AD getAd() {
		return ad;
	}

	public void setAd(AD ad) {
		this.ad = ad;
	}

	public List<BrokerListLoginVO> getBrks() {
		return brks;
	}

	public void setBrks(List<BrokerListLoginVO> brks) {
		this.brks = brks;
	}

	public List<BrokerListRedirectVO> getLimitBrks() {
		return limitBrks;
	}

	public void setLimitBrks(List<BrokerListRedirectVO> limitBrks) {
		this.limitBrks = limitBrks;
	}

	public static class BrokerListLoginVO implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private Integer brkId; // 券商ID
		private String brkName; // 券商名
		private String minVer; // 最低支持版本
		private String url; // 券商logo
		private String qnOpenId; // minigodOpenId
		private String srvLgn; // 是否通过服务器登录
		private String sptAccTyp; // 券商可用登录账号类型

		public Integer getBrkId() {
			return brkId;
		}

		public void setBrkId(Integer brkId) {
			this.brkId = brkId;
		}

		public String getBrkName() {
			return brkName;
		}

		public void setBrkName(String brkName) {
			this.brkName = brkName;
		}

		public String getMinVer() {
			return minVer;
		}

		public void setMinVer(String minVer) {
			this.minVer = minVer;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getQnOpenId() {
			return qnOpenId;
		}

		public void setQnOpenId(String qnOpenId) {
			this.qnOpenId = qnOpenId;
		}

		public String getSrvLgn() {
			return srvLgn;
		}

		public void setSrvLgn(String srvLgn) {
			this.srvLgn = srvLgn;
		}

		public String getSptAccTyp() {
			return sptAccTyp;
		}

		public void setSptAccTyp(String sptAccTyp) {
			this.sptAccTyp = sptAccTyp;
		}

	}

	public static class BrokerListRedirectVO implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private Integer brkId; // 券商ID
		private String brkName; // 券商名
		private String url; // 券商logo
		private String androidPackage;// 安卓包名
		private String androidActivity;// 安卓activity名
		private String iosRedirectUrl;// IOS跳转地址
		private String iosStoreUrl;// IOS APP STORE地址
		private String androidDownloadUrl;//安卓安装包下载地址
		

		public String getAndroidDownloadUrl() {
			return androidDownloadUrl;
		}

		public void setAndroidDownloadUrl(String androidDownloadUrl) {
			this.androidDownloadUrl = androidDownloadUrl;
		}

		public Integer getBrkId() {
			return brkId;
		}

		public void setBrkId(Integer brkId) {
			this.brkId = brkId;
		}

		public String getBrkName() {
			return brkName;
		}

		public void setBrkName(String brkName) {
			this.brkName = brkName;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getAndroidPackage() {
			return androidPackage;
		}

		public void setAndroidPackage(String androidPackage) {
			this.androidPackage = androidPackage;
		}

		public String getAndroidActivity() {
			return androidActivity;
		}

		public void setAndroidActivity(String androidActivity) {
			this.androidActivity = androidActivity;
		}

		public String getIosRedirectUrl() {
			return iosRedirectUrl;
		}

		public void setIosRedirectUrl(String iosRedirectUrl) {
			this.iosRedirectUrl = iosRedirectUrl;
		}

		public String getIosStoreUrl() {
			return iosStoreUrl;
		}

		public void setIosStoreUrl(String iosStoreUrl) {
			this.iosStoreUrl = iosStoreUrl;
		}

	}

	public static class AD implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String adText;// 广告文字
		private String adUrl;// 广告跳转地址

		public String getAdText() {
			return adText;
		}

		public void setAdText(String adText) {
			this.adText = adText;
		}

		public String getAdUrl() {
			return adUrl;
		}

		public void setAdUrl(String adUrl) {
			this.adUrl = adUrl;
		}

	}

}
