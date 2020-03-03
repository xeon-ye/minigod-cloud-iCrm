package com.minigod.persist.po;
import com.minigod.persist.tables.TSysSensitiveWord;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TSysSensitiveWord.class)
public class SysSensitiveWord implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer wordId;
	private Integer type;//类型，1昵称，2言论
	private String word;//敏感词
	private Boolean isStatus = true;//是否有效（默认1有效，0无效）
	private Date createTime;//记录创建时间
	private Integer updVersion;//修改版本号
	private Date updateTime;//记录修改时间

    public Integer getWordId () {
        return wordId;
    }

    public void setWordId (Integer wordId) {
        this.wordId = wordId;
    }

    public Integer getType () {
        return type;
    }

    public void setType (Integer type) {
        this.type = type;
    }

    public String getWord () {
        return word;
    }

    public void setWord (String word) {
        this.word = word;
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

    public Integer getUpdVersion () {
        return updVersion;
    }

    public void setUpdVersion (Integer updVersion) {
        this.updVersion = updVersion;
    }

    public Date getUpdateTime () {
        return updateTime;
    }

    public void setUpdateTime (Date updateTime) {
        this.updateTime = updateTime;
    }
}