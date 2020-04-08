package com.minigod.helper.bean;

import com.minigod.common.pojo.request.BaseRequestParams;
import com.minigod.helper.i18n.MessageI18NHelper;

import javax.annotation.Resource;

public class BaseBeanFactory<T extends BaseRequestParams> {
    @Resource
    MessageI18NHelper messageI18NHelper;

    public String getResMessage(T params, String messageResource) {
        String langKey = params.getLangKey();
        return messageI18NHelper.getLocaleMessage(langKey, messageResource);
    }
}
