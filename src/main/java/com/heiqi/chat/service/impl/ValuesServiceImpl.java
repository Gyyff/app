package com.heiqi.chat.service.impl;

import com.heiqi.chat.Utils.MateUtils;
import com.heiqi.chat.entity.NonCore;
import com.heiqi.chat.entity.User;
import com.heiqi.chat.entity.Values;
import com.heiqi.chat.mapper.ValuesMapper;
import com.heiqi.chat.service.NonCoreService;
import com.heiqi.chat.service.UserService;
import com.heiqi.chat.service.ValuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ValuesServiceImpl implements ValuesService {

    private final ValuesMapper valuesMapper;
    private final NonCoreService nonCoreService;
    private final MateUtils mateUtils;
    private final UserService userService;

    @Autowired
    public ValuesServiceImpl(ValuesMapper valuesMapper, NonCoreService nonCoreService, MateUtils mateUtils, UserService userService) {
        this.valuesMapper = valuesMapper;
        this.nonCoreService = nonCoreService;
        this.mateUtils = mateUtils;
        this.userService = userService;
    }

    @Override
    public Values getValuesUserByUserId(int UserId) {
        return valuesMapper.getValuesUserByUserId(UserId);
    }

    @Override
    public Values getValuesUserByValuesId(int ValuesId) {
        return valuesMapper.getValuesUserByValuesId(ValuesId);
    }

    @Override
    public int insertsValues(Values values) {
        return valuesMapper.insertsValues(values);
    }

    @Override
    public int deleteValuesByUserId(int UserId) {
        return valuesMapper.deleteValuesByUserId(UserId);
    }

    @Override
    public int deleteValuesByValuesId(int ValuesId) {
        return valuesMapper.deleteValuesByValuesId(ValuesId);
    }

    @Override
    public User getUserMatchSimple(int UserId) {
        //得到当前用户的Values对象
        Values thisUserValues = valuesMapper.getValuesUserByUserId(UserId);
        //得到已经筛选过的与当前用户匹配的集合
        List<NonCore> soulFriends = nonCoreService.getSoulFriend(UserId);
        //提前创建一个Double类型的SaveLyMax相似性最大值的变量
        final double[] SaveLyMax = {0.0};
        //提前创建一个匹配成功用户的ID
        AtomicInteger FriendUserID = new AtomicInteger();
        //将当前用户的价值观属性塞入一个数组
        int[] thisArr = {thisUserValues.getA(), thisUserValues.getB(), thisUserValues.getC(), thisUserValues.getD(), thisUserValues.getE(), thisUserValues.getF(), thisUserValues.getG(), thisUserValues.getH(), thisUserValues.getI(), thisUserValues.getJ()};
        //遍历匹配成功的集合
        soulFriends.forEach((friend) -> {
                    //得到匹配成功集合中的其中一个用户的Values对象
                    Values friendValues = valuesMapper.getValuesUserByUserId(friend.getUserID());
                    //将用户属性塞入一个数组
                    int[] friendArr = {friendValues.getA(), friendValues.getB(), friendValues.getC(), friendValues.getD(), friendValues.getE(), friendValues.getF(), friendValues.getG(), friendValues.getH(), friendValues.getI(), friendValues.getJ()};
                    //使用工具类算法得到两组数据的相似性
                    double SaveLy = mateUtils.cosineSimilarity(thisArr, friendArr);
                    //判断是不是第一个进来的数据
                    if (SaveLyMax[0] == 0.0) {
                        SaveLyMax[0] = SaveLy;
                        System.out.println("SaveLy = " + SaveLy);
                        System.out.println("SaveLyMax = " + SaveLyMax[0]);
                    }
                    //判断是否是最大的相似度
                    if (SaveLyMax[0] <= SaveLy) {
                        SaveLyMax[0] = SaveLy;
                        System.out.println("SaveLy = " + SaveLy);
                        System.out.println("SaveLyMax = " + SaveLyMax[0]);
                        FriendUserID.set(friend.getUserID());
                        System.out.println("FriendUserID = " + FriendUserID.get());
                    }

                }
        );
        //转型成int类型的匹配成功的用户
        int SuccessUserID = FriendUserID.get();
        return userService.getUserById(SuccessUserID);
    }

}
