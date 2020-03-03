package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNVersion;

/**
 * Created by ChenYouhuo on 2016/5/11.
 */
public class MyFavReqVO extends SNVersion {

    private static final long serialVersionUID = 5023371453514434609L;
    private MyFavVO params;

    public MyFavVO getParams() {
        return params;
    }

    public void setParams(MyFavVO params) {
        this.params = params;
    }
}
