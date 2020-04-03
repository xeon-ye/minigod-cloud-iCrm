package com.minigod.protocol.account.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VerifyAuthCa implements Serializable {
    /**
    * 自增主键
    */
    private Integer id;

    /**
    * 身份证
    */
    private String idCard;

    /**
    * 用户名称
    */
    private String userName;

    /**
    * CA认证主题
    */
    private String certDn;

    /**
    * CA序列号
    */
    private String certSn;

    /**
    * CA认证文件HASH值
    */
    private String fileHash;

    /**
    * CA认证文件ID
    */
    private String fileId;

    /**
    * CA认证合成文件地址
    */
    private String filePdfUrl;

    /**
    * CA认证状态: 1>>0:未知，1>>1:P10证书，1>>2:签名，1>>3:P7合并,累加结果
    */
    private Integer status;

    /**
    * CA认证状态描述
    */
    private String remark;

    /**
    * CA认证次数
    */
    private Integer checkCount;

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