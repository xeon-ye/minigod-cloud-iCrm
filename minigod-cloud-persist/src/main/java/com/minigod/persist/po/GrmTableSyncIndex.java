package com.minigod.persist.po;
import com.minigod.persist.tables.TGrmTableSyncIndex;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
@Entity(table=TGrmTableSyncIndex.class)
public class GrmTableSyncIndex implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer id;
	private String tableName;
	private String positionStr;
	private Long versionNo;
	private Date lastSyncTime;
	private Integer lastSyncRecs;
	private String positionFieldName;

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public String getTableName () {
        return tableName;
    }

    public void setTableName (String tableName) {
        this.tableName = tableName;
    }

    public String getPositionStr () {
        return positionStr;
    }

    public void setPositionStr (String positionStr) {
        this.positionStr = positionStr;
    }

    public Long getVersionNo () {
        return versionNo;
    }

    public void setVersionNo (Long versionNo) {
        this.versionNo = versionNo;
    }

    public Date getLastSyncTime () {
        return lastSyncTime;
    }

    public void setLastSyncTime (Date lastSyncTime) {
        this.lastSyncTime = lastSyncTime;
    }

    public Integer getLastSyncRecs () {
        return lastSyncRecs;
    }

    public void setLastSyncRecs (Integer lastSyncRecs) {
        this.lastSyncRecs = lastSyncRecs;
    }

    public String getPositionFieldName () {
        return positionFieldName;
    }

    public void setPositionFieldName (String positionFieldName) {
        this.positionFieldName = positionFieldName;
    }
}