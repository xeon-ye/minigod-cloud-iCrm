package com.minigod.persist.po;
import com.minigod.persist.tables.TInformCommonTemplate;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 模块公共信息表
 */
@Entity(table=TInformCommonTemplate.class)
public class InformCommonTemplate implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long id;//主键
	private Long busId;//业务类型ID
	private Integer tempCode;//模板类型编码
	private String title;//标题
	private String content;//内容
	private String applyExplain;//申请说明
	private Boolean isStatus = true;//是否有效(0-无效，1-有效)
	private Date createTime = new Date();//创建时间
	private Date updateTime = new Date();//更新时间
	private Integer msgType = 0;//短信类型

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public Long getBusId () {
        return busId;
    }

    public void setBusId (Long busId) {
        this.busId = busId;
    }

    public Integer getTempCode () {
        return tempCode;
    }

    public void setTempCode (Integer tempCode) {
        this.tempCode = tempCode;
    }

    public String getTitle () {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public String getContent () {
        return content;
    }

    public void setContent (String content) {
        this.content = content;
    }

    public String getApplyExplain () {
        return applyExplain;
    }

    public void setApplyExplain (String applyExplain) {
        this.applyExplain = applyExplain;
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

    public Integer getMsgType () {
        return msgType;
    }

    public void setMsgType (Integer msgType) {
        this.msgType = msgType;
    }
}