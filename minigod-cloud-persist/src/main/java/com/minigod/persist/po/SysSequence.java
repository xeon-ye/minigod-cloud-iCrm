package com.minigod.persist.po;
import com.minigod.persist.tables.TSysSequence;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;

/**
 * 
 */
@Entity(table=TSysSequence.class)
public class SysSequence implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private String seqName = "";
	private Long seqVersion = 0l;//当前值

    public String getSeqName () {
        return seqName;
    }

    public void setSeqName (String seqName) {
        this.seqName = seqName;
    }

    public Long getSeqVersion () {
        return seqVersion;
    }

    public void setSeqVersion (Long seqVersion) {
        this.seqVersion = seqVersion;
    }
}