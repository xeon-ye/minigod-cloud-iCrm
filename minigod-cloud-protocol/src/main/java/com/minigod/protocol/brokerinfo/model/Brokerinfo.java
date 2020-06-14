package com.minigod.protocol.brokerinfo.model;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Brokerinfo implements Serializable {
    private Integer id;

    private String s;

    private String c;

    private String tw;

    private String twf;

    private String n;

    private String nf;

    private String en;

    private String enf;

    private static final long serialVersionUID = 1L;
}