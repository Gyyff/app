package com.heiqi.chat.service.impl;

import com.heiqi.chat.Utils.MateUtils;
import com.heiqi.chat.entity.NonCore;
import com.heiqi.chat.mapper.NonCoreMapper;
import com.heiqi.chat.service.NonCoreService;
import com.heiqi.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NonCoreServiceImpl implements NonCoreService {

    private final NonCoreMapper nonCoreMapper;
    private final UserService userService;
    private final MateUtils mateUtils;

    @Autowired
    public NonCoreServiceImpl(NonCoreMapper nonCoreMapper, UserService userService, MateUtils mateUtils) {
        this.nonCoreMapper = nonCoreMapper;
        this.userService = userService;
        this.mateUtils = mateUtils;
    }


    @Override
    public NonCore getNonCoreByNonCoreID(int NonCoreID) {
        return nonCoreMapper.getNonCoreByNonCoreID(NonCoreID);
    }

    @Override
    public NonCore getNonCoreByUserID(int UserID) {
        return nonCoreMapper.getNonCoreByUserID(UserID);
    }

    @Override
    public int insertNonCore(NonCore nonCore) {
        return nonCoreMapper.insertNonCore(nonCore);
    }

    @Override
    public int deleteNonCoreByUserID(int UserID) {
        return nonCoreMapper.deleteNonCoreByUserID(UserID);
    }

    @Override
    public int deleteNonCoreByNonCoreID(int NonCoreID) {
        return nonCoreMapper.deleteNonCoreByNonCoreID(NonCoreID);
    }

    @Override
    public int insertNonCoreText(NonCore nonCore) {
        nonCoreMapper.insertNonCore(mateUtils.Convert(nonCore));
        return nonCoreMapper.insertNonCoreText(nonCore);
    }

    @Override
    public List<NonCore> getSoulFriend(int UserID) {
        //得到当前用户的NonCore对象
        NonCore thisNonCore = nonCoreMapper.getNonCoreByUserID(UserID);
        //创建非核心属性匹配成功的集合
        List<NonCore> Success = new ArrayList<>();
        userService.getUserMatch(UserID).forEach((nonCores) -> {
            //找到对应的NonCore对象
            NonCore nonCore = nonCoreMapper.getNonCoreByUserID(nonCores.getUserID());
            //开始进行判断 InAndEx 是否外向必须相等
            if (thisNonCore.getInAndEx() == nonCore.getInAndEx()) {
                //Risk(冒险精神)必须相等
                if (thisNonCore.getRisk() == nonCore.getRisk()) {
                    //Reason(理性还是感性)必须相等
                    if (thisNonCore.getReason() == nonCore.getReason()) {
                        //AutoNoMy(自主性)必须相等
                        if (thisNonCore.getAutoNoMy() == nonCore.getAutoNoMy()) {
                            //Secular(世俗程度)必须相等
                            if (thisNonCore.getSecular() == nonCore.getSecular()) {
                                //Investment(投入性)必须相等
                                if (thisNonCore.getInvestment() == nonCore.getInvestment()) {
                                    //Challenge(安逸还是挑战)必须相等
                                    if (thisNonCore.getChallenge() == nonCore.getChallenge()) {
                                        //East(东西方文化偏好)必须相等
                                        if (thisNonCore.getEast() == nonCore.getEast()) {
                                            //Achieve(高成就和低成就需求)必须相等
                                            if (thisNonCore.getAchieve() == nonCore.getAchieve()) {
                                                //Respect(是否会尊重他人)必须相等
                                                if (thisNonCore.getRespect() == nonCore.getRespect()) {
                                                    //Confidence(自信心还是自我怀疑)必须相等
                                                    if (thisNonCore.getConfidence() == nonCore.getConfidence()) {
                                                        //Cure(治愈他人)必须相等
                                                        if (thisNonCore.getCure() == nonCore.getCure()) {
                                                            //MoralSense(道德感)必须相等
                                                            if (thisNonCore.getMoralSense() == nonCore.getMoralSense()) {
                                                                //ResPonSiBiLiTy(责任心)必须相等
                                                                if (thisNonCore.getResPonSiBiLiTy() == nonCore.getResPonSiBiLiTy()) {
                                                                    //WillPower(意志力)必须相等
                                                                    if (thisNonCore.getWillPower() == nonCore.getWillPower()) {
                                                                        //Solitude(安静独处还是热闹)
                                                                        if (thisNonCore.getSolitude() == nonCore.getSolitude()) {
                                                                            //Romantic(散漫还是条理 这里翻译错了)使用+-1算法
                                                                            if ((thisNonCore.getRomantic() + 1) == nonCore.getRomantic() || (thisNonCore.getRomantic() - 1) == nonCore.getRomantic() || thisNonCore.getRomantic() == nonCore.getRomantic()) {
                                                                                //匹配结束 加入匹配成功的集合
                                                                                Success.add(nonCore);
                                                                                System.out.println("匹配成功的队列" + nonCore);
                                                                            }

                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

        });
        return Success;
    }
}
