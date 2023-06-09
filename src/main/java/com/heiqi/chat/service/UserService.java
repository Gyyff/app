package com.heiqi.chat.service;

import com.heiqi.chat.entity.User;



public interface UserService  {
    User getUserById(int UserId);
    User getUserByName(String UserName);
    User getUserByAge( int Age);
    User getUserByAddress(String Address);
    int insertUser(User user);
    int deleteUser( int UserId);
    int updateUserName( int UserId,String UserName);
    int updateUserAge(int UserId, int Age);
    int updateUserAddress(int UserId, String Address);
    int updateUserIdentity( int UserId, String Identity);
    int updateUserEducation( int UserId, int Education);
    int updateUserPhoto(int UserId, String Photo);
}
