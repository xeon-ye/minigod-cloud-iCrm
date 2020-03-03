package com.minigod.persist.po;
import com.minigod.persist.tables.THkAssetInfo;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;

/**
 * 
 */
@Entity(table=THkAssetInfo.class)
public class HkAssetInfo implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private String assetId;//资产ID
	private Integer corpId;//公司ID
	private Integer boardCode;//板块代码

    public String getAssetId () {
        return assetId;
    }

    public void setAssetId (String assetId) {
        this.assetId = assetId;
    }

    public Integer getCorpId () {
        return corpId;
    }

    public void setCorpId (Integer corpId) {
        this.corpId = corpId;
    }

    public Integer getBoardCode () {
        return boardCode;
    }

    public void setBoardCode (Integer boardCode) {
        this.boardCode = boardCode;
    }
}