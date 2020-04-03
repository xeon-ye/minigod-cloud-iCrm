package com.minigod.protocol.account.pojo;

import com.minigod.protocol.account.enums.CustomOpenAccountEnum.*;
import lombok.Data;

@Data
public class OpenStatusPojo {
    OpenStatus openStatus;
    FailStatusType failStatusType;
    PendingStatusType pendingStatusType;
}
