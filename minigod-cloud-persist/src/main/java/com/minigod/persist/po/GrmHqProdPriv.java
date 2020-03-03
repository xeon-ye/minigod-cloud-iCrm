package com.minigod.persist.po;
import com.minigod.persist.tables.TGrmHqProdPriv;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;

/**
 * 
 */
@Entity(table=TGrmHqProdPriv.class)
public class GrmHqProdPriv implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer id;
	private Integer privilegeId;
	private Integer productId;

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public Integer getPrivilegeId () {
        return privilegeId;
    }

    public void setPrivilegeId (Integer privilegeId) {
        this.privilegeId = privilegeId;
    }

    public Integer getProductId () {
        return productId;
    }

    public void setProductId (Integer productId) {
        this.productId = productId;
    }
}