package com.heiqi.chat.controller;

import com.heiqi.chat.service.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api/user/images")
public class ImagesController {
    private final ImagesService imagesService;

    @Autowired
    public ImagesController(ImagesService imagesService) {
        this.imagesService = imagesService;
    }

    @PostMapping("/imagesUpload/{UserId}")
    public int ImagesUpload(@PathVariable("UserId") int UserId, @RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                // 这里只是简单示例，文件直接输出到项目路径下。
                // 实际项目中，你可能会将文件保存在指定的路径，然后将文件的URL路径保存在数据库中。
                String saveFileName = file.getOriginalFilename();
                File saveFile = new File("C:\\Users\\耿奕飞\\Desktop" + saveFileName);
                file.transferTo(saveFile);
                return imagesService.UploadImages(UserId,saveFileName);
            } catch (IOException e) {
                e.printStackTrace();
                return 0;
            }
        } else {
            return 0;
        }
    }
}