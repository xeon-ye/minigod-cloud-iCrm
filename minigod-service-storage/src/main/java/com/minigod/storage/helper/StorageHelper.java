package com.minigod.storage.helper;

import com.minigod.common.utils.FileUtils;
import com.minigod.persist.storage.mapper.SysStorageMapper;
import com.minigod.protocol.storage.model.SysStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.nio.file.Path;
import java.util.Date;
import java.util.stream.Stream;

/**
 * 提供存储服务类，所有存储服务均由该类对外提供
 */
public class StorageHelper {
    @Autowired
    SysStorageMapper sysStorageMapper;

    private String active;
    private StorageFactory storage;

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public StorageFactory getStorageFactory() {
        return storage;
    }

    public void setStorageFactory(StorageFactory storage) {
        this.storage = storage;
    }

    /**
     * 存储一个文件对象
     *
     * @param inputStream   文件输入流
     * @param contentLength 文件长度
     * @param contentType   文件类型
     * @param fileName      文件索引名
     */
    public SysStorage store(InputStream inputStream, long contentLength, String contentType, String fileName) {
        String key = FileUtils.generateKey(fileName);
        storage.store(inputStream, contentLength, contentType, key);

        String url = generateUrl(key);
        SysStorage storageInfo = new SysStorage();
        storageInfo.setName(fileName);
        storageInfo.setSize((int) contentLength);
        storageInfo.setType(contentType);
        storageInfo.setKey(key);
        storageInfo.setUrl(url);
        storageInfo.setCreateTime(new Date());
        storageInfo.setUpdateTime(new Date());
        sysStorageMapper.insert(storageInfo);

        return storageInfo;
    }

    public Stream<Path> loadAll() {
        return storage.loadAll();
    }

    public Path load(String keyName) {
        return storage.load(keyName);
    }

    public Resource loadAsResource(String keyName) {
        return storage.loadAsResource(keyName);
    }

    public void delete(String keyName) {
        storage.delete(keyName);
    }

    private String generateUrl(String keyName) {
        return storage.generateUrl(keyName);
    }
}
