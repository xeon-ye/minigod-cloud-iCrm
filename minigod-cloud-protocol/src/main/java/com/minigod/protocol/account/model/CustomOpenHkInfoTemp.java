package com.minigod.protocol.account.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomOpenHkInfoTemp implements Serializable {
    private Long id;

    private Integer userId;

    private Long step;

    private String jsonInfo;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}