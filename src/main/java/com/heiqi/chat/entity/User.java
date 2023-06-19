package com.heiqi.chat.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private int UserId;
    private String UserName;
    private String PassWord;
    private String Photo;
    private String Identity;
    private int Gender;
    private int Age;
    private String Address;
    private int Height;
    private int Education;
    private int Sex;
    private int Beauty;
    private int CharaPro; //性格测试状态
    private int InfoPro; //资料审核状态
    private int MatchPro; //性格测试状态



}
