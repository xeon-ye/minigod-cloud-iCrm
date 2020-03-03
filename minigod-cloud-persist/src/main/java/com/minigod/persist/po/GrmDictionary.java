package com.minigod.persist.po;
import com.minigod.persist.tables.TGrmDictionary;
import com.minigod.db4j.annotation.Entity;
import java.io.Serializable;

/**
 * 
 */
@Entity(table=TGrmDictionary.class)
public class GrmDictionary implements Serializable {

	private static final long serialVersionUID = -2260388125919493487L;
	private Integer dictId;
	private String entryCode;
	private String entryName;
	private String dictCode;
	private String dictName;
	private String dictDesc;

    public Integer getDictId () {
        return dictId;
    }

    public void setDictId (Integer dictId) {
        this.dictId = dictId;
    }

    public String getEntryCode () {
        return entryCode;
    }

    public void setEntryCode (String entryCode) {
        this.entryCode = entryCode;
    }

    public String getEntryName () {
        return entryName;
    }

    public void setEntryName (String entryName) {
        this.entryName = entryName;
    }

    public String getDictCode () {
        return dictCode;
    }

    public void setDictCode (String dictCode) {
        this.dictCode = dictCode;
    }

    public String getDictName () {
        return dictName;
    }

    public void setDictName (String dictName) {
        this.dictName = dictName;
    }

    public String getDictDesc () {
        return dictDesc;
    }

    public void setDictDesc (String dictDesc) {
        this.dictDesc = dictDesc;
    }
}