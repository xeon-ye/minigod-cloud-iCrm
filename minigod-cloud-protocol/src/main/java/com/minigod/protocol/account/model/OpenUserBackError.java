package com.minigod.protocol.account.model;

import java.io.Serializable;
import lombok.Data;

@Data
public class OpenUserBackError implements Serializable {
    private Long id;

    private Integer num;

    private String error;

    private static final long serialVersionUID = 1L;
}