package com.sunline.modules.common.protocol;

/**
 * @author PENGFENG
 * @decription 上传文件公共bean
 * @date 2017/08/14
 */
public class CommonFileUploadRequest extends CommonWebAppRequest {

    private Long fileId; //文件ID
    private String fileName; // 文件名称
    private String content; //文件内容
    private String fileDescription; // 文件描述信息
    private String filePath; //文件路径
    private int filePathType; // 文件上传途径
    private String fileType; // 文件类型
    private String fileSize; // 文件大小

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFileDescription() {
        return fileDescription;
    }

    public void setFileDescription(String fileDescription) {
        this.fileDescription = fileDescription;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public int getFilePathType() {
        return filePathType;
    }

    public void setFilePathType(int filePathType) {
        this.filePathType = filePathType;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }
}
