package com.minigod.api.user.vo.response;

import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ChenYouhuo on 2016/4/18.
 */
@TransferBean
public class RespSearchUsers implements Serializable {
    private static final long serialVersionUID = -4568908323154555162L;
    @TransferID
    private List<RespSearchUser> users;//对象集合

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<RespSearchUser> getUsers() {
        return users;
    }

    public void setUsers(List<RespSearchUser> users) {
        this.users = users;
    }
}
