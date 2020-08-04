package com.sunline.modules.common.common;

import com.alibaba.fastjson.serializer.ValueFilter;

/**
 * @author LiYangFeng
 * @createDate 2017/7/25
 * @description
 * @email justbelyf@gmail.com
 */
public class FastJsonFilter {
    // 将null设置为空
    public static ValueFilter nullAsEmptyFilter = new ValueFilter() {
        @Override
        public Object process(Object obj, String s, Object v) {
            if (v == null)
                return "";
            return v;
        }
    };
}
