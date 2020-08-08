package com.minigod.protocol.notify.model;

public class StatisticCall {
    private Integer id;

    private String moduleType;

    private Integer limit;

    private Integer useNumb;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModuleType() {
        return moduleType;
    }

    public void setModuleType(String moduleType) {
        this.moduleType = moduleType;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getUseNumb() {
        return useNumb;
    }

    public void setUseNumb(Integer useNumb) {
        this.useNumb = useNumb;
    }
}