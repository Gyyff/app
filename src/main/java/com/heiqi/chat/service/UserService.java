package com.heiqi.chat.service;

import com.heiqi.chat.entity.Metrics;
import com.heiqi.chat.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserService  {
    User getUserById(int UserId);
    User getUserByName(String UserName);
    User getUserByAge( int Age);
    User getUserByAddress(String Address);
    boolean getUserCharaPro(int UserId);
    boolean getUserInfoPro(int UserId);
    int getUserMatchPro(int UserId);

    public List<Metrics> getUserMatch(int UserId);
    int insertUser(User user);
    int deleteUser( int UserId);
    int updateUserName( int UserId,String UserName);
    int updateUserAge(int UserId, int Age);
    int updateUserAddress(int UserId, String Address);
    int updateUserIdentity( int UserId, String Identity);
    int updateUserEducation( int UserId, int Education);
    int updateUserPhoto(int UserId, String Photo);


    int updateUserIsAuthed(@Param("UserId") int UserId, @Param("IsAuthed") int IsAuthed);
    int updateUserIsLogged(@Param("UserId") int UserId, @Param("IsLogged") int IsLogged);
    int updateUserMatchStatus(@Param("UserId") int UserId, @Param("MatchStatus") int MatchStatus);
    int updateUserIsTestedCore(@Param("UserId") int UserId, @Param("IsTestedCore") int IsTestedCore);
    int updateUserIsTestedNoncore(@Param("UserId") int UserId, @Param("IsTestedNoncore") int IsTestedNoncore);




}
