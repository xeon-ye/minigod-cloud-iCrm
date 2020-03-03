package com.minigod.api.grm.utils;

import com.minigod.common.utils.CollectionUtil;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CaiJianbo on 2016/4/28 15:24.
 * minigod
 */
public class SQLConstans{
    public static final String SELECT = "SELECT ";
    public static final String FROM = " FROM ";
    public static final String ASTERISK  = " * ";
    public static final String commas = " , ";
    public static final String SINGLE_QUOTE = "'";
    public static final String EQUAL = " = ";
    private static final String GT = " > ";
    private static final String GE = " >= ";

    private static final String IN = " IN ";

    public static final String AND = " AND ";
    public static final String ORDERBY = " ORDER BY ";
    public static final String DESC = " DESC ";
    public static final String WHERE = " WHERE ";
    public static final String AS = " AS ";
    public static final String OPEN_PAREN = "( ";
    public static final String CLOSE_PAREN = ") ";
    public static final String TABLE_MARKETINFO_ASSETINFO = " asset_info ";

    public static final String A = " A";
    public static final String B = " B";
    public static final String C = " C";

    public static final String ALIAS_A = " A.";
    public static final String ALIAS_B = " B.";
    public static final String ALIAS_C = " C.";


    public static final String eq(Object str){
        return new StringBuilder().append(EQUAL).append(SINGLE_QUOTE).append(str).append(SINGLE_QUOTE).toString();
    }

    public static final String MAX(Object str){
        return new StringBuilder().append("MAX").append(OPEN_PAREN).append(str).append(CLOSE_PAREN).toString();
    }

    public static final String toUpper(String str){
        return str.toUpperCase();
    }

    public static final String gt(String str){
        return new StringBuilder().append(GT).append(SINGLE_QUOTE).append(str).append(SINGLE_QUOTE).toString();
    }

    public static final String ge(String str){
        return new StringBuilder().append(GE).append(SINGLE_QUOTE).append(str).append(SINGLE_QUOTE).toString();
    }

    public static final String in(List<String> valList){
        StringBuilder strBuilder = new StringBuilder();
        if(CollectionUtils.isNotEmpty(valList)){
            strBuilder.append(IN).append(OPEN_PAREN);
            for(String val:valList){
                strBuilder.append(SINGLE_QUOTE).append(val).append(SINGLE_QUOTE).append(commas);
            }
            strBuilder.deleteCharAt(strBuilder.length()-2);
            strBuilder.append(CLOSE_PAREN);
        }
        return strBuilder.toString();
    }


}
