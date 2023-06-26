package com.heiqi.chat.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private int UserId;
    private String UserName;
    private String wxId;
    private String Photo;
    private String Identity;
    private int Gender;
    private int Age;
    private String Address;
    private int Height;
    private int Education;
    private int Sex;
    private int Beauty;
    private int IsAuthed; //资料审核状态
    private int IsLogged; //登录状态
    private int MatchStatus; //匹配状态
    private int IsTestedCore; //核心属性是否测试
    private int IsTestedNoncore; //非核心属性是否测试



}
