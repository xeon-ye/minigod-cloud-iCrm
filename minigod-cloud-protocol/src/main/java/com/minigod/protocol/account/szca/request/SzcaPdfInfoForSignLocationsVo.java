package com.minigod.protocol.account.szca.request;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SzcaPdfInfoForSignLocationsVo implements Serializable {
    private static final long serialVersionUID = -8898050388107272713L;

    private Integer pageNo;
    private Integer x;
    private Integer y;


}
