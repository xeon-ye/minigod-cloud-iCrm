package com.minigod.protocol.account.bpm.request;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
public class BpmOpenAccountCaVeritySnInfoVo implements Serializable {
    private static final long serialVersionUID = 1611100035148527827L;

    private String caCertDn;
    private String caCertSn;
    private Date certTime;

}
