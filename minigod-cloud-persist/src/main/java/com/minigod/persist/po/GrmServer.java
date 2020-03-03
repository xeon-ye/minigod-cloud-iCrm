package com.minigod.persist.po;
import com.minigod.persist.tables.TGrmServer;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TGrmServer.class)
public class GrmServer implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer serverId;
	private String serverName;
	private Integer serverGroup;
	private String serverIp;
	private Integer serverPort;
	private Integer serverState;
	private Date listDate;
	private Date delistDate;
	private String serverCode;
	private Integer serverType;
	private String entrustWay;

    public Integer getServerId () {
        return serverId;
    }

    public void setServerId (Integer serverId) {
        this.serverId = serverId;
    }

    public String getServerName () {
        return serverName;
    }

    public void setServerName (String serverName) {
        this.serverName = serverName;
    }

    public Integer getServerGroup () {
        return serverGroup;
    }

    public void setServerGroup (Integer serverGroup) {
        this.serverGroup = serverGroup;
    }

    public String getServerIp () {
        return serverIp;
    }

    public void setServerIp (String serverIp) {
        this.serverIp = serverIp;
    }

    public Integer getServerPort () {
        return serverPort;
    }

    public void setServerPort (Integer serverPort) {
        this.serverPort = serverPort;
    }

    public Integer getServerState () {
        return serverState;
    }

    public void setServerState (Integer serverState) {
        this.serverState = serverState;
    }

    public Date getListDate () {
        return listDate;
    }

    public void setListDate (Date listDate) {
        this.listDate = listDate;
    }

    public Date getDelistDate () {
        return delistDate;
    }

    public void setDelistDate (Date delistDate) {
        this.delistDate = delistDate;
    }

    public String getServerCode () {
        return serverCode;
    }

    public void setServerCode (String serverCode) {
        this.serverCode = serverCode;
    }

    public Integer getServerType () {
        return serverType;
    }

    public void setServerType (Integer serverType) {
        this.serverType = serverType;
    }

    public String getEntrustWay () {
        return entrustWay;
    }

    public void setEntrustWay (String entrustWay) {
        this.entrustWay = entrustWay;
    }
}