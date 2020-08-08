package com.minigod.protocol.account.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class CustomOpenMoreAccount implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 用户ID
     */
    private Integer userId;


    /**
     * 账户类型 1：现金账户 2：融资账户
     */
    private Integer type;

    /**
     * 0:未提交（默认），1:开户中，2:已取消,3:开户成功，4:开户失败，5:销户
     */
    private Integer status;

    /**
     * 是否已下发
     */
    private Boolean isNoticed;

    /**
     * 下发失败次数
     */
    private Integer noticeErrCount;

    /**
     * 是否已推送
     */
    private Boolean isPushed;

    /**
     * 推送失败次数
     */
    private Integer pushErrCount;

    /**
     * 远程开户系统ID
     */
    private String remoteId;

    /**
     * 开户日期
     */
    private Date openDate;

    /**
     * 客户号（交易帐号）
     */
    private String tradeAccount;

    /**
     * 是否发送消息
     */
    private Boolean isSend;

    /**
     * 开户数据
     */
    private String formData;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}