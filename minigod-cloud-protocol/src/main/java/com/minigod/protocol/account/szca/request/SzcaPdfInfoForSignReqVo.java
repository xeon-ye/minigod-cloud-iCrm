package com.minigod.protocol.account.szca.request;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SzcaPdfInfoForSignReqVo implements Serializable {
    private static final long serialVersionUID = 1L;


    private String userName; // 用户名称
    private String idCode; // 用户身份证号码
    private String certDn; // 用户证书主题
    private String certSn; // 用户证书序列号
    private String signImg;
    private Integer sealType = 1; // 1:普通签章, 2:批量签章 3:骑缝章 10:以数组形式的位置信息盖章(当参数为10时,下面四个参数可以不传(节点保留,值为空串)，只用传入locations 数组即口)
    private Integer startPageNo = 1; // 起始页码
    private Integer endPageNo = 1; // 结束页码
    private Integer x = 100;
    private Integer y = 100;
    private Integer xDpi = 0;
    private Integer yDpi = 0;
    private List<SzcaPdfInfoForSignLocationsVo> locations;


}
