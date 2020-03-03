package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.vo.BaseVO;

/**
 * Created by ChenYouhuo on 2016/5/16.
 */
public class UserOptStkNewsVO extends BaseVO {

    private static final long serialVersionUID = 5255121300230151494L;
    private Integer count=20;
    private Integer newsId;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }
}
