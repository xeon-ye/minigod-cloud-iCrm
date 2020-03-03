package com.minigod.security.helper;

import com.minigod.common.utils.ImageUtils;
import com.minigod.storage.protocol.model.SysStorage;
import com.minigod.storage.helper.StorageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.core.io.Resource;

import java.io.*;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@Service
public class ImageStorageHelper {

    @Autowired
    StorageHelper storageService;

    public String uploadImage(String fileName, String base64Img) {
        try {
            byte[] imgByte = ImageUtils.generateImage(base64Img);
            InputStream inputStream = new ByteArrayInputStream(imgByte);
            SysStorage loanStorage = storageService.store(inputStream, base64Img.length(), "image/jpg", fileName);
            return loanStorage.getUrl();
        } catch (Exception e) {

        }
        return null;
    }

}
