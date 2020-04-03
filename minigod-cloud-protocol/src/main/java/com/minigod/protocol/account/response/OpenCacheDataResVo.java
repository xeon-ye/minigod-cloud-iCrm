package com.minigod.protocol.account.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
public class OpenCacheDataResVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer lastStep;
    private Object cacheInfos;
    private List<OpenImgResVo> cacheImages;

}
