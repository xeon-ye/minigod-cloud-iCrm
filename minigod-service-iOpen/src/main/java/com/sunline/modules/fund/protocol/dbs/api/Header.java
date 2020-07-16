package com.sunline.modules.fund.protocol.dbs.api;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: TODO
 * @author: Larry Lai
 * @date: 2020/3/2 14:34
 * @version: v1.0
 */

@Data
public class Header implements Serializable {

    private static final long serialVersionUID = -6016628488122917135L;

    private String msgId;
    private String orgId;
    private String timeStamp;
    private String ctry;
}
