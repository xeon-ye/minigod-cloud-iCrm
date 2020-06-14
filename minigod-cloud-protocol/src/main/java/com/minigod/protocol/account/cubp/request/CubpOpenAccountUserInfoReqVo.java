package com.minigod.protocol.account.cubp.request;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class CubpOpenAccountUserInfoReqVo implements Serializable {
    private static final long serialVersionUID = -5117281934075876024L;
    // 用户号
    private Integer userId;
    //手机号码
    private String phoneNumber;
    // 交易账号
    private String tradeAccount;
    // 资金账号
    private String fundAccount;
    //开户时间
    private Date openAccountTime;
    // 中文姓名
    private String clientName;
    // 查询数量
    private int count = 20;
    // 渠道号
    private String sourceChannelId;
    // 开户开始时间
    private Date openAccountStartTime;
    // 开户结束时间
    private Date openAccountEndTime;
    // 邀请人
    private String inviterId;
    // 生日
    private String birthday;

    // 用户号（批量查询）
    private List<String> batchUserIdList;
    // 交易帐号（批量查询）
    private List<String> batchTradeAccountList;
}
