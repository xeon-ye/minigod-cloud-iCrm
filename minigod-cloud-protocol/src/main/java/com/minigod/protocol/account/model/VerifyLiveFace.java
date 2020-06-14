package com.minigod.protocol.account.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VerifyLiveFace implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 关联用户ID
     */
    private Integer userId;

    /**
     * 图片链接
     */
    private String imgUrl;

    /**
     * 活体打分
     */
    private Float score;

    /**
     * 校验结果
     */
    private Boolean isLiveness;

    private String remark;

    /**
     * 验证时间
     */
    private Date checkDate;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后修改时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}