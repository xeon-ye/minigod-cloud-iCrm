package com.minigod.storage.config;

import com.minigod.storage.helper.*;
import com.minigod.storage.helper.StorageHelper;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(StorageProperties.class)
public class StorageAutoConfiguration {

    private final StorageProperties properties;

    public StorageAutoConfiguration(StorageProperties properties) {
        this.properties = properties;
    }

    @Bean
    public StorageHelper storageService() {
        StorageHelper storageService = new StorageHelper();
        String active = this.properties.getActive();
        storageService.setActive(active);
        if (active.equals("local")) {
            storageService.setStorageFactory(localStorage());
        } else if (active.equals("aliyun")) {
            storageService.setStorageFactory(aliyunStorage());
        } else if (active.equals("tencent")) {
            storageService.setStorageFactory(tencentStorage());
        } else if (active.equals("qiniu")) {
            storageService.setStorageFactory(qiniuStorage());
        } else {
            throw new RuntimeException("当前存储模式 " + active + " 不支持");
        }

        return storageService;
    }

    @Bean
    public StorageFactoryLocal localStorage() {
        StorageFactoryLocal localStorage = new StorageFactoryLocal();
        StorageProperties.Local local = this.properties.getLocal();
        localStorage.setAddress(local.getAddress());
        localStorage.setStoragePath(local.getStoragePath());
        return localStorage;
    }

    @Bean
    public StorageFactoryAliyun aliyunStorage() {
        StorageFactoryAliyun aliyunStorage = new StorageFactoryAliyun();
        StorageProperties.Aliyun aliyun = this.properties.getAliyun();
        aliyunStorage.setAccessKeyId(aliyun.getAccessKeyId());
        aliyunStorage.setAccessKeySecret(aliyun.getAccessKeySecret());
        aliyunStorage.setBucketName(aliyun.getBucketName());
        aliyunStorage.setEndpoint(aliyun.getEndpoint());
        return aliyunStorage;
    }

    @Bean
    public StorageFactoryTencent tencentStorage() {
        StorageFactoryTencent tencentStorage = new StorageFactoryTencent();
        StorageProperties.Tencent tencent = this.properties.getTencent();
        tencentStorage.setSecretId(tencent.getSecretId());
        tencentStorage.setSecretKey(tencent.getSecretKey());
        tencentStorage.setBucketName(tencent.getBucketName());
        tencentStorage.setRegion(tencent.getRegion());
        return tencentStorage;
    }

    @Bean
    public StorageFactoryQiniu qiniuStorage() {
        StorageFactoryQiniu qiniuStorage = new StorageFactoryQiniu();
        StorageProperties.Qiniu qiniu = this.properties.getQiniu();
        qiniuStorage.setAccessKey(qiniu.getAccessKey());
        qiniuStorage.setSecretKey(qiniu.getSecretKey());
        qiniuStorage.setBucketName(qiniu.getBucketName());
        qiniuStorage.setEndpoint(qiniu.getEndpoint());
        return qiniuStorage;
    }
}
