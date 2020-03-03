package com.minigod.api.user.vo.request;

import com.minigod.api.vo.BaseVO;

/**
 * Created by ChenYouhuo on 2016/5/11.
 */

public class MyFavVO extends BaseVO {
    private static final long serialVersionUID = 6200351400913350841L;
    private String title;
    private String url;
    private String busiPkId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBusiPkId() {
        return busiPkId;
    }

    public void setBusiPkId(String busiPkId) {
        this.busiPkId = busiPkId;
    }

}
