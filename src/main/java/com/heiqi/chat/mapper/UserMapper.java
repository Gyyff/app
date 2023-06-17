package com.heiqi.chat.mapper;

import com.heiqi.chat.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {

    @Select("SELECT * FROM user WHERE UserId = #{UserId}")
    User getUserById(@Param("UserId") int UserId);

    @Select("SELECT * FROM user WHERE UserName = #{UserName}")
    User getUserByName(@Param("UserName") String UserName);

    @Select("SELECT * FROM user WHERE Age = #{Age}")
    User getUserByAge(@Param("Age") int Age);

    @Select("SELECT * FROM user WHERE Address = #{Address}")
    User getUserByAddress(@Param("Address") String Address);

    @Insert("INSERT INTO user(UserId, UserName, PassWord, Photo, Identity, Gender, Age, Address, Height, Education, Sex,Beauty) VALUES(#{UserId}, #{UserName}, #{PassWord}, #{Photo}, #{Identity}, #{Gender}, #{Age}, #{Address}, #{Height}, #{Education}, #{Sex},#{Beauty})")
    @Options(useGeneratedKeys = true, keyProperty = "UserId")
    int insertUser(User user);

    @Delete("DELETE FROM user WHERE UserId = #{UserId}")
    int deleteUser(@Param("UserId") int UserId);

    @Update("UPDATE user SET UserName = #{UserName} WHERE UserId = #{UserId}")
    int updateUserName(@Param("UserId") int UserId, @Param("UserName") String UserName);

    @Update("UPDATE user SET Age = #{Age} WHERE UserId = #{UserId}")
    int updateUserAge(@Param("UserId") int UserId, @Param("Age") int Age);

    @Update("UPDATE user SET Address = #{Address} WHERE UserId = #{UserId}")
    int updateUserAddress(@Param("UserId") int UserId, @Param("Address") String Address);

    @Update("UPDATE user SET Identity = #{Identity} WHERE UserId = #{UserId}")
    int updateUserIdentity(@Param("UserId") int UserId, @Param("Identity") String Identity);

    @Update("UPDATE user SET education = #{Education} WHERE userId = #{UserId}")
    int updateUserEducation(@Param("UserId") int UserId, @Param("Education") int Education);

    @Update("UPDATE user SET Photo = #{Photo} WHERE UserId = #{UserId}")
    int updateUserPhoto(@Param("UserId") int UserId, @Param("Photo") String Photo);


}
