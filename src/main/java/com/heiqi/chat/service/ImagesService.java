package com.heiqi.chat.service;

import com.heiqi.chat.entity.Images;

import java.util.List;

public interface ImagesService {
    int insertImages(Images images);

    List<Images> getImagesByBlogID(int blogID);
}
