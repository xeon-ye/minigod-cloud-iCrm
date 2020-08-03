package com.minigod.protocol.notify.request.params;

import com.minigod.common.pojo.request.BaseRequestParams;
import lombok.Data;
import org.apache.tomcat.jni.FileInfo;

import java.io.Serializable;
import java.util.List;
@Data
public class NotifyEmailReqParams extends BaseRequestParams implements Serializable {
   private String sendTo;
   private String sendFrom;
   private String subject;
   private String content;
   private List<EmailFileInfo> paths;
}
