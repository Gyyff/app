package com.heiqi.chat.service;

import com.heiqi.chat.entity.Images;

import java.util.List;

public interface ImagesService {
    int UploadImages(int UserId,String imagePath);

    List<Images> getImagesByBlogID(int blogID);
}
