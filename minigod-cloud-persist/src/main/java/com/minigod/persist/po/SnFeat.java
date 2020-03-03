package com.minigod.persist.po;
import com.minigod.persist.tables.TSnFeat;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;

/**
 * 功勋表
 */
@Entity(table=TSnFeat.class)
public class SnFeat implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer featId;//功勋id
	private String featName;
	private String featDescribe;//功勋描述
	private String featImage;//功勋图片地址

    public Integer getFeatId () {
        return featId;
    }

    public void setFeatId (Integer featId) {
        this.featId = featId;
    }

    public String getFeatName () {
        return featName;
    }

    public void setFeatName (String featName) {
        this.featName = featName;
    }

    public String getFeatDescribe () {
        return featDescribe;
    }

    public void setFeatDescribe (String featDescribe) {
        this.featDescribe = featDescribe;
    }

    public String getFeatImage () {
        return featImage;
    }

    public void setFeatImage (String featImage) {
        this.featImage = featImage;
    }
}