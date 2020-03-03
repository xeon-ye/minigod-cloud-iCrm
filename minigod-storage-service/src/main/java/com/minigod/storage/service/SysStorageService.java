package com.minigod.storage.service;

import com.minigod.storage.mapper.SysStorageMapper;
import com.minigod.storage.protocol.model.SysStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysStorageService {
    @Autowired
    SysStorageMapper sysStorageMapper;

    public SysStorage findByKey(String key) {
        return sysStorageMapper.selectOneByKey(key);
    }
}
