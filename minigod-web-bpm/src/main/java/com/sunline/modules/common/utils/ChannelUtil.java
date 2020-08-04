package com.sunline.modules.common.utils;

import com.sunline.modules.marker.service.UserChannelInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * 渠道弹出菜单工具类
 *
 * @author lcs
 */
@Component
public class ChannelUtil {
    @Autowired
    private UserChannelInfoService UserChannelInfoService;
    private static UserChannelInfoService channelService;

    @PostConstruct
    public void init() {
        channelService = UserChannelInfoService;
    }


    public static List<String> getCheckedChannelIds(String channelId) {
        List<String> channelIdsChecked = new ArrayList<>();
        channelIdsChecked.add(channelId);
        getChannelIds(channelIdsChecked, channelId);
        return channelIdsChecked;
    }

    private static List<String> getChannelIds(List<String> channelIdChecked, String parentId) {
        List<String> list = channelService.queryByParent(parentId);
        channelIdChecked.addAll(list);
        if (list != null && list.size() > 0) {
            for (String id : list) {
                getChannelIds(channelIdChecked, id);
            }
        }
        return channelIdChecked;
    }
}
