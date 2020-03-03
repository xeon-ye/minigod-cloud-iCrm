package com.minigod.storage.protocol.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class SysStorage implements Serializable {
    private Integer id;

    /**
     * 文件的唯一索引
     */
    private String key;

    /**
     * 文件名
     */
    private String name;

    /**
     * 文件类型
     */
    private String type;

    /**
     * 文件大小
     */
    private Integer size;

    /**
     * 文件访问链接
     */
    private String url;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}