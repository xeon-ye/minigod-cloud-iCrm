package com.sunline.modules.account.professional.protocol;

import com.sunline.modules.common.pojo.rest.BaseParameter;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProfessionalApplyProtocol extends BaseParameter {
    private static final long serialVersionUID = 5643282110965780507L;
    //小神号
    private Integer userId;
    //交易帐号
    private String clientId;
    //资金帐号
    private String fundAccount;
    //资产组合1,2,3,4,逗号隔开
    private String portfolios;
    //申请时间
    private String applicationTime;
    //12个月内总资产
    private BigDecimal totalAssets;
    //12个月内总资产对应日期
    private String totalAssetsDate;
    //资产证明
    private List<String> assetsImgs;
    //补充证明
    private List<String> addImgs;

}
