package com.sunline.modules.account.online.model;

import com.minigod.common.pojo.request.BaseRequestParams;

import java.io.Serializable;
import java.util.List;

public class SendEmailModel extends BaseRequestParams implements Serializable {
    private String sendTo;
    private String sendFrom;
    private String subject;
    private String content;
    private List<String> paths;

    public String getSendTo() {
        return sendTo;
    }

    public void setSendTo(String sendTo) {
        this.sendTo = sendTo;
    }

    public String getSendFrom() {
        return sendFrom;
    }

    public void setSendFrom(String sendFrom) {
        this.sendFrom = sendFrom;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getPaths() {
        return paths;
    }

    public void setPaths(List<String> paths) {
        this.paths = paths;
    }
}
