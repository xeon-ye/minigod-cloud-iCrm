package com.minigod.api.grm.utils;

/**
 * Created by CaiJianbo on 2016/5/3 11:42.
 * minigod
 */
public enum EFileType {
    XLS("xls"),CVS("cvs");
    private final String name ;
    private EFileType(String name){
        this.name = name;
    }
    public String getName(){
        return this.name();
    }
}
