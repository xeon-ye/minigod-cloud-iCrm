package com.minigod.api.solr;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ChenYouhuo on 2016/5/12.
 */
public class ILabelNewsInfoVO implements Serializable {
    private static final long serialVersionUID = 1520301891932295562L;
    private Integer newsId;
    private String title;
    private String date;
    private String stkCode;
    private String stkName;
    private String imgUrl;
    private Integer infotreeid;
    private String media;
    private Integer tag;
    

	public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStkCode() {
        return stkCode;
    }

    public void setStkCode(String stkCode) {
        this.stkCode = stkCode;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getInfotreeid() {
        return infotreeid;
    }

    public void setInfotreeid(Integer infotreeid) {
        this.infotreeid = infotreeid;
    }

    public String getStkName() {
        return stkName;
    }

    public void setStkName(String stkName) {
        this.stkName = stkName;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

	@Override
	public int hashCode() {
		int rs = infotreeid !=null?infotreeid:0;
		rs = 31*rs + (title != null ? title.hashCode() : 0);
		return rs;
	}

	@Override
	public boolean equals(Object obj) {
		ILabelNewsInfoVO vo = (ILabelNewsInfoVO)obj;
		return (infotreeid!=null ?infotreeid .equals(vo.getInfotreeid()): vo.getInfotreeid()==null) 
				&& (title!=null?title.equals(vo.getTitle()):vo.getTitle()==null);
	}
    
    
}
