package com.minigod.security.protocol.vo.request.params;

import com.minigod.common.pojo.request.BaseRequestParams;
import lombok.Data;

import java.io.Serializable;

@Data
public class OpenImgReqParams extends BaseRequestParams implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer openType; // 开户类型
    private String imgType; // 图片信息
    private String imgBase64; // 图片信息
    private String location; // 图片类型坐标
    private String type; // 图片类型
}
