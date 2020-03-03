//package com.minigod.storage.controller;
//
//import com.minigod.common.pojo.response.ResResult;
//import com.minigod.storage.protocol.model.SysStorage;
//import com.minigod.storage.helper.StorageHelper;
//import com.minigod.storage.service.SysStorageService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
//import org.springframework.core.io.Resource;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//@Slf4j
//@RestController
//@RefreshScope
//@RequestMapping("/storage")
//public class StorageController {
//    @Autowired
//    private StorageHelper storageHelper;
//    @Autowired
//    private SysStorageService sysStorageService;
//
//
//    private Map<String, String> createResult(SysStorage SysStorage) {
//        Map<String, String> result = new HashMap<>();
//
//        result.put("url", SysStorage.getUrl());
//        return result;
//    }
//
//
//    @PostMapping("/upload")
//    public ResResult upload(@RequestParam("file") MultipartFile file) throws IOException {
//        String originalFilename = file.getOriginalFilename();
//        SysStorage SysStorage = storageHelper.store(file.getInputStream(), file.getSize(), file.getContentType(), originalFilename);
//
//        Map result = createResult(SysStorage);
//        return ResResult.success(result);
//    }
//
//    /**
//     * 访问存储对象
//     *
//     * @param key 存储对象key
//     * @return
//     */
//    @GetMapping("/fetch/{key:.+}")
//    public ResponseEntity<Resource> fetch(@PathVariable String key) {
//        SysStorage SysStorage = sysStorageService.findByKey(key);
//        if (key == null) {
//            return ResponseEntity.notFound().build();
//        }
//        if (key.contains("../")) {
//            return ResponseEntity.badRequest().build();
//        }
//        String type = SysStorage.getType();
//        MediaType mediaType = MediaType.parseMediaType(type);
//
//        Resource file = storageHelper.loadAsResource(key);
//        if (file == null) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok().contentType(mediaType).body(file);
//    }
//
//    /**
//     * 访问存储对象
//     *
//     * @param key 存储对象key
//     * @return
//     */
//    @GetMapping("/download/{key:.+}")
//    public ResponseEntity<Resource> download(@PathVariable String key) {
//        SysStorage SysStorage = sysStorageService.findByKey(key);
//        if (key == null) {
//            return ResponseEntity.notFound().build();
//        }
//        if (key.contains("../")) {
//            return ResponseEntity.badRequest().build();
//        }
//
//        String type = SysStorage.getType();
//        MediaType mediaType = MediaType.parseMediaType(type);
//
//        Resource file = storageHelper.loadAsResource(key);
//        if (file == null) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok().contentType(mediaType).header(HttpHeaders.CONTENT_DISPOSITION,
//                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
//    }
//}
