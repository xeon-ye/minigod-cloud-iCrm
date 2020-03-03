package com.minigod.persist.po;
import com.minigod.persist.tables.THqMarketPackageInfo;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;

/**
 * 
 */
@Entity(table=THqMarketPackageInfo.class)
public class HqMarketPackageInfo implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Long marketPackageId;
	private Long packageId;
	private Long marketId;

    public Long getMarketPackageId () {
        return marketPackageId;
    }

    public void setMarketPackageId (Long marketPackageId) {
        this.marketPackageId = marketPackageId;
    }

    public Long getPackageId () {
        return packageId;
    }

    public void setPackageId (Long packageId) {
        this.packageId = packageId;
    }

    public Long getMarketId () {
        return marketId;
    }

    public void setMarketId (Long marketId) {
        this.marketId = marketId;
    }
}