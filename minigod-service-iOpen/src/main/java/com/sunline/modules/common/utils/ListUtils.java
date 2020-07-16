package com.sunline.modules.common.utils;

import java.util.List;

/**
 * @author LiYangFeng
 * @createDate 2018/4/4
 * @description
 * @email justbelyf@gmail.com
 */
public class ListUtils {
    public static int isContains(List<Object> list, Object value) {
        if (null == list || list.isEmpty() || null == value) {
            return 0;
        }

        for (Object o : list) {
            if (o.toString().equals(value.toString())){
                return 1;
            }
        }

        return 0;
    }

}
