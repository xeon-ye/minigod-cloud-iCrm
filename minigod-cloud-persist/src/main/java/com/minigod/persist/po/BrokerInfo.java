package com.minigod.persist.po;
import com.minigod.persist.tables.TBrokerInfo;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 券商基本信息表
 */
@Entity(table=TBrokerInfo.class)
public class BrokerInfo implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer brokerId;//券商ID;人工编制，非自增长字段;100041-大陆国信证券
	private String regionCode;
	private String brokerCode;
	private String shortName;
	private String fullName;
	private String brokerIcon;
	private Integer channelId;//交易渠道;该券商目前所用的渠道，如iTN、国信直连等
	private String channelBrkCode;//渠道券商编码
	private String funcList;//每一位都用Y/N表示是否开通：第1位：是否允许交易,第2位：是否允许跳转开户,第3位：当前是否有营销活动,第4位：是否允许通过服务器登录
	private String sptLoginAcc;//可用登录账号类型,表示该券商支持的类型，包含则支持，如12和21都表示支持客户号和资金账号登录：1：支持客户号登录,2：支持资金账号登录,3：支持深A股东账号登录,4：支持沪A股东账号登录,5：支持深B股东账号登录,6：支持沪B股东账号登录
	private Boolean isNeedOpenid = true;//0-不需要，1-需要(默认)
	private Boolean isOrderServer = false;//0-不需要(默认)，1-需要
	private String iosVer;
	private String androidVer;
	private String iosOpenaccUrl;
	private String androidOpenaccUrl;
	private String marketingName;
	private String marketingUrl;
	private Boolean isStatus;//状态;0停用，1正常使用
	private Date createTime;//创建时间
	private Date updateTime;//最后修改时间
	private String appIosPackage;
	private String appAndroidPackage;
	private Integer isRedirectTrade;
	private String redirectIosAppUrl;
	private String redirectIosStoreUrl;
	private String redirectAndroidPackage;
	private String redirectAndroidActivity;
	private String androidDownloadUrl;

    public Integer getBrokerId () {
        return brokerId;
    }

    public void setBrokerId (Integer brokerId) {
        this.brokerId = brokerId;
    }

    public String getRegionCode () {
        return regionCode;
    }

    public void setRegionCode (String regionCode) {
        this.regionCode = regionCode;
    }

    public String getBrokerCode () {
        return brokerCode;
    }

    public void setBrokerCode (String brokerCode) {
        this.brokerCode = brokerCode;
    }

    public String getShortName () {
        return shortName;
    }

    public void setShortName (String shortName) {
        this.shortName = shortName;
    }

    public String getFullName () {
        return fullName;
    }

    public void setFullName (String fullName) {
        this.fullName = fullName;
    }

    public String getBrokerIcon () {
        return brokerIcon;
    }

    public void setBrokerIcon (String brokerIcon) {
        this.brokerIcon = brokerIcon;
    }

    public Integer getChannelId () {
        return channelId;
    }

    public void setChannelId (Integer channelId) {
        this.channelId = channelId;
    }

    public String getChannelBrkCode () {
        return channelBrkCode;
    }

    public void setChannelBrkCode (String channelBrkCode) {
        this.channelBrkCode = channelBrkCode;
    }

    public String getFuncList () {
        return funcList;
    }

    public void setFuncList (String funcList) {
        this.funcList = funcList;
    }

    public String getSptLoginAcc () {
        return sptLoginAcc;
    }

    public void setSptLoginAcc (String sptLoginAcc) {
        this.sptLoginAcc = sptLoginAcc;
    }

    public Boolean getIsNeedOpenid () {
        return isNeedOpenid;
    }

    public void setIsNeedOpenid (Boolean isNeedOpenid) {
        this.isNeedOpenid = isNeedOpenid;
    }

    public Boolean getIsOrderServer () {
        return isOrderServer;
    }

    public void setIsOrderServer (Boolean isOrderServer) {
        this.isOrderServer = isOrderServer;
    }

    public String getIosVer () {
        return iosVer;
    }

    public void setIosVer (String iosVer) {
        this.iosVer = iosVer;
    }

    public String getAndroidVer () {
        return androidVer;
    }

    public void setAndroidVer (String androidVer) {
        this.androidVer = androidVer;
    }

    public String getIosOpenaccUrl () {
        return iosOpenaccUrl;
    }

    public void setIosOpenaccUrl (String iosOpenaccUrl) {
        this.iosOpenaccUrl = iosOpenaccUrl;
    }

    public String getAndroidOpenaccUrl () {
        return androidOpenaccUrl;
    }

    public void setAndroidOpenaccUrl (String androidOpenaccUrl) {
        this.androidOpenaccUrl = androidOpenaccUrl;
    }

    public String getMarketingName () {
        return marketingName;
    }

    public void setMarketingName (String marketingName) {
        this.marketingName = marketingName;
    }

    public String getMarketingUrl () {
        return marketingUrl;
    }

    public void setMarketingUrl (String marketingUrl) {
        this.marketingUrl = marketingUrl;
    }

    public Boolean getIsStatus () {
        return isStatus;
    }

    public void setIsStatus (Boolean isStatus) {
        this.isStatus = isStatus;
    }

    public Date getCreateTime () {
        return createTime;
    }

    public void setCreateTime (Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime () {
        return updateTime;
    }

    public void setUpdateTime (Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getAppIosPackage () {
        return appIosPackage;
    }

    public void setAppIosPackage (String appIosPackage) {
        this.appIosPackage = appIosPackage;
    }

    public String getAppAndroidPackage () {
        return appAndroidPackage;
    }

    public void setAppAndroidPackage (String appAndroidPackage) {
        this.appAndroidPackage = appAndroidPackage;
    }

    public Integer getIsRedirectTrade () {
        return isRedirectTrade;
    }

    public void setIsRedirectTrade (Integer isRedirectTrade) {
        this.isRedirectTrade = isRedirectTrade;
    }

    public String getRedirectIosAppUrl () {
        return redirectIosAppUrl;
    }

    public void setRedirectIosAppUrl (String redirectIosAppUrl) {
        this.redirectIosAppUrl = redirectIosAppUrl;
    }

    public String getRedirectIosStoreUrl () {
        return redirectIosStoreUrl;
    }

    public void setRedirectIosStoreUrl (String redirectIosStoreUrl) {
        this.redirectIosStoreUrl = redirectIosStoreUrl;
    }

    public String getRedirectAndroidPackage () {
        return redirectAndroidPackage;
    }

    public void setRedirectAndroidPackage (String redirectAndroidPackage) {
        this.redirectAndroidPackage = redirectAndroidPackage;
    }

    public String getRedirectAndroidActivity () {
        return redirectAndroidActivity;
    }

    public void setRedirectAndroidActivity (String redirectAndroidActivity) {
        this.redirectAndroidActivity = redirectAndroidActivity;
    }

    public String getAndroidDownloadUrl () {
        return androidDownloadUrl;
    }

    public void setAndroidDownloadUrl (String androidDownloadUrl) {
        this.androidDownloadUrl = androidDownloadUrl;
    }
}