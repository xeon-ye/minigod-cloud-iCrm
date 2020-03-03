package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.vo.BaseVO;

/**
 * Created by huhu on 2016/8/13.
 */
public class MktPageVO extends BaseVO {

    private Integer count;// 拉取的条数，分页查询的话是每页的条数
    private String sortField;// 排序字段
    private String sortDir;// 排序方向
    private Integer page;//当前页

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getSortDir() {
        return sortDir;
    }

    public void setSortDir(String sortDir) {
        this.sortDir = sortDir;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
