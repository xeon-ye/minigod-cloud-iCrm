package com.minigod.protocol.account.bpm.request;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;


/**
 * 增开申请
 *
 * @author jim
 * @createDate 2020/8/8
 */

@Data
@ToString
public class BpmOpenMarginAccountAppointmentReqVo implements Serializable {
    private static final long serialVersionUID = 5643282110965780507L;
    //预约流水号
    @JSONField(name = "idCardNo")
    private String idCardNo;

    //信用额度
    @JSONField(name = "creditQuota")
    private String creditQuota;

    //信用比例
    @JSONField(name = "creditRatio")
    private String creditRatio;

    //其他信息披露
    @JSONField(name = "disclosure")
    private List<BpmOpenAccountOtherDisclosureReqVo> disclosure;
}
