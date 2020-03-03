package com.minigod.persist.po;
import com.minigod.persist.tables.TGrmHqPrivilegeFlag;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;

/**
 * 行情产品权限定义表
 */
@Entity(table=TGrmHqPrivilegeFlag.class)
public class GrmHqPrivilegeFlag implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer id;
	private String privilegeLabel;
	private String privilegeId;//权限唯一编码
	private String privilegeDesc;//权限描述

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public String getPrivilegeLabel () {
        return privilegeLabel;
    }

    public void setPrivilegeLabel (String privilegeLabel) {
        this.privilegeLabel = privilegeLabel;
    }

    public String getPrivilegeId () {
        return privilegeId;
    }

    public void setPrivilegeId (String privilegeId) {
        this.privilegeId = privilegeId;
    }

    public String getPrivilegeDesc () {
        return privilegeDesc;
    }

    public void setPrivilegeDesc (String privilegeDesc) {
        this.privilegeDesc = privilegeDesc;
    }
}