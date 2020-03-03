package com.minigod.api.user.vo.request;

/**
 * @author: PENGFENG
 * @description:
 * @date: Created in 11:02 2017/11/13
 * @modified By:
 */
public class UserIsApplyAuthRequestVO {

    private Integer userId;

    private Integer approveBusinessType; // 0:未知 1:衍生品交易 2:美股增开户

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getApproveBusinessType() {
        return approveBusinessType;
    }

    public void setApproveBusinessType(Integer approveBusinessType) {
        this.approveBusinessType = approveBusinessType;
    }
}
