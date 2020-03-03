package com.minigod.api.user.vo.request;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.api.user.vo.params.SearchUser;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * Created by ChenYouhuo on 2016/4/18.
 */
@TransferBean
public class ReqSearchUsers extends SNVersion {

    private static final long serialVersionUID = 4416127932104952763L;
    @TransferID
    private SearchUser params;

    public SearchUser getParams() {
        return params;
    }

    public void setParams(SearchUser params) {
        this.params = params;
    }
}
