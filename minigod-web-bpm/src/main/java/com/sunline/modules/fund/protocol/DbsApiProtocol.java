package com.sunline.modules.fund.protocol;

import com.sunline.modules.common.pojo.rest.BaseParameter;
import com.sunline.modules.fund.protocol.dbs.api.Header;
import com.sunline.modules.fund.protocol.dbs.api.TxnInfo;
import lombok.Data;

/**
 * @description: DBS API服务协议
 * @author: Larry Lai
 * @date: 2020/3/2 13:47
 * @version: v1.0
 */

@Data
public class DbsApiProtocol extends BaseParameter {

    private static final long serialVersionUID = -6016628488121317135L;

    private Header header;

    private TxnInfo txnInfo;

}
