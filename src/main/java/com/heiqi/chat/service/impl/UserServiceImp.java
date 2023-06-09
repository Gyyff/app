package com.heiqi.chat.service.impl;

import com.heiqi.chat.entity.User;
import com.heiqi.chat.mapper.UserMapper;
import com.heiqi.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    private final UserMapper userMapper;
    @Autowired
    public UserServiceImp(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    @Override
    public User getUserById(int UserId) {
        return userMapper.getUserById(UserId);
    }

    @Override
    public User getUserByName(String UserName) {
        return userMapper.getUserByName(UserName);
    }

    @Override
    public User getUserByAge(int Age) {
        return userMapper.getUserByAge(Age);
    }

    @Override
    public User getUserByAddress(String Address) {
        return userMapper.getUserByAddress(Address);
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public int deleteUser(int UserId) {
        return userMapper.deleteUser(UserId);
    }

    @Override
    public int updateUserName(int UserId, String UserName) {
        return userMapper.updateUserName(UserId,UserName);
    }

    @Override
    public int updateUserAge(int UserId, int Age) {
        return userMapper.updateUserAge(UserId,Age);
    }

    @Override
    public int updateUserAddress(int UserId, String Address) {
        return userMapper.updateUserAddress(UserId,Address);
    }

    @Override
    public int updateUserIdentity(int UserId, String Identity) {
        return userMapper.updateUserIdentity(UserId,Identity);
    }

    @Override
    public int updateUserEducation(int UserId, int Education) {
        return userMapper.updateUserEducation(UserId,Education);
    }

    @Override
    public int updateUserPhoto(int UserId, String Photo) {
        return userMapper.updateUserPhoto(UserId,Photo);
    }
}
