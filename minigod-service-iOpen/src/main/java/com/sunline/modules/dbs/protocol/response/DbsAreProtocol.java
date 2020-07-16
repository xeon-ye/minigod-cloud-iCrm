package com.sunline.modules.dbs.protocol.response;

import com.sunline.modules.common.pojo.rest.BaseParameter;
import com.sunline.modules.fund.protocol.dbs.api.Header;
import lombok.Data;

import java.util.List;

/**
 * ARE响应类
 * @author Administrator
 */
@Data
public class DbsAreProtocol extends BaseParameter {
        private String drCrInd;
        private String txnCode;
        private String txnDesc;
        private String txnDate;
        private String valueDate;
        private String txnCcy;
        private String txnAmount;

}
