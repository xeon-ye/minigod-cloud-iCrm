package com.sunline.web.converter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author LiYangFeng
 * @createDate 2018/4/8
 * @description
 * @email justbelyf@gmail.com
 */
@Component
public class StringConverter implements Converter<String, String> {
    @Override
    public String convert(String s) {

        return StringUtils.isBlank(s) ? null : s;
    }
}
