package com.sunline.modules.account.online.model;


import java.io.Serializable;
import java.util.List;

public class SendEmailModel implements Serializable {
    private String sendTo;
    private String sendFrom;
    private String subject;
    private String content;
    private List<PathVO> paths;

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

    public List<PathVO> getPaths() {
        return paths;
    }

    public void setPaths(List<PathVO> paths) {
        this.paths = paths;
    }

    public static class PathVO {
        public String fileName;
        public String suffix;
        public String path;
    }
}
