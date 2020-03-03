package com.minigod.common.i18n;

import com.minigod.common.pojo.StaticType;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageI18NHelper {
    @Autowired
    MessageSource messageSource;

    public String getLocaleMessage(String localeStr, String messageResource) {
        Locale locale = StringUtils.isNotBlank(localeStr) ? new Locale(localeStr) : LocaleContextHolder.getLocale();
        return getLocaleMessage(locale, messageResource);
    }

    public String getLocaleMessage(Locale locale, String messageResource) {
        try {
            return messageSource.getMessage(messageResource, null, locale);
        } catch (Exception e) {
            return messageSource.getMessage(StaticType.MessageResource.BAD_REQUEST, null, locale);
        }
    }

    public String getRemoteConnectError() {
        return getLocaleMessage("", StaticType.MessageResource.REMOTE_CONNECT_ERROR);
    }
}
