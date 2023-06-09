package com.heiqi.chat.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Metrics {
    private int MetricID;
    private int UserID;
    private String MBTI;
    private int Principle; //道德原则 原则
    private int Knowledge;  //学历
    private int Openness;  // 开放性
    private int Curiosity;  // 好奇心和求知欲
    private int Abstraction;  // 抽象性
    private int Intellect;  // 智力投入
    private int Idea;  // 理想主义程度
    private int Standard;  //顺从/独立 (是不是会屈服于社会压力)
    private int Pet;  // 是否喜欢宠物
    private int Freedom;  // 倾向于自由或者威权主义
    private int ChineseMed;  // 是否相信中医
    private int Star;  // 是否相信星座
    private int FS;  // 是否相信风水
}
