package com.heiqi.chat.service.impl;

import com.heiqi.chat.entity.Metrics;
import com.heiqi.chat.entity.User;
import com.heiqi.chat.mapper.MetricsMapper;
import com.heiqi.chat.mapper.UserMapper;
import com.heiqi.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private final UserMapper userMapper;
    private final MetricsMapper metricsMapper;

    @Autowired
    public UserServiceImp(UserMapper userMapper, MetricsMapper metricsMapper) {
        this.userMapper = userMapper;
        this.metricsMapper = metricsMapper;
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
    public boolean getUserCharaPro(int UserId) {
        int pro = userMapper.getUserCharaPro(UserId);
        if (pro == 1) {
            return true;
        } else return false;

    }

    @Override
    public boolean getUserInfoPro(int UserId) {
        int pro1 = userMapper.getUserInfoPro(UserId);
        if (pro1 == 1) {
            return true;
        } else if (String.valueOf(pro1).equals("")) {
            return false;
        } else return false;

    }

    @Override
    public int getUserMatchPro(int UserId) {
        return userMapper.getUserMatchPro(UserId);
    }

    @Override
    public List<Metrics> getUserMatch(int UserId) {
        System.out.println("首先开始用户核心属性匹配........................");
        //得到当前用户的经验开放性水平的得分
        int ScoRel = metricsMapper.getMetricsByUserID(UserId).getScoRel();
        //得到当前user的核心匹配属性(对象)
        Metrics thisUserMetrics = metricsMapper.getMetricsByUserID(UserId);
        //设定需要匹配的经验开放性水平总分的区间
        int ScoRelMax = ScoRel + 4;
        int ScoRelMin = ScoRel - 4;
        //建立匹配成功的用户集合
        List<Metrics> successList = new ArrayList<>();
        //找到符合当前用户经验开放水平得分区间的用户集合
        List<Metrics> metricses = metricsMapper.findUserByScoRel(ScoRelMax, ScoRelMin);
        System.out.println("符合当前用户经验开放水平得分总分区间的人数有：" + metricses.size() + "人");
        //遍历集合，在循环中逐一进行筛选，最终将通过筛选匹配的用户放入成功匹配的用户集合
        metricses.forEach((metrics) -> {
            //首先排除自己
            if (metrics.getUserID() != thisUserMetrics.getUserID()) {
                //判断用户的匹配状态
                if ((userMapper.getUserById(metrics.getUserID()).getMatchStatus() == 1) || (userMapper.getUserById(metrics.getUserID()).getMatchStatus() == 0)) {
                    //Freedom匹配:用户有三种状态 0、1、2，分别表示 威权 中立 自由，自由的只能和自由的匹配到一起，中立的可以和中立、威权的匹配到一起，中立和威权都不能匹配到自由
                    if ((thisUserMetrics.getFreedom() == 2 && metrics.getFreedom() == 2) || (thisUserMetrics.getFreedom() == metrics.getFreedom()) || (thisUserMetrics.getFreedom() == 0 && metrics.getFreedom() == 1) || (thisUserMetrics.getFreedom() == 1 && metrics.getFreedom() == 0)) {
                        //Idea理想主义程度匹配:用户评分满分是五分 我们需要在当前用户评分的基础上 进行+1-1或者相等的区间匹配
                        if (((metrics.getIdea() + 1) == thisUserMetrics.getIdea()) || ((metrics.getIdea() - 1) == thisUserMetrics.getIdea()) || (metrics.getIdea() == thisUserMetrics.getIdea())) {
                            //Standard顺从或者独立型性格匹配:用户评分满分是五分 我们需要在当前用户评分的基础上 进行+1-1或者相等的区间匹配
                            if (((metrics.getStandard() + 1) == thisUserMetrics.getStandard()) || ((metrics.getStandard() - 1) == thisUserMetrics.getStandard()) || (metrics.getStandard() == thisUserMetrics.getStandard())) {
                                //ChineseMed是否相信中医匹配:用户三种状态有0、1、2，分别表示 相信 中立 不相信 ，中立的可以和任何类型的匹配到一起，相信的可以和中立、相信匹配，不信的可以和不信、中立匹配，这里我们仍可以用+1-1进行匹配
                                if (((metrics.getChineseMed() + 1) == thisUserMetrics.getChineseMed()) || ((metrics.getChineseMed() - 1) == thisUserMetrics.getChineseMed()) || (metrics.getChineseMed() == thisUserMetrics.getChineseMed())) {
                                    //Star是否相信星座匹配:用户有三种状态 0、1、2，分别表示 相信 中立 不相信，不相信的只能和不相信的匹配到一起，中立的可以和中立、相信的匹配到一起，中立和相信都不能匹配到不相信
                                    if ((metrics.getStar() == 2 && thisUserMetrics.getStar() == 2) || (metrics.getStar() == thisUserMetrics.getStar()) || (metrics.getStar() == 0 && thisUserMetrics.getStar() == 1) || (metrics.getStar() == 1 && thisUserMetrics.getStar() == 0)) {
                                        //FS是否相信风水:用户有三种状态 0、1、2，分别表示 相信 中立 不相信，不相信的只能和不相信的匹配到一起，中立的可以和中立、相信的匹配到一起，中立和相信都不能匹配到不相信
                                        if ((metrics.getFS() == 2 && thisUserMetrics.getFS() == 2) || (metrics.getFS() == thisUserMetrics.getFS()) || (metrics.getFS() == 0 && thisUserMetrics.getFS() == 1) || (metrics.getFS() == 1 && thisUserMetrics.getFS() == 0)) {
                                            //Principle是否认同美国制度匹配:用户有三种状态 0、1、2，分别表示 认同 中立 不认同，认同的只会与认同的匹配在一起，中立的可以和中立、不认同的匹配在一起，不认同的可以和中立、不认同的匹配在一起
                                            if ((metrics.getPrinciple() == 0 && thisUserMetrics.getPrinciple() == 0) || (metrics.getPrinciple() == thisUserMetrics.getPrinciple()) || (metrics.getPrinciple() == 1 && thisUserMetrics.getPrinciple() == 2) || (metrics.getPrinciple() == 2 && thisUserMetrics.getPrinciple() == 1)) {
                                                //将经过筛选的用户放入successList集合
                                                successList.add(metrics);
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
        System.out.println("经过第一轮用户核心属性匹配后得到了" + successList.size() + "人");
        System.out.println("核心属性匹配结束............................................");
        return successList;


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
        return userMapper.updateUserName(UserId, UserName);
    }

    @Override
    public int updateUserAge(int UserId, int Age) {
        return userMapper.updateUserAge(UserId, Age);
    }

    @Override
    public int updateUserAddress(int UserId, String Address) {
        return userMapper.updateUserAddress(UserId, Address);
    }

    @Override
    public int updateUserIdentity(int UserId, String Identity) {
        return userMapper.updateUserIdentity(UserId, Identity);
    }

    @Override
    public int updateUserEducation(int UserId, int Education) {
        return userMapper.updateUserEducation(UserId, Education);
    }

    @Override
    public int updateUserPhoto(int UserId, String Photo) {
        return userMapper.updateUserPhoto(UserId, Photo);
    }

    @Override
    public int updateUserIsTested(int UserId, int IsTested) {
        return userMapper.updateUserIsTested(UserId, IsTested);
    }

    @Override
    public int updateUserIsAuthed(int UserId, int IsAuthed) {
        return userMapper.updateUserIsAuthed(UserId, IsAuthed);
    }

    @Override
    public int updateUserIsLogged(int UserId, int IsLogged) {
        return userMapper.updateUserIsLogged(UserId, IsLogged);
    }

    public int updateUserMatchStatus(int UserId, int MatchStatus) {
        return userMapper.updateUserMatchStatus(UserId, MatchStatus);
    }
}
