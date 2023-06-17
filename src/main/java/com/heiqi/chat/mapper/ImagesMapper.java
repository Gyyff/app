package com.heiqi.chat.mapper;

import com.heiqi.chat.entity.Images;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface ImagesMapper {

    @Insert("INSERT INTO Images(BlogID, ImagePath) VALUES (#{blogID}, #{imagePath})")
    int insertImages(Images images);

    @Select("SELECT * FROM Images WHERE BlogID = #{blogID}")
    List<Images> getImagesByBlogID(int blogID);
}