package com.minigod.helper.i18n;

import com.minigod.persist.common.mapper.ConfigLanguageMapper;
import com.minigod.protocol.common.model.ConfigLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MessageI18NHelper {
    @Autowired
    ConfigLanguageMapper configLanguageMapper;


    private static final String langZhCn = "zh_CN";
    private static final String langZhHk = "zh_HK";

    public String getLocaleMessage(String locale, String messageResource) {
        if (!langZhCn.equals(locale) && !langZhHk.equals(locale)) {
            locale = langZhCn;
        }

        ConfigLanguage configLanguage = configLanguageMapper.selectOneByConfigKeyAndLangKey(messageResource, locale);
        return configLanguage.getContent();
    }


}
