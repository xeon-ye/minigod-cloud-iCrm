package com.minigod.api.user.vo.request.snjob;

import java.io.Serializable;

/**
 * @author 寇艳东
 * @version v1.0
 * @project: minigod
 * @description: 这里描述类的用处
 * @copyright: © 2016 minigod
 * @company: minigod
 * @date 2016/7/21 20:34
 */
public class UserAchieveResp implements Serializable {
    private static final long serialVersionUID = -1L;
    private Integer userAchieveId;
    private Integer userId;
    private Integer featId;//功勋id
    private Integer featValue;//经验值
    private Integer level;
    private String icon;
    private Integer featLevelEnd;//功勋等级结束值
    public Integer getUserAchieveId() {
        return userAchieveId;
    }

    public void setUserAchieveId(Integer userAchieveId) {
        this.userAchieveId = userAchieveId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFeatId() {
        return featId;
    }

    public void setFeatId(Integer featId) {
        this.featId = featId;
    }

    public Integer getFeatValue() {
        return featValue;
    }

    public void setFeatValue(Integer featValue) {
        this.featValue = featValue;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getFeatLevelEnd() {
        return featLevelEnd;
    }

    public void setFeatLevelEnd(Integer featLevelEnd) {
        this.featLevelEnd = featLevelEnd;
    }
}
