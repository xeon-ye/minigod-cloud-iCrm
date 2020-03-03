/*******************************************************************************
 * Copyright (c) 2016 minigod minigod.Co.Ltd. All rights reserved.
 ******************************************************************************/

package com.minigod.api.user.vo.api;

import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

import java.io.Serializable;

/**
 * @Description
 * @Author kouyandong
 * @Date 2016/5/12
 * @Version v1.0
 */
@TransferBean
public class UserSeeStockData implements Serializable {

    private static final long serialVersionUID = -1888620813507410249L;
    private Integer id;
    @TransferID
    private Long userId;
    private String nickName;
    private String assetId;
    private String icon;

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

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
