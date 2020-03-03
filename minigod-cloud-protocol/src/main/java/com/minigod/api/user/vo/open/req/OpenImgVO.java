package com.minigod.api.user.vo.open.req;

import com.minigod.api.vo.BaseVO;

/**
 * @author 寇艳东
 * @version v1.0
 * @project: minigod
 * @description: 这里描述类的用处
 * @copyright: © 2017
 * @company:
 * @date 2017/3/22 10:55
 */
public class OpenImgVO extends BaseVO {
    private boolean isOcr;
    private String imgBase64;
    private String location;
    private String type;
    private Integer lastImg;
    private Integer openType; // 1线上 2线下

    public boolean isOcr() {
        return isOcr;
    }

    public void setOcr(boolean ocr) {
        isOcr = ocr;
    }

    public String getImgBase64() {
        return imgBase64;
    }

    public void setImgBase64(String imgBase64) {
        this.imgBase64 = imgBase64;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

	public Integer getLastImg() {
		return lastImg;
	}

	public void setLastImg(Integer lastImg) {
		this.lastImg = lastImg;
	}

    public Integer getOpenType() {
        return openType;
    }

    public void setOpenType(Integer openType) {
        this.openType = openType;
    }
}
