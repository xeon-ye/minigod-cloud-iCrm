package com.sunline.modules.account.online.model;

/**
 * @author LiYangFeng
 * @createDate 2018/4/26
 * @description
 * @email justbelyf@gmail.com
 */
public class FileInfo implements Comparable<FileInfo> {

    private int sort;
    private String fileName;
    private String fileUri;
    private String displayName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileUri() {
        return fileUri;
    }

    public void setFileUri(String fileUri) {
        this.fileUri = fileUri;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    @Override
    public int compareTo(FileInfo fileInfo) {
        if (sort > fileInfo.getSort()) {
            return 1;
        } else if (sort==fileInfo.getSort()) {
            return 0;
        }
        return -1;
    }


}
