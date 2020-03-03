package com.minigod.api.user.vo.response;

import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

import java.io.Serializable;

/**
 * Created by ChenYouhuo on 2016/4/12.
 */
@TransferBean
public class RespUserRecommendVO implements Serializable {
    private static final long serialVersionUID = 4540112485243451639L;

    @TransferID
    private Long userId;//用户ID

    @Emoji
    private String nickName;//用户昵称

    private String userIcon;//头像绝对地址

    private String adviserType;//投顾类型(1-投资顾问,2-分析师,3-投资达人,4-基金执业资格)

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    public String getAdviserType() {
        return adviserType;
    }

    public void setAdviserType(String adviserType) {
        this.adviserType = adviserType;
    }
}
