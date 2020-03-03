package com.minigod.api.grm.utils;

import java.util.Date;

/**
 * Created by CaiJianbo on 2016/5/4 13:48.
 * minigod
 */
public class TimeConsume {
    private Date begin ;
    public Date startTimming(){
        begin = new Date();
        return begin;
    }

    public int endAndGetInterval(){
        return (int)(new Date().getTime() - begin.getTime());
    }

    private TimeConsume(){

    }

    public static TimeConsume getInstance(){
        return new TimeConsume();
    }
}
