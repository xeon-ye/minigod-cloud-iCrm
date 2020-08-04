package com.sunline.web.converter;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author LiYangFeng
 * @createDate 2018/4/8
 * @description
 * @email justbelyf@gmail.com
 */
@Component
public class LongConverter implements Converter<String, Long> {
    protected String[] dateTimeFormats = new String[]{"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss"};

    @Override
    public Long convert(String s) {
        try {
            if (org.apache.commons.lang.StringUtils.isBlank(s)) {
                return null;
            } else if (0 <= s.indexOf('-')) {
                return DateUtils.parseDate(s, dateTimeFormats).getTime();
            } else {
                return Long.parseLong(s);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
