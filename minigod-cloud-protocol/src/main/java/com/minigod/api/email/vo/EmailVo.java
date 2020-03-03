package com.minigod.api.email.vo;

import java.io.Serializable;

/**
 * @author kouyandong
 * @version v1.0
 * @description
 * @date 2016/4/19
 */
public class EmailVo implements Serializable {

    private static final long serialVersionUID = -550854840920226517L;

    private Integer userId;
    private String nickName;
    private String email;
    private String title;
    private String content;
    private String contentUrl;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }
}
