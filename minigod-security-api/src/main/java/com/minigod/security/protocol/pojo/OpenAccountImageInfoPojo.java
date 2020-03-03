package com.minigod.security.protocol.pojo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * @author PENGFENG
 * @createDate 2017/2/22
 * @description
 */

public class OpenAccountImageInfoPojo implements Serializable {

    private static final long serialVersionUID = -6332540545611763261L;
    @JSONField(name = "imageLocation")
    private Integer imageLocation;

    @JSONField(name = "imageLocationType")
    private Integer imageLocationType;

    @JSONField(name = "imageUrl")
    private String imageUrl;

    public Integer getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(Integer imageLocation) {
        this.imageLocation = imageLocation;
    }

    public Integer getImageLocationType() {
        return imageLocationType;
    }

    public void setImageLocationType(Integer imageLocationType) {
        this.imageLocationType = imageLocationType;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
