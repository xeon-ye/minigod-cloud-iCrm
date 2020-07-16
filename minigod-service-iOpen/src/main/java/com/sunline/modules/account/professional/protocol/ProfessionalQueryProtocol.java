package com.sunline.modules.account.professional.protocol;

import com.sunline.modules.common.pojo.rest.BaseParameter;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProfessionalQueryProtocol extends BaseParameter {
    private static final long serialVersionUID = 5643282110965780507L;

    //交易帐号
    private String clientId;
//    //资金帐号
//    private String fundAccount;

    //开始日期
    private String stDate;

    //结束日期
    private String edDate;

}
