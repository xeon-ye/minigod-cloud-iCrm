package com.minigod.protocol.notify.request.params;

import lombok.Data;

@Data
public class EmailFileInfo {
    private String fileName;
    private String suffix;
    private String path;
}
