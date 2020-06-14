package com.minigod.protocol.brokerinfo.model;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BrokerData implements Serializable {
    private Integer id;

    private String code;

    private String brokerNo;

    private String enFullName;

    private String hkFullName;

    private String tradingStatus;

    private String addressEn1;

    private String addressEn2;

    private String addressEn3;

    private String addressEn4;

    private String addressHk;

    private String telPhone;

    private String fax;

    private String website;

    private String stockOptionsParticipantship;

    private String hksccParticipantship;

    private String seochParticipantship;

    private String othBusinessAddressEn1;

    private String othBusinessAddressEn2;

    private String othBusinessAddressEn3;

    private String othBusinessAddressEn4;

    private static final long serialVersionUID = 1L;
}