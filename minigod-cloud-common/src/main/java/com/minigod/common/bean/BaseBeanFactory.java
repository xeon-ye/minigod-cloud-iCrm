package com.minigod.common.bean;

import com.minigod.common.i18n.MessageI18NHelper;
import com.minigod.common.pojo.request.BaseRequestParams;

import javax.annotation.Resource;

public class BaseBeanFactory<T extends BaseRequestParams> {
    @Resource
    MessageI18NHelper messageI18NHelper;

    public String getResMessage(T params, String messageResource) {
        String langKey = params.getLangKey();
        return messageI18NHelper.getLocaleMessage(langKey, messageResource);
    }
}
