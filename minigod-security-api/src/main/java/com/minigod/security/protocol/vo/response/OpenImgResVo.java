package com.minigod.security.protocol.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OpenImgResVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer imgId;
    private String imgUrl;
    private String location; // 图片类型坐标
    private String type; // 图片类型
}

