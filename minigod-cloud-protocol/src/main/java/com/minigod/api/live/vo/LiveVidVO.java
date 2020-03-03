package com.minigod.api.live.vo;

import com.minigod.api.vo.BaseVO;
import com.minigod.common.anno.TransferBean;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 
 */
@TransferBean
public class LiveVidVO extends BaseVO implements Serializable {


    private static final long serialVersionUID = -2260388125919493487L;
    private Integer vidId;
    private Integer liveRoomId;
    private String groupId;
    private String vid;
    private String nickName;
    private String title;
    private String startTime;
    private String createTime;
    private Boolean status = true;
    private String imGroupId;
    private String ownerId;

    public Integer getVidId () {
        return vidId;
    }

    public void setVidId (Integer vidId) {
        this.vidId = vidId;
    }

    public Integer getLiveRoomId () {
        return liveRoomId;
    }

    public void setLiveRoomId (Integer liveRoomId) {
        this.liveRoomId = liveRoomId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getVid () {
        return vid;
    }

    public void setVid (String vid) {
        this.vid = vid;
    }

    public String getNickName () {
        return nickName;
    }

    public void setNickName (String nickName) {
        this.nickName = nickName;
    }

    public String getTitle () {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public String getStartTime () {
        return startTime;
    }

    public void setStartTime (String startTime) {
        this.startTime = startTime;
    }

    public String getCreateTime () {
        return createTime;
    }

    public void setCreateTime (String createTime) {
        this.createTime = createTime;
    }

    public Boolean getStatus () {
        return status;
    }

    public void setStatus (Boolean status) {
        this.status = status;
    }

    public String getImGroupId() {
        return imGroupId;
    }

    public void setImGroupId(String imGroupId) {
        this.imGroupId = imGroupId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

}