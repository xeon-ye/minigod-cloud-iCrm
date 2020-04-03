package com.minigod.account.helper;

import com.minigod.common.utils.FileUtils;
import com.minigod.common.utils.ImageUtils;
import com.minigod.protocol.storage.model.SysStorage;
import com.minigod.storage.helper.StorageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;

@Slf4j
@Service
public class FileStorageHelper {

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

    public String uploadPdf(String fileName, String base64File) {
        try {
            byte[] imgByte = FileUtils.Base64ToByte(base64File);
            InputStream inputStream = new ByteArrayInputStream(imgByte);
            SysStorage loanStorage = storageService.store(inputStream, base64File.length(), "file/pdf", fileName);
            return loanStorage.getUrl();
        } catch (Exception e) {

        }
        return null;
    }

}
