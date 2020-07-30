package com.minigod.protocol.account.szca.jfrequest;

import com.minigod.protocol.account.szca.request.SzcaPdfInfoForSignLocationsVo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class JFSzcaPdfInfoForSignReqVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String utoken;

    private String userName; // 用户名称
    private String idNo; // 用户身份证号码
    private String certDn; // 用户证书主题
    private String certSn; // 用户证书序列号
    private String openAccountPdfUrl; // 文件的网络路径
    private String signImg;// 非必需
    private Integer sealType = 1; // 1:普通签章, 2:批量签章 3:骑缝章 10:以数组形式的位置信息盖章(当参数为10时,下面四个参数可以不传(节点保留,值为空串)，只用传入locations 数组即口)
    private Integer startPageNo = 1; // 起始页码
    private Integer endPageNo = 1; // 结束页码
    private Integer x = 100;
    private Integer y = 100;
    private Integer xDpi = 0;
    private Integer yDpi = 0;
    private List<SzcaPdfInfoForSignLocationsVo> locations;


}
